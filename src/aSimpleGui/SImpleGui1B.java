package aSimpleGui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//realize ActionListener interface to make button event
public class SImpleGui1B implements ActionListener {
	JButton button;

	public static void main(String[] args) {
		SImpleGui1B gui = new SImpleGui1B();
		gui.go();
	}

	public void go() {
		// window
		JFrame frame = new JFrame();
		// button with message
		button = new JButton("Click me");

		// register button to aCtionListener
		button.addActionListener(this);

		// add button to window, with no additonal argument so will be added to
		// the center
		// frame.getContentPane().add(button);
		
		//add button to window East side
		frame.getContentPane().add(BorderLayout.WEST, button);
		// make program close on window close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set window size
		frame.setSize(300, 300);
		// set window visible
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		button.setText("I've been clicked");

	}

}
