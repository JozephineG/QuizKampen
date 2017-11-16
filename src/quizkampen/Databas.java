package quizkampen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;


public class Databas {
    
    //Sport och Fritid fr�gor
    private Fr�ga f1 = new Fr�ga("Vem vann VM 1994?", 0, 0, "Brasilien", "Sverige", "Spanien", "Gr�nland");
    private Fr�ga f2 = new Fr�ga("Vad �r Sydkoreas nationalsport?", 1, 0, "Schack", "Tetris", "Starcraft", "Fotboll"); 
    private Fr�ga f3 = new Fr�ga("Hur m�nga guldmedaljer totalt vann Jan-Ove Waldner under sin karri�r?", 0, 1, "45", "29", "24", "19");
    private Fr�ga f4 = new Fr�ga("Vad heter sporten som innefattar en h�st och en klubba samt en boll?", 1, 1, "Clop", "Cricket", "Crocket", "Polo");
    
    //2000-talet fr�gor
    private Fr�ga f5 = new Fr�ga("Vem blev f�rsvarsminister 2014?", 0, 1, "Anders Ygeman", "Peter Hultqvist", "Carl Bildt", "Margareta Andersson");
    private Fr�ga f6 = new Fr�ga("Vilket �r grundades videostreaminingsidan Youtube?", 0, 0, "2005", "2006", "2004", "2003");
    private Fr�ga f7 = new Fr�ga("Vilket �r sl�pptes den sista Harry Potter filmen p� bio?", 1, 0, "2014", "2008", "2011", "2006");
    private Fr�ga f8 = new Fr�ga("Vad heter bandet vars basist dog av en �verdos 2010?", 1, 1, "Mayhem", "Mot�rhead", "Black Sabbath", "Slipknot");
    
    //Tro och skrock fr�gor
    private Fr�ga f9 = new Fr�ga("Abraham ska offra en son, vad hette sonen som skulle offras?", 1, 0, "Abel", "Jakob", "Isaac", "Josef");
    private Fr�ga f10 = new Fr�ga("Hur blir man medlem i den svenska kyrkan?", 1, 1, "Genom konfirmation", "Genom att delta ett antal g�nger", "Genom att g� in i kyrkan", "Genom dopet");
    private Fr�ga f11 = new Fr�ga("Vilken av f�ljande �r ansed vara eldgud i den indiska mytologin?", 0, 1, "Aditi", "Agni", "Shiva", "Ganesha");
    private Fr�ga f12 = new Fr�ga("Vilken religion tillh�r Lao tzu?", 0, 0, "Taoism", "Laoism", "Tzuism", "Buddhism");
    
    //Jorden runt fr�gor
    private Fr�ga f13 = new Fr�ga("N�r bildades SydSudan?", 1, 1, "2008", "2009", "2010", "2011");
    private Fr�ga f14 = new Fr�ga("Vad �r Argentinas nationalr�tt?", 0, 1, "Kalamares", "Asado", "Tacos", "Tapas");
    private Fr�ga f15 = new Fr�ga("Vilket land har minst inv�nare av dem h�r?", 0, 0, "Norge", "Sverige", "Danmark", "Finland");
    private Fr�ga f16 = new Fr�ga("Vilket �r det tredje mest folkrika land?", 1, 0, "Indien", "Ryssland", "USA", "Indonesien");
    
    //Geografi fr�gor
    private Fr�ga f17 = new Fr�ga("Vad heter huvudstaden i Filipinerna?", 0, 0, "Manila", "Jakarta", "Shanghai", "Dabow");
    private Fr�ga f18 = new Fr�ga("Vilken stad konsumerar mest vin per kapital?", 1, 0, "Italien", "Sverige", "Vatikanstaten", "Frankrike");
    private Fr�ga f19 = new Fr�ga("Hur m�nga sj�ar finns det i hela v�rlden? ", 0, 1, "102 miljoner", "117 miljoner", "225 miljoner", "278 miljoner");
    private Fr�ga f20 = new Fr�ga("Vilket �r det h�gsta berget i Europa?", 1, 1, "Dom", "Matterhorn", "K2", "Mont Blanc");
    
    //Historia fr�gor
    private Fr�ga f21 = new Fr�ga("Vad heter personen som uppfann dem f�rsta datorprogrammen?", 1, 1, "Einstein", "Gabe Kaplan ", "Alan Turing", "Ada Lovelace");
    private Fr�ga f22 = new Fr�ga("N�r bildades det romerska riket?", 0, 1, "538 f.kr", "753 f.kr", "412 f.kr", "73 f.kr");
    private Fr�ga f23 = new Fr�ga(" Vilket �r sk�ts JFK ihj�l i Dallas?", 1, 0, "1959", "1968", "1963", "1965");
    private Fr�ga f24 = new Fr�ga("N�r skedde k�rnkraftskatastrofen i Tjernobyl?", 0, 1, "1982", "1986", "1977", "1991");
    
    
    public ArrayList<Fr�ga> getQuestionFromCat(String n){
        
        ArrayList <Fr�ga> QFC = new ArrayList<>();
        
        n = n.toLowerCase();
        
        if(n.matches("sport & fritid")){
            QFC.add(f1);
            QFC.add(f2);
            QFC.add(f3);
            QFC.add(f4);
            Collections.shuffle(QFC);
        } else if(n.matches("2000-talet")){
            QFC.add(f5);
            QFC.add(f6);
            QFC.add(f7);
            QFC.add(f5);
            Collections.shuffle(QFC);
        } else if(n.matches("tro & skrock")){
            QFC.add(f9);
            QFC.add(f10);
            QFC.add(f11);
            QFC.add(f12);
            Collections.shuffle(QFC);
        } else if(n.matches("jorden runt")){
            QFC.add(f13);
            QFC.add(f14);
            QFC.add(f15);
            QFC.add(f16);
            Collections.shuffle(QFC);
        } else if(n.matches("geografi")){
            QFC.add(f17);
            QFC.add(f18);
            QFC.add(f19);
            QFC.add(f20);
            Collections.shuffle(QFC);
        } else if(n.matches("historia")){
            QFC.add(f21);
            QFC.add(f22);
            QFC.add(f23);
            QFC.add(f24);
            Collections.shuffle(QFC);
        } else {   
            JOptionPane.showMessageDialog(null, n + " finns inte i"
            + " databasen");
        } 
        
        return QFC;
    }
    
}