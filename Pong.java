import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
/*
Arnav Pawar
4/1/18
 */

public class Pong extends JPanel implements ActionListener
{
    Timer clock;
    int velosityX;     
    int velosityY;     
    int posx;
    int posy;
    int middlex;
    int middley;
    int paddle;
    int paddle2;
    int score1;
    int score2;
    
    Pong()
    //Defines starting score, speed, and position
    {
        clock = new Timer (60,this);
        clock.start();
        velosityX = 5;
        velosityY = 5;
        middlex = 300;
        middley = 350;
        posx = middlex;
        posy = middley;
        score1 = 0;
        score2 = 0;
        

        // setting up JPanel properties for display
        Dimension dim = new Dimension(600,800);
        
        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
        this.setFocusable(true);
    } 
    public void drawItems(Graphics g, int posx, int posy, int paddle, int paddle2, int score1, int score2)
    //Draws all the objects in the game
    {
        g.setColor(Color.white);
        g.fillOval(0 + posx , 0 + posy, 30, 30);
        
        g.setColor(Color.gray);
        g.fillRect(0, 350 + paddle , 25, 100);
        g.fillRect(560, 350 + paddle2, 25, 100);
        
        g.setColor(Color.MAGENTA);
        g.drawLine(300, 70, 300, 770);
        g.drawLine(0, 115, 900, 115);
        g.drawLine(250, 70, 345, 70);
        g.drawLine(250, 114, 250, 70);
        g.drawLine(347, 114, 347, 70);
        
        g.setFont(new Font("Sherif" , Font.BOLD, 20));
        g.drawString("      My Pong Game ", 190, 50);
        g.drawString(" " + score1, 260, 100);
        g.drawString(" " + score2, 315, 100);
        g.drawString("Arnav Pawar" , 100, 100);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        drawItems(g, posx, posy, paddle, paddle2, score1, score2);
    }
    public void actionPerformed(ActionEvent e) 
    //Contrpls the movement of the ball
    {
        if (posx <= -25)
        {
            velosityX = 5;
            velosityY = 5;
            velosityX = (velosityX * -1);
            posx = middlex;
            posy = middley;
            score2 ++;
        }
        if (posx >= 585)
        {
            velosityX = 5;
            velosityY = 5;
            velosityX = (velosityX * -1);
            posx = middlex;
            posy = middley;
            score1 ++;
        }
        if (posy <= 115)
        {
            velosityY = (velosityY * -1);
        }
        if (posy >= 724)
        {
            velosityY = (velosityY * -1);
        }
        if((posx == 25) && (posy >= 325 + paddle && posy <= 450 + paddle))
        //Increases the difficulty by increasing velocity after every two hits
        {
            velosityX = (velosityX * -1);            
        }
        if ((posx == 535) && (posy >= 325 + paddle2 && posy <= 450 + paddle2))
        {
            velosityX = (velosityX * -1);
        }
        posx += velosityX;
        posy += velosityY;
        repaint ();
    }
    @Override
    public void addNotify()
    {
        super.addNotify();
        addKeyListener(new KeyHandler());
    }
    public class KeyHandler extends KeyAdapter implements KeyListener
    {
        @Override
        public void keyPressed (KeyEvent e)
        //Allows user to control paddles with keyboard
        {
            String key = KeyEvent.getKeyText(e.getKeyCode());
            if(key.equals("Up"))
                paddle2 = paddle2 - 10;
            if(key.equals("Down"))
                paddle2 = paddle2 + 10;
            if(key.equals("W"))
                paddle = paddle - 10;
            if(key.equals("S"))
                paddle = paddle + 10;
            repaint();
            System.out.println(e + " keypress");
        }
        @Override
        public void keyReleased (KeyEvent e)
        {
            repaint();
            System.out.println(e + " keyReleased");
        }
        @Override
        public void keyTyped (KeyEvent e)
        {
            repaint();
            System.out.println(e + " keyTyped");
        }
    }
}

