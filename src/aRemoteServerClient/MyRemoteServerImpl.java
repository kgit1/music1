package aRemoteServerClient;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//our service impementation must have some certain abilities so we extend
//UnicastRemoteObject which has thems
public class MyRemoteServerImpl extends UnicastRemoteObject
		implements MyRemoteServer {

	protected MyRemoteServerImpl() throws RemoteException {
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Server says: Hello";
	}

	public static void main(String[] args) {
		try {
			//create and instantiate remote object
			MyRemoteServer service = new MyRemoteServerImpl();
			//put remote object to registry with static method Naming.rebind()
			//this name will be used to find object in RMI registry
			Naming.rebind("Remote Hello", service);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
