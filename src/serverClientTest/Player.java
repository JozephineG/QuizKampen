package serverClientTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player extends Thread {
	
	private int id;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private BufferedReader inKonsol = new BufferedReader(new InputStreamReader(System.in));
	
	private Socket socket;
	String tempOut;
	
	Player(Socket socket, int id){
		
		this.socket = socket;
		this.id = id;
		
		setupOutputStream();
		setupInputStream();
		runThreads();
		this.start();
	}
	
	private void setupOutputStream() {
		
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte sätta upp OutputStream...");
			
		}
		
	}
	
	private void setupInputStream() {
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte skapa inputStream");
		}
	}
	
	

	private void runThreads() {
		
		Thread inThread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					
					try {
						System.out.println(in.readObject());
					} catch (ClassNotFoundException e) {
						System.out.println("Problem att läsa in objekt...");
					} catch (IOException e) {
						System.out.println("Koppling bröts...");
						break;
					}

				}
			}
			
		});
		inThread.start();
		
		Thread outThread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				while (true) {
					
					try {
						tempOut = inKonsol.readLine();
						out.writeObject(tempOut); out.flush();
					} catch (IOException e) {
						System.out.println("Kunde inte läsa in från konsolen...");
					}
				}
			}
		});
		outThread.start();
	}
}
