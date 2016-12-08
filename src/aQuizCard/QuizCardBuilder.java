package aQuizCard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardBuilder {
	//textField many rows
	private JTextArea question;
	//textField many rows
	private JTextArea answer;
	//array of quiz cards
	private ArrayList<QuizCard> cardList;
	//frame(window)
	private JFrame frame;

	public static void main(String[] args) {
		//instantiate class
		QuizCardBuilder builder = new QuizCardBuilder();
		//run method to buil gui
		builder.go();
	}

	//go method
	public void go() {

		//create gui
		//instantiate frame(window) and give it title
		frame = new JFrame("Quiz Card Builder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//instantiate panel on which all our elements will be
		JPanel mainPanel = new JPanel();
		//instantiate font with values
		Font bifFont = new Font("sanserif", Font.BOLD, 24);
		//instantiate text field 6 rows 20 symbols per row
		question = new JTextArea(6, 20);
		//put true on wrapping lines when they to long for textArea
		question.setLineWrap(true);
		//put true on wrapping lines on words boundaries(whitespaces)
		question.setWrapStyleWord(true);
		//set font for our text field
		question.setFont(bifFont);

		//create and instantiate scroller panel and put textArea inside
		JScrollPane qScroller = new JScrollPane(question);
		//allow vertical scroll
		qScroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//forbid horizontal scroll
		qScroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		//instantiate text field 6 rows 20 symbols per row
		answer = new JTextArea(6, 20);
		//put true on wrapping lines when they to long for textArea
		answer.setLineWrap(true);
		//put true on wrapping lines on words boundaries(whitespaces)
		answer.setWrapStyleWord(true);
		//set font for our text field
		answer.setFont(bifFont);
		
		//create and instantiate scroller panel and put textArea inside
		JScrollPane aScroller = new JScrollPane(answer);
		//allow vertical scroll
		aScroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//forbid horizontal scroll
		aScroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		//instantiate button with title
		JButton nextButton = new JButton("Next Card");

		//instantiate cardList with ArrayList
		cardList = new ArrayList<>();

		//instantiate label with title
		JLabel qLabel = new JLabel("Question");
		//instantiate label with title
		JLabel aLabel = new JLabel("Answer");

		//add label on panel
		mainPanel.add(aLabel);
		//add text field with scroller on panel
		mainPanel.add(qScroller);
		//add label on panel
		mainPanel.add(aLabel);
		//add text field with scroller on panel
		mainPanel.add(aScroller);
		//add button on panel
		mainPanel.add(nextButton);
		//add action listener to our button
		nextButton.addActionListener(new NextCardListener());
		
		//instantiate menu bar
		JMenuBar menuBar = new JMenuBar();
		//instantiate menu list  with title
		JMenu fileMenu = new JMenu("File");
		//instantiate menu paragraph with title
		JMenuItem newMenuItem = new JMenuItem("New");
		//instantiate menu paragraph with title
		JMenuItem saveMenuItem = new JMenuItem("Save");

		//add listener to menu paragraph
		newMenuItem.addActionListener(new NewMenuListener());
		//add listener to menu paragraph
		saveMenuItem.addActionListener(new SaveMenuListener());

		//add paragraph to menu
		fileMenu.add(newMenuItem);
		//add paragraph to menu
		fileMenu.add(saveMenuItem);
		//add menu to menu bar
		menuBar.add(fileMenu);
		//add menu bar to frame(window)
		frame.setJMenuBar(menuBar);
		//add main panel to frame(window)
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		//set frame(window) dimensions
		frame.setSize(500, 600);
		//make frame(window) visible
		frame.setVisible(true);
	}

	//listener class, to be transmited inside listener on gui element
	public class NextCardListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//instantiate QuizCard
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			//add card to list
			cardList.add(card);
			//clear card
			clearCard();
		}
	}

	//listener class, to be transmited inside listener on gui element
	public class SaveMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//instantiate QuizCard
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			//add card to list
			cardList.add(card);

			//save file window
			//all work with choosing file and navigation
			//JFileChooser will do for you
			JFileChooser fileSave = new JFileChooser();
			//send save file window to frame
			fileSave.showSaveDialog(frame);
			//program stopped and save window appears 
			saveFile(fileSave.getSelectedFile());
		}
	}

	//listener class, to be transmited inside listener on gui element
	public class NewMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//clear ArrayList
			cardList.clear();
			//clear card
			clearCard();
		}
	}

	//method - empty text field(fill them with blank String)
	private void clearCard() {
		//make text field empty
		question.setText("");	
		//make text field empty
		answer.setText("");
		//put cursor inside chosen text field
		question.requestFocus();
	}

	//method - save file
	private void saveFile(File file) {
		try {
			//BufferedWriter - knows how to write to file
			//FileWriter - knows how to connect to file
			//File - represents file
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			//cycle - write lines to file
			for(QuizCard card: cardList){
				//write given line to file
				writer.write(card.getQuestion()+"/");
				//write given line to file
				writer.write(card.getAnswer()+"\n");				
			}
			//close writer, will close FileWriter too
			//because when higher writer closing, he closes lower writer too
			writer.close();
		} catch (IOException e) {
			System.out.println("couldnt write the cardList out");
			e.printStackTrace();
		}
	}

}
