package aRemoteServerClient;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

//create interface MyRemoteServer
//and extend Remote(remote haven't methods, it is just marker)
//interfaces - extending each other
public interface MyRemoteServer extends Remote {
	// our service layer for which this interface created
	// will work with output\input and with net and sockets
	// so we need it's methods to be aware of this problems
	// thats why we throw RemoteException
	// and
	// all arguments and return types for methods must be primitives or
	// realization of serializable interface(be serializable)
	public String sayHello() throws RemoteException;
}
