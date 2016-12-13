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
import java.util.Comparator;

public class Jukebox3 {

	ArrayList<Song> songList = new ArrayList<>();

	public static void main(String[] args) {
		new Jukebox3().go();
	}

	public void go() {
		feelFile();
		getSongs();
		System.out.println(songList);
		// Collections.sort(songList);
		// System.out.println(songList);
		System.out.println("======================");

		// use collections to sort our list
		// but with anonymous class for comparator
		// it will be anonymous class of comparator
		// like
		// new Comparator<Obj>(){
		// public in compare(Obj o1, Obj o2){
		// for strings
		// return o1.compareTo(o2);
		// or
		// for int
		// return (o1>o2)?1:(o1<o2)?-1:0;

		// Collections.sort(songList, new Comparator<Song>() {
		// @Override
		// public int compare(Song o1, Song o2) {
		// return (Integer.parseInt(o1.getBmp()) > Integer
		// .parseInt(o2.getBmp())) ? -1
		// : (Integer.parseInt(o1.getBmp()) < Integer
		// .parseInt(o2.getBmp())) ? 1 : 0;
		// }
		// });
		// System.out.println(songList);

		Collections.sort(songList, new Comparator<Song>() {
			@Override
			public int compare(Song o1, Song o2) {
				// return o1.getArtist().compareTo(o2.getArtist());
				// return o1.getTitle().compareTo(o2.getTitle());

				return (Integer.parseInt(o1.getRating()) > Integer
						.parseInt(o2.getRating())) ? -1
								: (Integer.parseInt(o1.getRating()) < Integer
										.parseInt(o2.getRating())) ? 1 : 0;
			}
		});

		System.out.println(songList);

	}

	public void feelFile() {
		try {
			File file = new File("SongList.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("Pink Moon/HNick Drake/7/150\n");
			writer.write("Somersault/Zero 7/5/120\n");
			writer.write("Shiva Moon/EPrem Joshua/4/120\n");
			writer.write("Circles/DBT/8/120\n");
			writer.write("Deep Chaennel/CAfro Celts/7/120\n");
			writer.write("Passenger/BHeadmix/9/150\n");
			writer.write("Listen/ATahiti 80/10/120");
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
