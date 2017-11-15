package propertiesquiz;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PropertiesQuiz extends JFrame {

    PropertiesQuiz() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("src/propertiesquiz/QuizFile"));
        } catch (IOException e) {
            System.out.println("File could not be found");
        }
        String mess = p.getProperty("message", "Game");
        JLabel l = new JLabel(mess, JLabel.CENTER);
        add(l);
        l.setOpaque(true);
        String countRound = p.getProperty("countRound", "Error");
        String countSettings = p.getProperty("countQuestions", "Error");
        setSize(400, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PropertiesQuiz();
    }
}
