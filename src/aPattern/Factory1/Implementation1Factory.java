package aPattern.Factory1;

public class Implementation1Factory implements ServiceFactory{

	@Override
	public Service getService() {
		return new Implementation1();
	}

}
