
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
    JLabel fr�ga = new JLabel("", SwingConstants.CENTER);
    
    JButton[][] bArray = new JButton[2][2];
    
    int[] fr�garray = {1, 2, 3, 4};
    
    int r;
    int k;
    int r�ttr;
    int r�ttk;
    
    
    public GUIquiz(){
        
        add(spelyta);
        spelyta.setLayout(new GridLayout(2, 1));
        fr�ga.setText("F�rsta bokstaven i alfabetet?");
        fr�ga.setFont(new Font("Serif", Font.BOLD, 18));
        spelyta.add(fr�ga);
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
    
    public boolean r�ttellerfel(int rad, int kolumn){
        
        boolean r�tt = false;
        r�ttr = 2;
        r�ttk = 2;
        
        switch (fr�garray[0]) {
            case 1: r�ttr = 0;
                    r�ttk = 0;
                    break;
            case 2: r�ttr = 1;
                    r�ttk = 1;
                    break;
            case 3: r�ttr = 0;
                    r�ttk = 1;
                    break;
            case 4: r�ttr = 1;
                    r�ttk = 0;
                    break;
        }
                     
                     
        if(rad == r�ttr && kolumn == r�ttk){
            System.out.println(rad + " " + kolumn + "true");
            r�tt = true;
        } else {
            System.out.println(rad + " " + kolumn + "false");
            r�tt = false;
        }
        return r�tt;
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
        
        boolean r�ttknapp = r�ttellerfel(r, k);
        
        if(r�ttknapp == true){
            bArray[r][k].setBackground(Color.green);
        }
        if(r�ttknapp == false){
            System.out.println(r + " " + k);
            bArray[r][k].setBackground(Color.red);
            bArray[r�ttr][r�ttk].setBackground(Color.green);
            
        }
        
        revalidate();
        repaint();
        
        JOptionPane.showMessageDialog(null, "Slutet p� [Svara p� fr�ga] demo");
        System.exit(0);
        
    }
    
    
}
