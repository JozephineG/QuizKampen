package quizkampen;

import java.util.*;

public class IOobjekt {

	private int point= 0;
	private ArrayList<Fr�ga> questions = new ArrayList<>();
	private State currentState;
	private String kategori;
	
	public IOobjekt() {
		setKategori("historia");
		System.out.println(kategori);
		
		
	}//hej
	
	public void plusPoint() { //varje g�ng man svarar r�tt s� kalla denna
		point++;
	}
	
	public void makeQuestions(Fr�ga e) {//konstruera fr�gorna servern m�ste ha en loop d�r den kallar p� databesens fr�gor
		
		questions.add(e);
		
	}
	
	public void setKategori(String k) { //skicka kategorin till servern
		kategori=k;
	}
	
	public String getKategori() {
		
		return kategori;
	}
	
	public List<Fr�ga> getFr�gor() { //f� ut fr�gorna ur objektet som skickas
		
		
		return questions;
		
	}
	
}
