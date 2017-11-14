package quizkampen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread {

	private Socket connection;
	
	private ObjectInputStream inStream; 
	private ObjectOutputStream outStream;
	
	private String inputString;
	
	
	ServerThread(Socket socket){
		
		connection = socket;
		
		
		setupStreams();
	}
	
	private void setupStreams() {
		
		try {
			inStream = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {
			System.out.println("Gick inte att s�tta upp InputStream");
		}
		
		Thread threadIn = new Thread(new Runnable() {
			@Override
			public void run() {
				
				while (true) {
					try {
						inputString = inStream.readObject().toString();
						System.out.println(inputString);
					} catch (ClassNotFoundException e) {
						System.out.println("ClassNotFoundException");
					} catch (IOException e) {
						break;
					}
				}
				
			}
		});
		
		threadIn.start();
		
		try {
			outStream = new ObjectOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte s�tta upp outputStream");
		}
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(true) {
					
					// h�r ska n�got skickas ut, objekt eller str�ng, vi f�r se
				}
			}
		});
		
	}
	
}
