package repetition;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port = 4200;
	private Socket connection;
	private ServerSocket serverSocket;
	public static int ID = 1;
	
	
	private Server(){
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Kunde inte sätta upp ServerSocket");
		}
		
		while(true) {
			
			try {
				System.out.println("Väntar på klient...");
				connection = serverSocket.accept();
				new ServerClientThread(connection, ID);
				System.out.println("Kopplad till klient " + ID + "...");
				ID++;
			} catch (IOException e) {
				System.out.println("Kunde inte koppla till klient");
			}
		}
	}
	
	public static void main(String[] args) {
		
		new Server();
	}
}
