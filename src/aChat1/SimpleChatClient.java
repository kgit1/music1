package aChat1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClient {

	JTextField outgoing;
	PrintWriter writer;
	Socket socket;

	public static void main(String[] args) {
		new SimpleChatClient().go();
	}

	public void go() {
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	
	private void setUpNetworking(){
		try{
			socket = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("networking established");
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public class SendButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				writer.println(outgoing.getText());
				writer.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
			
		}
		
	}

}























