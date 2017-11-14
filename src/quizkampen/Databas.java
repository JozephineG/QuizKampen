
package quizkampen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;


public class Databas {
    
    //Sport och Fritid frågor
    private Fråga f1 = new Fråga("Vem vann VM 1994?", 0, 0, "Brasilien", "Sverige", "Spanien", "Grönland");
    private Fråga f2 = new Fråga("Vad är Sydkoreas nationalsport?", 1, 0, "Schack", "Tetris", "Starcraft", "Fotboll"); 
    private Fråga f3 = new Fråga("Hur många guldmedaljer totalt vann Jan-Ove Waldner under sin karriär?", 0, 1, "45", "29", "24", "19");
    private Fråga f4 = new Fråga("Vad heter sporten som innefattar en häst och en klubba samt en boll?", 1, 1, "Clop", "Cricket", "Crocket", "Polo");
    
    //2000-talet frågor
    private Fråga f5 = new Fråga("Vem blev försvarsminister 2014?", 0, 1, "Anders Ygeman", "Peter Hultqvist", "Carl Bildt", "Margareta Andersson");
    private Fråga f6 = new Fråga("Vilket år grundades videostreaminingsidan Youtube?", 0, 0, "2005", "2006", "2004", "2003");
    private Fråga f7 = new Fråga("Vilket år släpptes den sista Harry Potter filmen på bio?", 1, 0, "2014", "2008", "2011", "2006");
    private Fråga f8 = new Fråga("Vad heter bandet vars basist dog av en överdos 2010?", 1, 1, "Mayhem", "Motörhead", "Black Sabbath", "Slipknot");
    
    //Tro och skrock frågor
    private Fråga f9 = new Fråga("Abraham ska offra en son, vad hette sonen som skulle offras?", 1, 0, "Abel", "Jakob", "Isaac", "Josef");
    private Fråga f10 = new Fråga("Hur blir man medlem i den svenska kyrkan?", 1, 1, "Genom konfirmation", "Genom att delta ett antal gånger", "Genom att gå in i kyrkan", "Genom dopet");
    private Fråga f11 = new Fråga("Vilken av följande är ansed vara eldgud i den indiska mytologin?", 0, 1, "Aditi", "Agni", "Shiva", "Ganesha");
    private Fråga f12 = new Fråga("Vilken religion tillhör Lao tzu?", 0, 0, "Taoism", "Laoism", "Tzuism", "Buddhism");
    
    //Jorden runt frågor
    private Fråga f13 = new Fråga("När bildades SydSudan?", 1, 1, "2008", "2009", "2010", "2011");
    private Fråga f14 = new Fråga("Vad är Argentinas nationalrätt?", 0, 1, "Kalamares", "Asado", "Tacos", "Tapas");
    private Fråga f15 = new Fråga("Vilket land har minst invånare av dem här?", 0, 0, "Norge", "Sverige", "Danmark", "Finland");
    private Fråga f16 = new Fråga("Vilket är det tredje mest folkrika land?", 1, 0, "Indien", "Ryssland", "USA", "Indonesien");
    
    //Geografi frågor
    private Fråga f17 = new Fråga("Vad heter huvudstaden i Filipinerna?", 0, 0, "Manila", "Jakarta", "Shanghai", "Dabow");
    private Fråga f18 = new Fråga("Vilken stad konsumerar mest vin per kapital?", 1, 0, "Italien", "Sverige", "Vatikanstaten", "Frankrike");
    private Fråga f19 = new Fråga("Hur många sjöar finns det i hela världen? ", 0, 1, "102 miljoner", "117 miljoner", "225 miljoner", "278 miljoner");
    private Fråga f20 = new Fråga("Vilket är det högsta berget i Europa?", 1, 1, "Dom", "Matterhorn", "K2", "Mont Blanc");
    
    //Historia frågor
    private Fråga f21 = new Fråga("Vad heter personen som uppfann dem första datorprogrammen?", 1, 1, "Einstein", "Gabe Kaplan ", "Alan Turing", "Ada Lovelace");
    private Fråga f22 = new Fråga("När bildades det romerska riket?", 0, 1, "538 f.kr", "753 f.kr", "412 f.kr", "73 f.kr");
    private Fråga f23 = new Fråga(" Vilket år sköts JFK ihjäl i Dallas?", 1, 0, "1959", "1968", "1963", "1965");
    private Fråga f24 = new Fråga("När skedde kärnkraftskatastrofen i Tjernobyl?", 0, 1, "1982", "1986", "1977", "1991");
    
    
    public List<Fråga> getQuestionFromCat(String n){
        
        ArrayList <Fråga> QFC = new ArrayList<>();
        
        n = n.toLowerCase().trim();
        
        if(n.matches("sportochfritid")){
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
        } else if(n.matches("troochskrock")){
            QFC.add(f9);
            QFC.add(f10);
            QFC.add(f11);
            QFC.add(f12);
            Collections.shuffle(QFC);
        } else if(n.matches("jordenrunt")){
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
