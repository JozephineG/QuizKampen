package serverClientTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port = 1337;
	private Socket connection;
	private ServerSocket listener;
	
	Server(){
		
		setupConnection();
	}
	
	private void setupConnection() {
		
		try {
			listener = new ServerSocket(port);
			while(true) {
				
			System.out.println("Väntar på att kopplas till klient...");
			connection = listener.accept();
			Player p1 = new Player(connection, 1);
			System.out.println("Kopplades till klient " + connection.getInetAddress().getHostAddress());
			
			
			}
		} catch (IOException e) {
			System.out.println("Fel med att koppla upp mot klient");
		}
		
	}
	

	public static void main(String[] args) {

		
		new Server();
	}

}
