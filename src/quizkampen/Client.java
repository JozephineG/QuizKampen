package quizkampen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private int port = 1111;
	private String ip = "127.0.0.1";
	
	private Socket connection; 
	
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	
	private String inputString;
	
	Client(){
		
		setupConnection();
		setupStreams();
		whileConnected();
		
	}
	
	private void setupConnection() {
		
		try {
			connection = new Socket(ip, port);
		} catch (UnknownHostException e) {
			System.out.println("Hittade inte server");
		} catch (IOException e) {
			System.out.println("Gick inte att skriva till/från server");
		}
		
	}
	
	private void setupStreams() {
		
		try {
			inputStream = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {
			System.out.println("Gick inte att sätta upp inputStream");
		}
		
		try {
			outputStream = new ObjectOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			System.out.println("Gick inte att sätta upp outputStream");
		}
		
	}
	
	private void whileConnected() {
		
		while (true) {
			
			try {
				inputString = (String) inputStream.readObject();
				System.out.println(inputString);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFound");
			} catch (IOException e) {
				System.out.println("Kopplade ifrån server");
				break;
			}
			
		}
		
	}
	
	public static void main(String[] args) {

		
		
	}

}
