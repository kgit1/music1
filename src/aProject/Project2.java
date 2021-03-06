package aProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project2 {
	JFrame frame;
	int array[];
	int counter;
	int counterTimes;
	int select = 1;
	JLabel laberCounter;
	JLabel laberCounterTimes;
	boolean run = true;
	MyDrawP drawP;

	public static void main(String[] args) {
		Project2 project = new Project2();
		project.array = project.readArray();
		project.gui();

	}

	public void gui() {
		frame = new JFrame("Project 'O'");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.RED);

		JButton button = new JButton("Change");
		button.addActionListener(new MyButtonListener());
		
		JButton button1 = new JButton("Stop");
		button.addActionListener(new MyStopButtonListener());

		Box box = new Box(BoxLayout.Y_AXIS);
		Box box1 = new Box(BoxLayout.Y_AXIS);
		Box box2 = new Box(BoxLayout.X_AXIS);

		laberCounter = new JLabel(counter + " ");
		laberCounterTimes = new JLabel(counterTimes + " ");
		box.add(laberCounter);
		box.add(laberCounterTimes);
		box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 120));

		JLabel labelCounterField = new JLabel("Element moved ");
		JLabel labelCounterTimesField = new JLabel("Element checked ");
		box1.add(labelCounterField);
		box1.add(labelCounterTimesField);
		box1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		
		box2.add(box);
		box2.add(box1);
		box2.add(button);
		box2.add(button1);

		JLabel labelSort = new JLabel("Silly Sort");
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(box2,BorderLayout.EAST);
		mainPanel.add(labelSort,BorderLayout.WEST);

		drawP = new MyDrawP();

		frame.getContentPane().add(BorderLayout.NORTH, mainPanel);
		frame.getContentPane().add(BorderLayout.CENTER, drawP);

		frame.setSize(770, 590);
		frame.setMinimumSize(new Dimension(770, 590));
		frame.setVisible(true);

		System.out.println(Arrays.toString(array));

		while (true) {
			if (select == 1) {
				run = true;
				labelSort.setText("Silly Sort");
				array = readArray();
				sortSilly(array);
			} else if (select == 2) {
				run = true;
				labelSort.setText("Bubble Sort");
				array = readArray();
				sortBubble(array);
			} else if (select == 3) {
				run = true;
				labelSort.setText("Selection Sort");
				array = readArray();
				sortSelection(array);
			} else {
				run = true;
				labelSort.setText("Gnome Sort");
				array = readArray();
				sortGnome(array);
			}
		}
	}

	public void drawRepainter() {
		try {
			drawP.repaint();
			Thread.sleep(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortSilly(int[] array) {
		counter = 0;
		counterTimes = 0;
		boolean end = false;
		while (!end) {
			if (!run) {
				break;
			}
			end = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					counter++;
					laberCounter.setText(counter + "");
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					drawRepainter();

					end = false;
					break;
				}
				counterTimes++;
				laberCounterTimes.setText(counterTimes + "");
				if (!run) {
					break;
				}
			}
		}
		System.out.println("Counter:" + counter + "\t\t\t\tSilly Sort");
	}

	// sort array with Bubble Sort dragging min to start
	public void sortBubble(int[] array) {
		counter = 0;
		counterTimes = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			if (!run) {
				break;
			}
			for (int j = i + 1; j < array.length; j++) {
				if (min > array[j]) {
					counter++;
					laberCounter.setText(counter + "");
					min = array[j];
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					drawRepainter();
				}
				counterTimes++;
				laberCounterTimes.setText(counterTimes + "");
				if (!run) {
					break;
				}
			}
		}
		System.out.println("Counter:" + counter
				+ "\t\t\t\tBubble Sort dragging min to start");
	}

	// sort array with Selection Sort
	public void sortSelection(int[] array) {
		counter = 0;
		counterTimes = 0;
		for (int i = 0; i < array.length - 1; i++) {
			// hold index of minimal number
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (!run) {
					break;
				}
				if (array[j] < array[min]) {
					// if arr[j] < arr[min], assign j to mi
					min = j;
				}
				counterTimes++;
				laberCounterTimes.setText(counterTimes + "");
			}
			// if min not equals to min - switch arr[i] with arr[min]
			if (i != min) {
				counter++;
				laberCounter.setText(counter + "");
				int tmp = array[min];
				array[min] = array[i];
				array[i] = tmp;
				drawRepainter();
			}
			if (!run) {
				break;
			}
		}
		System.out.println("Counter: " + counter + "\t\t\t\tSelection Sort");
	}

	public void sortGnome(int[] array) {
		counter = 0;
		counterTimes = 0;
		int i = 1;
		int j = 2;
		while (i < array.length) {
			if (!run) {
				break;
			}
			if (array[i - 1] < array[i]) {
				i = j;
				j = j + 1;
				counter++;
				laberCounter.setText(counter + "");
			} else {
				int tmp = array[i - 1];
				array[i - 1] = array[i];
				array[i] = tmp;
				i = i - 1;
				counter++;
				laberCounter.setText(counter + "");
				counterTimes++;
				laberCounterTimes.setText(counterTimes + "");
				drawRepainter();
				if (i == 0) {
					i = j;
					j = j + 1;
				}
			}
		}
		System.out.println("Counter:" + counter + "\t\t\t\tGnome Sort");
	}

	class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			run = false;
			if (select != 4) {
				select = select + 1;
			} else {
				select = 1;
			}
		}
	}
	
	class MyStopButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}		
	}

	class MyDrawP extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 755, 525);

			g.setColor(Color.BLUE);
			for (int i = 0; i < 50; i++) {
				g.fillRect(i * 15 + 5, 510 - array[i] * 10, 10, array[i] * 10);
			}
		}
	}

	// get array from file
	public int[] readArray() {
		int[] array = new int[50];
		File file = new File("TestArray.txt");
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			array = (int[]) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}

}
