package quizkampen;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Resultview {

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Ouizkampen");
        f.setBackground(Color.BLUE);
        JPanel p0 = new JPanel();
        p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
        p0.setBackground(Color.BLUE);
        f.add(p0);
            JPanel p = new JPanel(new GridLayout(0,3));
                p.setBackground(Color.BLUE);
                p0.add(p);
                JLabel a = new JLabel("Användare ett");
                    a.setHorizontalAlignment(JLabel.CENTER);
                    p.add(a);
                JLabel b = new JLabel("Rond 1");
                    b.setHorizontalAlignment(JLabel.CENTER);
                    p.add(b);
                JLabel c = new JLabel("Användare två");
                    c.setHorizontalAlignment(JLabel.CENTER);
                    p.add(c);
                p0.add(p);
            JPanel p2 = new JPanel(new GridLayout(0,3));
                p2.setBackground(Color.BLUE);
                    JPanel p21 = new JPanel(new GridLayout(0,2));
                        JButton d1 = new JButton();
                            d1.setBackground(Color.RED);
                        JButton d2 = new JButton();
                            d2.setBackground(Color.RED);
                            p21.add(d1);
                            p21.add(d2);
                            p2.add(p21);
                JLabel e = new JLabel("Ämne");
                    e.setHorizontalAlignment(JLabel.CENTER);
                    p2.add(e);
                    JPanel p22 = new JPanel(new GridLayout(0,2));
                        JButton f1 = new JButton();
                            f1.setBackground(Color.GREEN);
                        JButton f2 = new JButton();
                            f2.setBackground(Color.GREEN);
                            p22.add(f1);
                            p22.add(f2);
                            p2.add(p22);
                p0.add(p2);
            JPanel p3 = new JPanel(new GridLayout(0,3));
                p3.setBackground(Color.BLUE);
                p3.add(new JLabel(""));
                JLabel g = new JLabel("Round 2");
                    g.setHorizontalAlignment(JLabel.CENTER);
                    p3.add(g);
                    p3.add(new JLabel(""));
                p0.add(p3);
            JPanel p4 = new JPanel(new GridLayout(0,3));
                p4.setBackground(Color.BLUE);
                    JPanel p41 = new JPanel(new GridLayout(0,2));
                        JButton h1 = new JButton();
                            h1.setBackground(Color.GREEN);
                        JButton h2 = new JButton();
                            h2.setBackground(Color.RED); 
                            p41.add(h1);
                            p41.add(h2);
                            p4.add(p41);
                JLabel i = new JLabel("Ämne");
                    i.setHorizontalAlignment(JLabel.CENTER);
                    p4.add(i);
                    JPanel p42 = new JPanel(new GridLayout(0,2));    
                        JButton j1= new JButton();
                            j1.setBackground(Color.RED);
                        JButton j2= new JButton();
                            j2.setBackground(Color.RED);
                            p42.add(j1);
                            p42.add(j2);
                            p4.add(p42);
                p0.add(p4);
        f.pack();
        f.setLocation(900, 500);
        f.setVisible(true);
    }
}

