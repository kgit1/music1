package aSimpleGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//move X animation
public class TwoButtons1 {

	JFrame frame;
	JLabel label;
	int x = 70;
	int y = 70;

	public static void main(String[] args) {
		TwoButtons1 gui = new TwoButtons1();
		gui.go();
	}

	public void go() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton colorButton = new JButton("Change circle");
		colorButton.addActionListener(new ColorListener());

		JButton labelButton = new JButton("Change label");
		labelButton.addActionListener(new LabelListener());

		label = new JLabel("" + x);
		MyDrawPanel drawPanel = new MyDrawPanel();
		MyDrawPanel1 drawpanel1 = new MyDrawPanel1();

		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		// frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.CENTER, drawpanel1);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);

		frame.setSize(600, 600);
		frame.setVisible(true);

		for (int i = 0; i < 530; i++) {
			if (i < 130) {
				x++;
				y++;
			} else if (i < 260) {
				x--;
				y++;
			} else if (i < 400) {
				x = i - 70;
				// x--;
				y = i - 70;
				// y--;
			} else if (i == 400) {
				x = i - 200;
				y = i - 200;
			} else {
				y--;
				x++;
			}
//			label.setText(" " + x);
			drawpanel1.repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e) {
			}
		}
	}

	class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Ouch!!");
		}

	}

	class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
	}

	class MyDrawPanel1 extends JPanel {
		public void paintComponent(Graphics g) {
			// g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.GREEN);
			g.fillRect(x, y, 40, 40);
		}
	}

}
