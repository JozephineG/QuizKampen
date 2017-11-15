package quizkampen;import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by joacim on 2017-11-13.
 */
public class Kategori extends JFrame implements ActionListener {

    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel panel2 = new JPanel(new BorderLayout());
    private JButton kategori = new JButton("Klicka för kategori");


    private List<JButton> category = new ArrayList<>();

    JButton c1 = new JButton("Sport & Fritid");
    JButton c2 = new JButton("2000-talet");
    JButton c3 = new JButton("Tro & Skrock");
    JButton c4 = new JButton("Jorden runt");
    JButton c5 = new JButton("Geografi");
    JButton c6 = new JButton("Historia");

    public Kategori() {

        category.add(c1);
        category.add(c2);
        category.add(c3);
        category.add(c4);
        category.add(c5);
        category.add(c6);

        kategori.addActionListener(this);
        panel.setLayout(new GridLayout(3, 1));
        panel2.setLayout(new BorderLayout());
        panel2.add(kategori);

        add(panel2);
        add(panel);

        setLayout(new GridLayout());
        setSize(500, 500);
        setLocation(700, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

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
    }

    public static void main(String[] arg) {

        Kategori k = new Kategori();


    }
}

