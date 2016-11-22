import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;

public class GamePanel extends JPanel implements MouseListener {

    private Graphics2D board;
    private GameOthello game;
    public int depth;
    Runtime r ;
    //game panel constructor
    public GamePanel(int x, int y, int w, int h,int response) {
        super();
        setSize(500, 500); //default size
        addMouseListener(this); //mouse callback
        //depth of search
        if(response==0) depth=1;
        else if(response==1) depth=3;
        else depth=5;
        game = new GameOthello(x, y, w, h,depth); //needs to be adjusted
        
      r = Runtime.getRuntime();
      r.gc();
    }
    //get player
    public char getPlayer() {
        return this.game.getPlayer();
    }
    //set player
    public void setPlayer() {
        game.setPlayer();
    }
    //board styling
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board = (Graphics2D) g;
        this.setBackground(new Color(0,100,0)); //board background color RGB
        board.setStroke(new BasicStroke(3.0f)); //lines weight

        //8*8 grid
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 7; i++) {
                board.setColor(Color.BLACK); //grid lines
                board.draw(new Rectangle2D.Double(game.getSquare(j, i).getX(), game.getSquare(j, i).getY(), game.getSquare(j, i).getW(), game.getSquare(j, i).getH()));
                if (game.getSquare(j, i).getCircle() == 'W') {
                    board.setColor(Color.WHITE); //white chips on the board
                    board.fillOval(game.getSquare(j, i).getX() + 5, game.getSquare(j, i).getY() + 4, 30, 30);
                }
                if (game.getSquare(j, i).getCircle() == 'B') {
                    board.setColor(Color.BLACK); //black chips on the board
                    board.fillOval(game.getSquare(j, i).getX() + 5, game.getSquare(j, i).getY() + 4, 30, 30);
                }
                board.setColor(Color.BLACK);

            }
        }
        //top layer
        int x=70,y=30;
        int a=1;
        String c=a+" ";
        for(int j=0;j<7;j++) //amounts of squares
        {
            c=a+" ";
            board.setColor(Color.YELLOW);
            board.draw(new Rectangle2D.Double(x,y,40,40));
            board.drawString(c,40f,20f+x);
            x=x+40;
            a++;
        }
         x=30;y=70;
         a=65;
          c=(char)a+" ";
        for(int j=0;j<7;j++) //left layer
        {
            c=(char)a+" ";
            board.setColor(Color.YELLOW);
            board.draw(new Rectangle2D.Double(x,y,40,40));
            board.drawString(c,20f+y,50f);
            a++;
            y=y+40;
        }
      board.setColor(Color.YELLOW); //text color
      game.setBlackcircles(); //set black circles
      game.setWhitecircles(); //set white circles
      int black=game.getBlackcircles(); //# of black circles
      int white=game.getWhitecircles(); //# of white circles
      board.drawString("Black circles: "+black,70f,15f);
      board.drawString("White circles: "+white,300f,15f);
      String player;
      if(game.now=='B') player="Black";
      else player="White";
      board.drawString("Player: "+player,190f,15f);
      board.setColor(Color.BLACK);
      board.fillOval(50,5,13,13);
      board.setColor(Color.WHITE);
      board.fillOval(280,5,13,13);
      board=null;
      r.gc(); //runtime garbage collection
    }
    //mouse callback
    public void mouseClicked(MouseEvent event) {
        if (this.game.getPlayer() == 'B') {
event.translatePoint(-70, -70);
int gety, getx;
getx = event.getX() / 40;
gety = event.getY() / 40;
if(!this.game.getSquare(gety,getx).getAdd_circle()) JOptionPane.showMessageDialog(this,"You can not place a circle here");
if ((getx >= 0) && (gety >= 0) && (getx <= 6) && (gety <= 6) && (this.game.getSquare(gety, getx).getAdd_circle())) {
this.game.makeMove(gety, getx, this.game.getPlayer());
//for(int i=0;i<this.game.getSquare(gety,getx).getChangesSize();i++)System.out.println("allages B: " + (int) this.game.getSquare(gety, getx).getChange(i).getX() + " ," + (int) this.game.getSquare(gety, getx).getChange(i).getY());
this.game.setPlayer();
this.repaint();
}

}
this.repaint();
//this.game.setPlayer();
r.gc();
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseDragged(MouseEvent event) {
    }

    public void mouseMoved(MouseEvent event) {
    }
}
