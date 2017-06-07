import javax.swing.*;
import java.awt.*;

public class SampleMenuScreen extends JFrame
{
	private JFrame frame;
	private SampleMenuPanel panel;

	public SampleMenuScreen()
	{
		//create the frame
		frame = new JFrame("Welcome to Comp Sci Wars!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create the panel
		panel = new SampleMenuPanel();
		panel.setPreferredSize(new Dimension(900, 900));

		frame.getContentPane().add(panel);
	}

	public void display()
	{
		frame.pack();
		frame.setVisible(true);
	}
}