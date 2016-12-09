package aChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();

	}

	public void go() {
		try {
			// Socket like a File(don't have content inside, but contents path
			// to content)
			Socket s = new Socket("127.0.0.1", 4242);
			//inputStreamReader knows how to read content from stream
			//given to it by socket
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			//works like usual
			BufferedReader br = new BufferedReader(isr);
			
			String advice = br.readLine();
			System.out.println("Today you mast: "+ advice);
			
			br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
