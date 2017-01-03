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

	public Staff(String... titles) {
		add(titles);
	}

	public boolean positionAvaileble(String title) {
		for (Position position : this) {
			if (position.getTitle().equals(title)
					&& position.getPerson() == Person.NULL) {
				return true;
			}
		}
		return false;
	}

	public void fillPosition(String title, Person hire) {
		for (Position position : this) {
//			System.out.println(position+"=============");
			if (position.getTitle().equals(title)
					&& position.getPerson() == Person.NULL) {
				position.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException(
				"Position " + title + " is not available");
	}

	public static void main(String[] args) {
		Staff staff = new Staff("President", "CTO", "Marketing manager",
				"Product Manager", "Project Lead", "Software Engeneer",
				"Software Engeneer", "Software Engeneer", "Software Engeneer",
				"Test Engeneer");
//		printStaff(staff);
//		System.out.println("====================");
//		sleeep();
		staff.fillPosition("President",
				new Person("Me", "Last", "The Top, Lonely Art"));
//		printStaff(staff);
//		sleeep();
		staff.fillPosition("CTO", new Person("Janet", "Planner", "the Burbs"));
//		printStaff(staff);
//		sleeep();
		if (staff.positionAvaileble("Software Engeneer")) {
			staff.fillPosition("Software Engeneer",
					new Person("Bob", "Coder", " Bright Ligth City"));
		}
		if (staff.positionAvaileble("Software Engeneer")) {
			staff.fillPosition("Software Engeneer",
					new Person("Bob1", "Coder", " Bright Ligth City"));
		}
		if (staff.positionAvaileble("Software Engeneer")) {
			staff.fillPosition("Software Engeneer",
					new Person("Bob2", "Coder", " Bright Ligth City"));
		}
		printStaff(staff);
	}

	public static void printStaff(Staff staff) {
		for (Position position : staff) {
			System.out.println(position);
		}
	}

	public static void sleeep() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
