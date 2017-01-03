package nullPerson;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {

	public void add(String title, Person person) {
		add(new Position(title, person));
	}

	public void add(String... titles) {
		for (String title : titles) {
			add(new Position(title));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
