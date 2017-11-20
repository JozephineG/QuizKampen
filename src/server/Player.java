package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player {
	
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
	}
	
	private void setupOutputStream() {
		
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte s�tta upp OutputStream...");
			
		}
	}
	
	private void setupInputStream() {
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte skapa inputStream");
		}
	}
	
	
//Tja
	private void runThreads() {
		
		Thread inThread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					
					try {
						System.out.println(in.readObject());
					} catch (ClassNotFoundException e) {
						System.out.println("Problem att l�sa in objekt...");
					} catch (IOException e) {
						System.out.println("Koppling br�ts...");
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
						System.out.println("Kunde inte l�sa in fr�n konsolen...");
					}
				}
			}
		});
		outThread.start();
		
	}
}
