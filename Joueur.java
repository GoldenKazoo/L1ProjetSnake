import javax.swing.*;

/**
 * Joueur
 */
public class Joueur {

    public static void coupInput(){ // Creation de la frame input coup 
        JFrame frame = new JFrame("Input");
    
        JTextField text1 = new JTextField();
        text1.setBounds(20,60,200,28);
        
        JLabel text2 = new JLabel("Quel direction voulez vous aller ?");
        text2.setBounds(20,20,200,28);

        JButton entrer = new JButton("Entrer");
        entrer.setBounds(65, 100, 90, 28);
        

        // Ajout des text, input
        frame.add(text1); 
        frame.add(text2);
        frame.add(entrer);

        // Application des settings de la fenetre
        frame.setSize(250,180);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Recuperation de l'input 
        String direction = text1.getText();
        System.out.println(direction);
    }
        public static void getText(){
            
        }

    public static void main(String[] args) {
        coupInput();
    }
}