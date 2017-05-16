import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SampleGameFrame1 extends JFrame
{
	private JFrame frame;
	private SampleGamePanel panel;
	private SampleGamePanel panel2;
	private SampleMenuPanel panel3;

	public SampleGameFrame1()
	{
		// create the frame
		frame = new JFrame("Sample Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create the panel
		panel = new SampleGamePanel();
		panel.setPreferredSize(new Dimension(700, 700));
		//panel3.setBackground(Color.black);
		//panel2 = new SampleGamePanel();
		//panel2.setPreferredSize(new Dimension(700, 700));
		//panel.setBorder(BorderFactory.createLineBorder(Color.blue, 5, true));

		// add panel to frame
		frame.getContentPane().add(panel);
		//frame.getContentPane().add(panel2);
	}

	public void display()
	{
		frame.pack();
		frame.setVisible(false);
	}
}