package project;

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

public class Project {
	JFrame frame;
	int array[];
	int counter;
	int counterTimes;
	int select = 1;
	int sleepTime = 50;
	JLabel laberCounter;
	JLabel laberCounterTimes;
	JLabel labelSleep;
	JLabel labelSelect;
	boolean run = true;
	boolean cycle = true;
	MyDrawP drawP;

	public static void main(String[] args) {
		Project project = new Project();
		project.array = project.readArray();

		// project.bsort(project.array);

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
		button1.addActionListener(new MyStopButtonListener());
		JButton button2 = new JButton("SpeedUP");
		button2.addActionListener(new MySpeedUpButtonListener());
		JButton button3 = new JButton("SpeedDW");
		button3.addActionListener(new MySpeedDownButtonListener());

		Box box = new Box(BoxLayout.Y_AXIS);
		Box box1 = new Box(BoxLayout.Y_AXIS);
		Box box2 = new Box(BoxLayout.X_AXIS);
		Box box3 = new Box(BoxLayout.Y_AXIS);

		laberCounter = new JLabel(counter + " ");
		laberCounterTimes = new JLabel(counterTimes + " ");
		box.add(laberCounter);
		box.add(laberCounterTimes);
		box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 120));

		labelSleep = new JLabel("Sleep " + sleepTime);
		labelSelect = new JLabel("Select " + select);

		JLabel labelCounterField = new JLabel("Element moved ");
		JLabel labelCounterTimesField = new JLabel("Element checked ");
		box1.add(labelCounterField);
		box1.add(labelCounterTimesField);
		box1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

		box3.add(labelSleep);
		box3.add(labelSelect);
		box2.add(box);
		box2.add(box1);
		box2.add(box3);
		box2.add(button);
		box2.add(button1);
		box2.add(button2);
		box2.add(button3);

		JLabel labelSort = new JLabel("Silly Sort");
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(box2, BorderLayout.EAST);
		mainPanel.add(labelSort, BorderLayout.WEST);

		drawP = new MyDrawP();

		frame.getContentPane().add(BorderLayout.NORTH, mainPanel);
		frame.getContentPane().add(BorderLayout.CENTER, drawP);

		frame.setSize(770, 590);
		frame.setMinimumSize(new Dimension(770, 590));
		frame.setVisible(true);

		System.out.println(Arrays.toString(array));

		while (true) {
			System.out.println("while");
			if (select == 1 && cycle) {
				run = true;
				labelSort.setText("Silly Sort");
				array = readArray();
				sortSilly(array);
			} else if (select == 2 && cycle) {
				run = true;
				labelSort.setText("Bubble Sort");
				array = readArray();
				sortBubble(array);
			} else if (select == 3 && cycle) {
				run = true;
				labelSort.setText("Selection Sort");
				array = readArray();
				sortSelection(array);
			} else if (select == 4 && cycle) {
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
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortSilly(int[] array) {
		counter = 0;
		counterTimes = 0;
		boolean end = false;
		while (!end) {
			if (!run || !cycle) {
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
				if (!run || !cycle) {
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
			if (!run || !cycle) {
				break;
			}
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					counter++;
					laberCounter.setText(counter + "");
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					drawRepainter();
				}
				counterTimes++;
				laberCounterTimes.setText(counterTimes + "");
				if (!run || !cycle) {
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
				if (!run || !cycle) {
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
			if (!run || !cycle) {
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
			if (!run || !cycle) {
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

	public void bsort(int[] array) {

		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				System.out.println("j " + j);
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}

		System.out.println(Arrays.toString(array));

		// boolean change = true;
		// System.out.println(Arrays.toString(array));
		// while (change) {
		// change = false;
		// for (int i = 0; i < array.length-1; i++) {
		// if (array[i] > array[i + 1]) {
		// int tmp = array[i + 1];
		// array[i + 1] = array[i];
		// array[i] = tmp;
		// change = true;
		// }
		// }
		// }
		// System.out.println(Arrays.toString(array));

		// counter = 0;
		// counterTimes = 0;
		// for (int i = 0; i < array.length - 1; i++) {
		// int min = array[i];
		// if (!run || !cycle) {
		// break;
		// }
		// for (int j = i + 1; j < array.length; j++) {
		// if (min > array[j]) {
		// counter++;
		// laberCounter.setText(counter + "");
		// min = array[j];
		// int tmp = array[i];
		// array[i] = array[j];
		// array[j] = tmp;
		// drawRepainter();
		// }
		// counterTimes++;
		// laberCounterTimes.setText(counterTimes + "");
		// if (!run || !cycle) {
		// break;
		// }
		// }
		// }
		// System.out.println("Counter:" + counter
		// + "\t\t\t\tBubble Sort dragging min to start");
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
			labelSelect.setText("Select " + select + " ");
		}
	}

	class MyStopButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cycle) {
				cycle = false;
				System.out.println("Cycle = false");
			} else if (!cycle) {
				cycle = true;
				System.out.println("Cycle = true");
			}
		}

	}

	class MySpeedUpButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (sleepTime > 50) {
				sleepTime = sleepTime - 50;
			}
			labelSleep.setText("Sleep " + sleepTime);
		}
	}

	class MySpeedDownButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (sleepTime < 400) {
				sleepTime = sleepTime + 50;
			}
			labelSleep.setText("Sleep " + sleepTime);
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

// merge sort

// public class Mergesort {
// private int[] numbers;
// private int[] helper;
//
// private int number;
//
// public void sort(int[] values) {
// this.numbers = values;
// number = values.length;
// this.helper = new int[number];
// mergesort(0, number - 1);
// }
//
// private void mergesort(int low, int high) {
// // check if low is smaller then high, if not then the array is sorted
// if (low < high) {
// // Get the index of the element which is in the middle
// int middle = low + (high - low) / 2;
// // Sort the left side of the array
// mergesort(low, middle);
// // Sort the right side of the array
// mergesort(middle + 1, high);
// // Combine them both
// merge(low, middle, high);
// }
// }
//
// private void merge(int low, int middle, int high) {
//
// // Copy both parts into the helper array
// for (int i = low; i <= high; i++) {
// helper[i] = numbers[i];
// }
//
// int i = low;
// int j = middle + 1;
// int k = low;
// // Copy the smallest values from either the left or the right side back
// // to the original array
// while (i <= middle && j <= high) {
// if (helper[i] <= helper[j]) {
// numbers[k] = helper[i];
// i++;
// } else {
// numbers[k] = helper[j];
// j++;
// }
// k++;
// }
// // Copy the rest of the left side of the array into the target array
// while (i <= middle) {
// numbers[k] = helper[i];
// k++;
// i++;
// }
//
// }
// }

// shellsort

// class Shellsort {
// public static void main(String args[]) {
// int[] array = new int[] { 3, 2, 5, 4, 1 };
//
// int i1, i, j, increment, temp, number_of_elements = array.length;
// /* Shell Sort Program */
// for (increment = number_of_elements / 2; increment > 0; increment /= 2)
// {
// for (i = increment; i < number_of_elements; i++)
// {
// temp = array[i];
// for (j = i; j >= increment; j -= increment)
// {
// if (temp < array[j - increment]) {
// array[j] = array[j - increment];
// } else {
// break;
// }
// }
// array[j] = temp;
// }
// }
// System.out.println("After Sorting:");
// for (i1 = 0; i1 < 5; i1++) {
// System.out.println(array[i1]);
// }
// }
// }

/// **
// * Shellsort, using a sequence suggested by Gonnet.
// * @param a an array of Comparable items.
// */
// public static void shellsort( Comparable [ ] a )
// {
// for( int gap = a.length / 2; gap > 0;
// gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
// for( int i = gap; i < a.length; i++ )
// {
// Comparable tmp = a[ i ];
// int j = i;
//
// for( ; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
// a[ j ] = a[ j - gap ];
// a[ j ] = tmp;
// }
// }

//comb sort

// The basic idea is to eliminate turtles, or small values near the end of the
// list, since in a bubble
// sort these slow the sorting down tremendously.Rabbits, large values around
// the
// beginning of the list,do not pose a problem in bubble sort. In bubble sort,
// when any two elements are compared, they always have
//
// a gap (distance from each other) of 1. The basic idea of comb sort is that
// the gap can be much more than 1. The inner loop of bubble sort, which does
// the actual swap, is modified such that gap between swapped elements goes down
// (for each iteration of outer loop) in steps of a "shrink factor" k: [ n/k,
// n/k2, n/k3, ..., 1 ].
//
// The gap starts out as the length of the list n being sorted divided by the
// shrink factor k (generally 1.3; see below) and one pass of the aforementioned
// modified bubble sort is applied with that gap. Then the gap is divided by the
// shrink factor again, the list is sorted with this new gap, and the process
// repeats until the gap is 1. At this point, comb sort continues using a gap of
// 1 until the list is fully sorted. The final stage of the sort is thus
// equivalent to a bubble sort, but by this time most turtles have been dealt
// with, so a bubble sort will be efficient.
//
// The shrink factor has a great effect on the efficiency of comb sort. k = 1.3
// has been suggested as an ideal shrink factor by the authors of the original
// article after empirical testing on over 200,000 random lists. A value too
// small slows the algorithm down by making unnecessarily many comparisons,
// whereas a value too large fails to effectively deal with turtles.
//
// The pattern of repeated sorting passes with decreasing gaps is similar to
// Shellsort, but in Shellsort the array is sorted completely each pass before
// going on to the next-smallest gap. Comb sort's passes do not completely sort
// the elements. This is the reason that Shellsort gap sequences have a larger
// optimal shrink factor of about 2.2.
