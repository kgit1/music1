package aBeatBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;

public class FullBeatBoxServer {
	ArrayList<ObjectOutputStream> clientOutputStreams;

	public static void main(String[] args) {

		new FullBeatBoxServer().go();
	}

	public class ClientHandler implements Runnable {

		ObjectInputStream ois;
		Socket clientSocket;

		public ClientHandler(Socket socket) {
			try {
				clientSocket = socket;
				ois = new ObjectInputStream(clientSocket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			Object o2 = null;
			Object o1 = null;
			try {
				while ((o1 = ois.readObject()) != null) {
					o2 = ois.readObject();
					System.out.println("read two objects");
					tellEveryone(o1, o2);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void go() {

		clientOutputStreams = new ArrayList<>();

		try {
			ServerSocket serverSocket = new ServerSocket(4242);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(
						clientSocket.getOutputStream());
				clientOutputStreams.add(out);

				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();

				System.out.println("got a connection");
			}
		} catch (Exception ex) {

		}
	}

	public void tellEveryone(Object one, Object two) {
		Iterator it = clientOutputStreams.iterator();
		while (it.hasNext()) {
			try {
				ObjectOutputStream out = (ObjectOutputStream) it.next();
				out.writeObject(one);
				out.writeObject(two);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
