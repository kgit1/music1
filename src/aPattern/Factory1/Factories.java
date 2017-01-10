package aPattern.Factory1;

//pattern Factory - creational pattern that uses factory methods to deal
//with problem of creating objects without having to specify exact class
//of the object that will be created
//we give some object as argument and method knows on his own what to 
//do when get object of that class
public class Factories {

	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		System.out.println("=================");
		serviceConsumer(new Implementation2Factory());

	}

	public static void serviceConsumer(ServiceFactory factory) {
		Service service = factory.getService();
		service.method1();
		service.method2();
	}
}
