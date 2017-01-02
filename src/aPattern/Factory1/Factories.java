package aPattern.Factory1;

public class Factories {

	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		System.out.println("=================");
		serviceConsumer(new Implementation2Factory());

	}

	public static void serviceConsumer(ServiceFactory factory){
		Service service = factory.getService();
		service.method1();
		service.method2();
	}
}
