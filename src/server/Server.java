package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port = 1337;
	private Socket connection;
	private ServerSocket listener;
	
	Server(){
		
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Could not create ServerSocket...");
		}
		setupConnection();
	}
	
	private void setupConnection() {
		
		try {
			while(true) {
				System.out.println("Waiting to connect to first client...");
				connection = listener.accept();
				Player p1 = new Player(connection, 1);
				System.out.println("Player 1 connected: " + connection.getInetAddress().getHostName());
				System.out.println("Waiting to connect to second client...");
				connection = listener.accept();
				Player p2 = new Player(connection, 2);
				System.out.println("Player 2 connected: " + connection.getInetAddress().getHostName());
			}
		} catch (IOException e) {
			System.out.println("Unable to connect to client...");
		}
	}

	public static void main(String[] args) {
		
		new Server();
	}

}
