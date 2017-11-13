
package quizkampen;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;


public class GUIquiz extends JFrame implements ActionListener {
    
    JPanel spelyta = new JPanel();
    JPanel knappyta = new JPanel();
    JLabel fråga = new JLabel("", SwingConstants.CENTER);
    
    JButton[][] bArray = new JButton[2][2];
    
    int[] frågarray = {1, 2, 3, 4};
    
    int r;
    int k;
    int rättr;
    int rättk;
    
    
    public GUIquiz(){
        
        add(spelyta);
        spelyta.setLayout(new GridLayout(2, 1));
        fråga.setText("Första bokstaven i alfabetet?");
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
        
        bArray[0][0].setText("A");
        bArray[0][1].setText("B");
        bArray[1][0].setText("C");
        bArray[1][1].setText("D");
        
        
        setLocation(700, 100);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
    
    public boolean rättellerfel(int rad, int kolumn){
        
        boolean rätt = false;
        rättr = 2;
        rättk = 2;
        
        switch (frågarray[0]) {
            case 1: rättr = 0;
                    rättk = 0;
                    break;
            case 2: rättr = 1;
                    rättk = 1;
                    break;
            case 3: rättr = 0;
                    rättk = 1;
                    break;
            case 4: rättr = 1;
                    rättk = 0;
                    break;
        }
                     
                     
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
        
        revalidate();
        repaint();
        
        JOptionPane.showMessageDialog(null, "Slutet på [Svara på fråga] demo");
        System.exit(0);
        
    }
    
    
}
