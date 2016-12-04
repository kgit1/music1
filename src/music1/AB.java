package music1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//draw window with button which changing text from A to B and vice versa 
public class AB {
	//window
	JFrame frame;
	//button
	JButton button;

	public static void main(String[] args) {
		//get class instance
		AB gui = new AB();
		//run gui method to draw window and all on it
		gui.go();
	}
	
	//gui method to draw window and all on it
	public void go(){
		//instantiate window
		frame = new JFrame();
		//set on close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//instantiate button
		button= new JButton("A");
		//add listener to button
		//our nested class with listener interface implemented
		//tell to addActionListener what to do on event
		//so we pass his instance to this method
		button.addActionListener(new BListener());
		
		//draw button on panel in south sector
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		//set windows width and height
		frame.setSize(400, 500);
		//make window visible
		frame.setVisible(true);
	}
	
	//implement ActionListener interface to give our class ability
	//to tell to actionListener method what to do on event
	class BListener implements ActionListener{

		//our method which tell what to do on event
		@Override
		public void actionPerformed(ActionEvent e) {
			if(button.getText().equals("A")){
				button.setText("B");
			}else{
				button.setText("A");
			}			
		}		
	}

}
