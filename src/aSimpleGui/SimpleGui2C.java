package aSimpleGui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui2C implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		SimpleGui2C gui = new SimpleGui2C();
		gui.go();

	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Change color");
		button.addActionListener(this);

		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.repaint();

	}

}
