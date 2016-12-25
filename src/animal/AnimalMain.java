package animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalMain {

	public static void main(String[] args) {
		List<Animal> animalList = new ArrayList<>();
		ArrayList<Animal> animalArray = new ArrayList<>();

		Canine canine = new Canine();
		Feline feline = new Feline();
		Dog dog = new Dog();
		Cat cat = new Cat();

		Animal canine1 = new Canine();
		Animal feline1 = new Feline();
		Animal dog1 = new Dog();
		Animal cat1 = new Cat();

		anAnimal(dog);

//		anAnimalArray(animalList);
		anAnimalArray(animalArray);

		anAnimalList(animalList);
		anAnimalList(animalArray);

		animalList.add(canine);
		animalList.add(feline);
		animalList.add(dog);
		animalList.add(cat);

		animalList.add(canine1);
		animalList.add(feline1);
		animalList.add(dog1);
		animalList.add(cat1);

		for (Animal animal : animalList) {
			animal.voice();
			System.out.println(animal);
		}

	}

	public static void anAnimal(Animal animal) {
		System.out.println(animal);
	}

	public static void anAnimalArray(ArrayList<Animal> animal) {
		System.out.println(animal);
	}

	public static void anAnimalList(List<Animal> animal) {
		System.out.println(animal);
	}

}
