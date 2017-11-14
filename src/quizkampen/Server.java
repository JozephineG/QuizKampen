package quizkampen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port= 1111;
	private ServerSocket servSocket;
	private Socket connection;
	
	
	
	public Server() {
		
		setupConnection();
		
		
	}
	
	private void setupConnection(){
		
		try {
			servSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Kunde inte skapa serverSocket");
		}
		
		while(true){
			
			try {
				System.out.println("Väntar på klient...");
				connection = servSocket.accept();
				new ServerThread(connection);
				System.out.println("Kopplade till " + connection.getInetAddress().getHostName());
			} catch (IOException e) {
				System.out.println("Kunde inte koppla till klient");
			}
		
		}
	
	}
		
}
