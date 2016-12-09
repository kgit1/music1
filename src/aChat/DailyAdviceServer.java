package aChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = { "Eat less", "Buy skinny jeans", "Fail",
			"Be onest at least today",
			"Maybe you should choose anothet haircut" };

	public static void main(String[] args) {
		
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();

	}

	public void go() {
		try {
			ServerSocket serverSocket = new ServerSocket(4242);

			while (true) {
				Socket socket = serverSocket.accept();

				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}

}
