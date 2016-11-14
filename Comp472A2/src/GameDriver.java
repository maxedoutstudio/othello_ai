
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionListener;

public class GameDriver extends JFrame implements ActionListener {

    GamePanel game;
    JLabel label;
    int response = 0;

    public GameDriver() {

        super("Reversi-Othello");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenu file = new JMenu("Menu");
        menubar.add(file);

        JMenuItem ngame = new JMenuItem("New Game");
        file.add(ngame);
        ngame.addActionListener(this);

        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(this);

        setSize(500, 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New Game")) {
            String options[] = new String[3];
            options[0] = "Easy";
            options[1] = "Medium";
            options[2] = "Difficult";
            // response=JOptionPane.showOptionDialog(null,"New game","Choose Difficulty:",0,JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
            game = new GamePanel(70, 70, 40, 40, response);
            add(game);
        }
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
   public static void main(String args[]) throws IOException {
        GameDriver m = new GameDriver();
    }
}



