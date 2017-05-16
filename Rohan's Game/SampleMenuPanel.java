import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class SampleMenuPanel extends JPanel
{
	private SampleGameButton button;
	private SampleGameButton button2;
	private SampleGameButton button3;
	private JLabel label;
	private Image bg;

	public SampleMenuPanel()
	{
		bg = new ImageIcon("Pictures\\BG.png").getImage();
		setLayout(null);
		button = new SampleGameButton("Play");
		button.setBounds(200, 500, 200, 120);
		add(button);
		label = new JLabel("Link's Adventures");
		//add(label);
		setLayout(null);
		//label.setFont(new Font("Comic Sans", Font.PLAIN, 56));
		//label.setForeground(Color.red);
		//label.setBounds(250, 120, 500, 125);
		button2 = new SampleGameButton("Instructions");
		button2.setBounds(500, 500, 200, 120);
		add(button2);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 900, 900);
		g.drawImage(bg, 90, 10, null);
	}
}