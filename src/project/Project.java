package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project {
	JFrame frame;
	int array[];
	int array2[];
	int array3[];
	int select = 1;
	boolean run = true;
	MyDrawP drawP;

	public static void main(String[] args) {
		Project project = new Project();
		project.array = project.readArray();
		System.out.println(Arrays.toString(project.array));
		project.gui();

		// for (int i = 0; i < 50; i++) {
		// System.out.println("g.fillRect(" + (i * 15 + 10) + ", 500 - array["
		// + i + "] * 10, 10, array[" + i + "] * 10);");
		// }
	}

	public void gui() {
		frame = new JFrame("Project 'O'");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Click");
		button.addActionListener(new MyButtonListener());
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.RED);
		mainPanel.add(button);

		drawP = new MyDrawP();

		frame.getContentPane().add(BorderLayout.NORTH, mainPanel);
		frame.getContentPane().add(BorderLayout.CENTER, drawP);
		frame.setSize(780, 580);
		frame.setVisible(true);
		System.out.println(Thread.currentThread().getName());

		while (true) {
			if (select == 1) {
				run = true;
				array = readArray();
				sortSilly(array);
			} else if (select == 2) {
				run = true;
				sortBubble(array);
				array = readArray();
			} else if (select == 3) {
				run = true;
				sortSelection(array);
				array = readArray();
			}
		}
	}

	public void drawRepainter() {
		drawP.repaint();
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortSilly(int[] array) {
		int counter = 0;
		boolean end = false;
		while (!end) {
			if (!run) {
				break;
			}
			end = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					counter++;
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					drawRepainter();

					end = false;
					break;
				}

				if (!run) {
					break;
				}
			}
		}
		System.out.println("Counter:" + counter + "\t\t\t\tSilly Sort");
	}

	// sort array with Bubble Sort dragging min to start
	public void sortBubble(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			if (!run) {
				break;
			}
			for (int j = i + 1; j < array.length; j++) {
				if (min > array[j]) {
					counter++;
					min = array[j];
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					drawRepainter();
				}
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
		int counter = 0;
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
			}
			// if min not equals to min - switch arr[i] with arr[min]
			if (i != min) {
				counter++;
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

	class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			run = false;
			if (select != 3) {
				select = select + 1;
			} else {
				select = 1;
			}

		}

	}

	class MyDrawP extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(5, 0, 755, 510);

			// System.out.println("repainter");
			// System.out.println(Thread.currentThread().getName());
			g.setColor(Color.BLUE);
			for (int i = 0; i < 50; i++) {
				g.fillRect(i * 15 + 10, 500 - array[i] * 10, 10, array[i] * 10);
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
