package aSimpleGui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui {

	public static void main(String[] args) {
		// window
		JFrame frame = new JFrame();
		// button
		JButton button = new JButton("click me");
		// will stop programm on window close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add content(button) to window
		frame.getContentPane().add(button);

		// set window size
		frame.setSize(300, 300);

		// make window visible
		frame.setVisible(true);

	}

	public void changeIt(JButton button) {
		button.setText("Ive been clicked");
	}

}
