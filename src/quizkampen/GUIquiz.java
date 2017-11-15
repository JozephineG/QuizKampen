
package quizkampen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GUIquiz extends JFrame implements ActionListener {

    JPanel spelyta = new JPanel();
    JPanel knappyta = new JPanel();
    JLabel fråga = new JLabel("", SwingConstants.CENTER);
    
    JButton[][] bArray = new JButton[2][2];
    
    Fråga[] frågarray = new Fråga[2];
    
    int r;
    int k;
    int rättr;
    int rättk;
    int n;
    
    Databas d = new Databas();
    Kategori kat = new Kategori();
    
    public GUIquiz(){
        
        
        add(spelyta);
        spelyta.setLayout(new GridLayout(2, 1));
        fråga.setFont(new Font("Serif", Font.BOLD, 18));
        spelyta.add(fråga);
        spelyta.add(knappyta);
        knappyta.setLayout(new GridLayout(2, 2));
        
        for(int i = 0; i < bArray.length; i++ ){
            for(int j = 0; j < bArray[i].length; j++){
                bArray[i][j] = new JButton();
                knappyta.add(bArray[i][j]);
                bArray[i][j].addActionListener(this);
            }
        }
        
        List <Fråga> tworandque = d.getQuestionFromCat(kat.getValdKat());
        frågarray[0] = tworandque.get(0);
        frågarray[1] = tworandque.get(1);
        
        
        fråga.setText(frågarray[n].getQuestion());
        bArray[0][0].setText(frågarray[0].getAnswerA());
        bArray[0][1].setText(frågarray[0].getAnswerB());
        bArray[1][0].setText(frågarray[0].getAnswerC());
        bArray[1][1].setText(frågarray[0].getAnswerD());
        
        
        setLocation(700, 100);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        
        
    }
    
    public boolean rättellerfel(int rad, int kolumn){
        
        boolean rätt = false;
        rättr = 2;
        rättk = 2;
        
        rättr = frågarray[n].getR();
        rättk = frågarray[n].getK();             
                     
        if(rad == rättr && kolumn == rättk){
            System.out.println(rad + " " + kolumn + "true");
            rätt = true;
        } else {
            System.out.println(rad + " " + kolumn + "false");
            rätt = false;
        }
        
        return rätt;
    }
    
    public void actionPerformed(ActionEvent e){
        
        
        JButton vald = (JButton) e.getSource();
        for(int m = 0; m < bArray.length; m++){
            for(int n = 0; n < bArray[m].length; n++){
                if(bArray[m][n] == vald){
                     r = m;
                     k = n;
                     System.out.println("vald rad: " + r + " vald kolumn: " + k);
                } 
            }
        }
        
        boolean rättknapp = rättellerfel(r, k);
        
        if(rättknapp == true){
            bArray[r][k].setBackground(Color.green);
        }
        if(rättknapp == false){
            System.out.println(r + " " + k);
            bArray[r][k].setBackground(Color.red);
            bArray[rättr][rättk].setBackground(Color.green);  
        }
        
        ++n;
        
        if(n < 2){
            JOptionPane.showMessageDialog(null, "Till nästa fråga");
        }
        if(n == 2){
            JOptionPane.showMessageDialog(null, "Klar");
            System.exit(0);
        }
        
        bArray[0][0].setBackground(null);
        bArray[0][1].setBackground(null);
        bArray[1][0].setBackground(null);
        bArray[1][1].setBackground(null);
        
        fråga.setText(frågarray[n].getQuestion());
        bArray[0][0].setText(frågarray[n].getAnswerA());
        bArray[0][1].setText(frågarray[n].getAnswerB());
        bArray[1][0].setText(frågarray[n].getAnswerC());
        bArray[1][1].setText(frågarray[n].getAnswerD());
        
        revalidate();
        repaint();
        
        
        
    }
    
}
