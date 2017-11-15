package repetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerClientThread {

	private Socket connection;
	private int id;
	
	ServerClientThread(Socket socket, int id){
		
		connection = socket;
		this.id = id;
		
		setupReader();
		setupWriter(); 
		
	}
	
	private void setupReader() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				BufferedReader in;
				try {
					in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					while (true) {
						System.out.println("Klient " + id + ": " + in.readLine());
					}
				} catch (IOException e) {
					System.out.println("Kopplar ifrån klient " + id);
				}
			}
		});
		
		t1.start();
	}
	
	private void setupWriter() {
		

		Thread t2 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				
				String s;
				try {
					PrintWriter out = new PrintWriter(connection.getOutputStream());
					while(true) {
						s = JOptionPane.showInputDialog("Text från SC-tråd: " + id);
						if (s == null) {
							break;
						}
						out.println(s); out.flush();
					}
				} catch (IOException e) {
					System.out.println("Kunde inte skriva till klient (tråd: t2");
				}
			}
		});
		
		t2.start();
	}
		
	
}
