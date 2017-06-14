package sOption.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.Assets;

public class Item 
{
	public static Item[] items = new Item[256];
	// Class
	
	public static final int ITEMWIDTH = 64, ITEMHEIGHT = 64;
	
	protected Connector connector;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected Rectangle bounds;
	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int id, Connector connector){
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.connector = connector;
		
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		
		items[id] = this;
	}
	
	public void tick(){
		if(connector.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
			pickedUp = true;
			//connector.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public void render(Graphics g){
		if(connector == null)
			return;
		render(g, (int) (x - connector.getGameCamera().getxOffset()), (int) (y - connector.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int count){
		Item i = new Item(texture, name, id, connector);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(texture, name, id, connector);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	// Getters and Setters
	
	public Connector getConnector() {
		return connector;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}
}
