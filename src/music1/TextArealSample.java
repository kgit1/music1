package music1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
//implement actionListener to listen events
public class TextArealSample implements ActionListener{

	//create text field for rows of text
	JTextArea text;

	public static void main(String[] args) {
		//instantiate our class
		TextArealSample gui = new TextArealSample();
		//run gui
		gui.go();
	}
	
	//method for gui
	public void go(){
		//create and instantiate jframe for window
		JFrame frame = new JFrame();
		//create and instantiate panel to add and manage elements on our window
		JPanel panel = new JPanel();
		//create and instantiate button
		JButton button = new JButton();
		//add listener to button
		button.addActionListener(this);
		//instantiate textArea and add dimensions
		text = new JTextArea(10,20);		
		//put true on wrapping lines when they to long for textArea
		text.setLineWrap(true);
//		panel.add(text);
		
		//create and instantiate scroller panel and put textArea inside
		JScrollPane scroller = new JScrollPane(text);
		//allow vertical scroll
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//forbid horizontal scroll
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//add scroller on panel
		panel.add(scroller);
		
		//add panel on window(frame) to central part
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		//add button on south part
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		//add dimensions for our window(frame)
		frame.setSize(350,300);
		//make window visible
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		text.append("button clicked //create and instantiate //create and instantiate\n");		
	}

}
