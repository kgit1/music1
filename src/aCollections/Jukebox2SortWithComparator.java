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

public class Jukebox2SortWithComparator {

	ArrayList<Song> songList = new ArrayList<>();

	public static void main(String[] args) {
		new Jukebox2SortWithComparator().go();
	}

	public void go() {
		feelFile();
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		System.out.println("======================");
		Collections.sort(songList, new ArtistCompare());
		System.out.println(songList);
	}

	public void feelFile() {
		try {
			File file = new File("SongList.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("Pink Moon/Nick Drake/7/150\n");
			writer.write("Somersault/Zero 7/5/120\n");
			writer.write("Shiva Moon/Prem Joshua/4/120\n");
			writer.write("Circles/BT/8/120\n");
			writer.write("Deep Chaennel/Afro Celts/7/120\n");
			writer.write("Passenger/Headmix/9/150\n");
			writer.write("Listen/Tahiti 80/10/120");
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
		Song nextSong = new Song(lines[0], lines[1], lines[2], lines[3]);
		songList.add(nextSong);
	}

}
