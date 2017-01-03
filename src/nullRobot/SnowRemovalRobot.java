package nullRobot;

import java.util.Arrays;
import java.util.List;

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
				return name + " removes snow";
			}

			public void command() {
				System.out.println(name + " removes snow");
			}
		});
	}

}
