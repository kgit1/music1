package aCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {

	ArrayList<String> songList = new ArrayList<>();

	public static void main(String[] args) {
		new Jukebox1().go();
	}

	public void go() {
		feelFile();
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}

	public void feelFile() {
		try {
			File file = new File("SongList.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("Pink Moon/Nick Drake\n");
			writer.write("Somersault/Zero 7\n");
			writer.write("Shiva Moon/Prem Joshua\n");
			writer.write("Circles/BT\n");
			writer.write("Deep Chaennel/Afro Celts\n");
			writer.write("Passenger/Headmix\n");
			writer.write("Listen/Tahiti 80");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void getSongs() {
		try {
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void addSong(String lineToParse) {
		String[] lines = lineToParse.split("/");
		songList.add(lines[0]);
	}

}
