package quizkampen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by joacim on 2017-11-13.
 */
public class Kategori implements ActionListener {


    private JFrame categoryFrame = new JFrame();
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

    private String valdKat = "";

    public Kategori() {

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

        categoryFrame.add(panel2);
        categoryFrame.add(panel);

        categoryFrame.setLayout(new GridLayout());
        categoryFrame.setSize(500, 500);
        categoryFrame.setLocation(700, 100);
        categoryFrame.setVisible(true);
        categoryFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public String getValdKat() {
        return valdKat;
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



        if (e.getSource() == c1) {
            valdKat = c1.getText();
            System.out.println("Fick:" + valdKat);

        }
        if (e.getSource() == c2) {
            valdKat = c2.getText();
            System.out.println("Fick:" + valdKat);
        }
        if (e.getSource() == c3) {
            valdKat = c3.getText();
            System.out.println("Fick:" + valdKat);
        }
        if (e.getSource() == c4) {
            valdKat = c4.getText();
            System.out.println("Fick:" + valdKat);
        }
        if (e.getSource() == c5) {
            valdKat = c5.getText();
            System.out.println("Fick:" + valdKat);
        }
        if (e.getSource() == c6) {
            valdKat = c6.getText();
            System.out.println("Fick:" + valdKat);
        }
    }

}

