package repetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

	private BufferedReader in;
	private PrintWriter out;
	
	private int id;
	
	private int port = 4200;
	private String ip = "127.0.0.1";
	
	private Socket connection;
	
	private Client(int id) {
		
		this.id = id;
		
		setupConnection();
		setupReader();
		setupWriter();
	}
	
	private void setupConnection() {
		try {
			connection = new Socket(ip, port);
		} catch (UnknownHostException e) {
			System.out.println("Kunde inte hitta IP eller nåt");
		} catch (IOException e) {
			System.out.println("Kunde inte skicka/ta emot meddelande - Klient: " + id);
		}
	}
	
	private void setupReader() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				} catch (IOException e1) {
					System.out.println("Kunde inte sätta upp läsare för klient: " + id);					
				}
				
				while(true) {
					
					try {
						System.out.println("Servern säger: " + in.readLine() + " (till klient: " + id + ")");
					} catch (IOException e) {
						System.out.println("Klient " + id + " frånkopplad från server");
						break;
					}
				}
				
			}
		});
		
		t1.start();
	}
	
	private void setupWriter() {
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String s;
				try {
					out = new PrintWriter(connection.getOutputStream());
				} catch (IOException e) {
					System.out.println("Kunde inte sätta upp skrivare för klient: " + id);
				}
				
				while (true) {
					s = JOptionPane.showInputDialog("Vad skall skrivas från klient " + id + "?");
					if (s == null) {
						break;
					}
					out.println(s); out.flush();
				}
			}
		});
		
		t2.start();
	}

	public static void main(String[] args) {

		Client c1 = new Client(1);
		Client c2 = new Client(2);
		
	}



}
