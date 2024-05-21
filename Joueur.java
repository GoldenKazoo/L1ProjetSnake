import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Joueur
 */
public class Joueur {


    public static String creationFrame(String question){ // Creation de la frame input coup 
        JFrame frame = new JFrame("Frame");
    
        JTextField text1 = new JTextField();
        text1.setBounds(20,60,200,28);
        
        JLabel text2 = new JLabel(question);
        text2.setBounds(20,20,200,28);

        JButton button = new JButton("Entrer");
        button.setBounds(65, 100, 90, 28);
        

        // Ajout des text, input
        frame.add(text1); 
        frame.add(text2);
        frame.add(button);

        // Application des settings de la fenetre
        frame.setSize(250,180);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String textCoup = text1.getText();
        
        return textCoup;

    }
        public static void getText(){
            String getText = creationFrame("Quel est votre coup?");
            System.out.println(getText);
            
        }

    public static void main(String[] args) {
        getText();
    }
}