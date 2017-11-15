package serverClientTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private int port = 1337;
	private String ip = "127.0.0.1";
	
	private Socket socket;
	
	private ObjectOutputStream out; 
	private ObjectInputStream in;
	
	private BufferedReader inKonsol = new BufferedReader(new InputStreamReader(System.in));
	private String tempOut;
	
	Client(){
		
		setupConnection();
		setupOutputStream();
		setupInputStream();
		runThreads();
	}
	

	private void setupConnection() {
		
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			System.out.println("Kunde inte hitta ip/server");
		} catch (IOException e) {
			System.out.println("Fail med koppling");
		}
		
		System.out.println("Kopplades till server...");
	}
	
	private void setupOutputStream() {
		
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte skapa outputStream");
			e.printStackTrace();
		}
	}

	private void setupInputStream() {
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Kunde inte sätta upp inputStream");
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
						System.out.println("ClassNotFound");
					} catch (IOException e) {
						System.out.println("Koppling bröts...");
						e.printStackTrace();
						break;
					}
				}
			}
			
		});
		inThread.start();
		
		Thread outputThread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					try {
						tempOut = inKonsol.readLine();
						out.writeObject(tempOut); out.flush();
					} catch (IOException e) {
						System.out.println("Kunde inte sätta upp outputStream...");
					}
					
				}
			}
			
		});
		outputThread.start();
	}
	
	public static void main(String[] args) {
		
		Client client1 = new Client();
		
	}

}
