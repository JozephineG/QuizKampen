
package quizkampen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GUIquiz implements ActionListener {
    
    //Frågeruta
    JFrame questionframe = new JFrame("Frågeruta");
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
    String vald;
    
    Databas d = new Databas();
    
    
    //kategori
    JFrame kategoriframe = new JFrame();
    
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel panel2 = new JPanel(new BorderLayout());
    private JButton kategori = new JButton("Klicka för kategori");


    private List<JButton> category = new ArrayList<>();

    private JButton c1 = new JButton("Sport & Fritid");
    private JButton c2 = new JButton("2000-talet");
    private JButton c3 = new JButton("Tro & Skrock");
    private JButton c4 = new JButton("Jorden runt");
    private JButton c5 = new JButton("Geografi");
    private JButton c6 = new JButton("Historia");
    
    String valdKat;
    int next = 0;
    
    public GUIquiz(){
        
        
        // Kategori
        category.add(c1);
        category.add(c2);
        category.add(c3);
        category.add(c4);
        category.add(c5);
        category.add(c6);
        
        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);
        c4.addActionListener(this);
        c5.addActionListener(this);
        c6.addActionListener(this);

        kategori.addActionListener(this);
        panel.setLayout(new GridLayout(3, 1));
        panel2.setLayout(new BorderLayout());
        panel2.add(kategori);

        kategoriframe.add(panel2);
        kategoriframe.add(panel);

        kategoriframe.setLayout(new GridLayout());
        kategoriframe.setSize(500, 500);
        kategoriframe.setLocation(700, 100);
        kategoriframe.setVisible(true);
        kategoriframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        //Frågeruta
        
        questionframe.add(spelyta);
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
        
        if(next == 1){
        List <Fråga> tworandque = d.getQuestionFromCat(valdKat);
        frågarray[0] = tworandque.get(0);
        frågarray[1] = tworandque.get(1);
        
        
        fråga.setText(frågarray[n].getQuestion());
        bArray[0][0].setText(frågarray[0].getAnswerA());
        bArray[0][1].setText(frågarray[0].getAnswerB());
        bArray[1][0].setText(frågarray[0].getAnswerC());
        bArray[1][1].setText(frågarray[0].getAnswerD());
        
        
        questionframe.setLocation(700, 100);
        questionframe.setSize(500, 500);
        questionframe.setVisible(false);
        questionframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ++next;
        
        }
        
        
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
    
    public void nextFrame(){
        
        kategoriframe.setVisible(false);
        questionframe.setVisible(true);
        next = 1;
        
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        
        if(next == 1){
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
        }
        
        Collections.shuffle(category);
        List<JButton> shuffleCategory = new ArrayList<>(category.subList(0, 3));


        if (e.getSource() == kategori) {

            panel.removeAll();

            for (JButton b : shuffleCategory) {

                panel.add(b);
            }

            panel.revalidate();
            panel.repaint();
        }
        
        if (e.getSource() == c1) {
            valdKat = c1.getText();
            nextFrame();
        }
        if (e.getSource() == c2) {
            valdKat = c2.getText();
            nextFrame();
        }
        if (e.getSource() == c3) {
            valdKat = c3.getText();
            nextFrame();
        }
        if (e.getSource() == c4) {
            valdKat = c4.getText();
            nextFrame();
        }
        if (e.getSource() == c5) {
            valdKat = c5.getText();
            nextFrame();
        }
        if (e.getSource() == c6) {
            valdKat = c6.getText();
            nextFrame();
        }
        
        if(next == 2){
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
        
        
        }
        
        questionframe.revalidate();
        questionframe.repaint();
        
    }
      
    
}
    
   
   
    
    
