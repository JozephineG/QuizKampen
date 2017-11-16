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
                JButton d = new JButton();
                d.setBackground(Color.RED);
                p2.add(d);
                JLabel e = new JLabel("Ämne");
                e.setHorizontalAlignment(JLabel.CENTER);
                p2.add(e);
                JButton ff = new JButton();
                ff.setBackground(Color.GREEN);
                p2.add(ff);
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
                JButton h = new JButton();
                h.setBackground(Color.GREEN);
                p4.add(h);
                JLabel i = new JLabel("Ämne");
                i.setHorizontalAlignment(JLabel.CENTER);
                p4.add(i);
                JButton j= new JButton();
                j.setBackground(Color.RED);
                p4.add(j);
                p0.add(p4);
        f.pack();
        f.setLocation(900, 500);
        f.setVisible(true);
    }
}

