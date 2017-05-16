import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SampleGameButton extends JButton implements ActionListener
{
	private SampleGameFrame frame;
		
	public SampleGameButton(String str)
	{
		super(str);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		frame = new SampleGameFrame();
		frame.display();
	}
}