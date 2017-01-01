package aFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//create interface Factory with generic T - means T equals any type we give 
//to method
interface Factory<T> {
	// same T for method return type, T - means any glass we giving
	T create();
}

// create class part - parent for our classes
class Part {
	// overrided method toString() to get names from our part(classes)
	public String toString() {
		return getClass().getSimpleName();
	}

	// create static List of classes which extending from Part class
	static List<Factory<? extends Part>> partFactories = new ArrayList<>();
	// make static initialization
	// will initialize our list with different parts
	static {
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
	}

	private static Random rand = new Random(47);

	// method creates instance of random Class
	// by taking random item from our list of parts
	// than that random item invokes method create
	// (every of our classes which presents in list - are children of Part
	// and has overloaded create method)
	// JVM gets type of that random Class - and search create() method which
	// returns same type of Class and invokes this method
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
	public static class Factory implements aFactory.Factory<FuelFilter> {
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class Factory implements aFactory.Factory<AirFilter> {
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinFilter extends Filter {
	public static class Factory implements aFactory.Factory<CabinFilter> {
		public CabinFilter create() {
			return new CabinFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class Factory implements aFactory.Factory<OilFilter> {
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	public static class Factory implements aFactory.Factory<FanBelt> {
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements aFactory.Factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements aFactory.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}

public class RegisteredFactory {
	HashMap<String, Integer> listOfParts = new HashMap<>();
	List<Part> list = new ArrayList<>();

	public void c(List <Part> list) {
		Integer quantity;
		for (Part part : list) {
			
		}
	}

	public static void main(String[] args) {
		RegisteredFactory rf = new RegisteredFactory();
//		rf.c("");
		for (int i = 0; i < 20; i++) {
			rf.list.add(Part.createRandom());
		}
		System.out.println(rf.list);

	}

}
