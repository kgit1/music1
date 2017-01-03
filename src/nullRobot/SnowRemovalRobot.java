package nullRobot;

import java.util.Arrays;
import java.util.List;

import sun.applet.Main;

public class SnowRemovalRobot implements Robot {

	String name;

	public SnowRemovalRobot(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String model() {
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> operations() {
		return Arrays.asList(new Operation() {
			public String description() {
				return name + " can remove snow";
			}

			public void command() {
				System.out.println(name + " removes snow");
			}
		}, new Operation() {
			public String description() {
				return name + " can brake ice";
			}

			public void command() {
				System.out.println(name + " brakes ice");
			}
		}, new Operation() {
			public String description() {
				return name + " can clean uu the roof";
			}

			public void command() {
				System.out.println(name + " cleans up the roof");
			}
		});
	}
	
	public static void main(String[] args) {
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}

}
