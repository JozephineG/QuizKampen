package quizkampen;

import java.util.*;

public class IOobjekt {

	private int point= 0;
	private ArrayList<Fråga> questions = new ArrayList<>();
	private State currentState;
	private String kategori;
	
	public IOobjekt() {
		setKategori("historia");
		System.out.println(kategori);
		
		
	}//hej
	
	public void plusPoint() { //varje gång man svarar rätt så kalla denna
		point++;
	}
	
	public void makeQuestions(Fråga e) {//konstruera frågorna servern måste ha en loop där den kallar på databesens frågor
		
		questions.add(e);
		
	}
	
	public void setKategori(String k) { //skicka kategorin till servern
		kategori=k;
	}
	
	public String getKategori() {
		
		return kategori;
	}
	
	public List<Fråga> getFrågor() { //få ut frågorna ur objektet som skickas
		
		
		return questions;
		
	}
	
}
