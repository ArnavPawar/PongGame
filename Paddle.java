/*
Arnav Pawar
*/
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class Paddle 
{
    int width;
    int height;
    int posx;
    int posy;
    Color color;
    public Paddle(int x, int y){   
        this.width = 100;
        this.height = 25;
        this.posx = 250;
        this.posy = 725;
        this.color = Color.BLACK;
    }

    public void drawPaddle (Graphics g){
        g.setColor(Color.black);
        g.fillRect(posx, posy, width, height);
    }
    
    public int getw(){    
        return width;
    }
    public int geth(){    
        return height;
    }
    public Rectangle getBounds(){
        return new Rectangle(posx, posy, width, height);
    }
    public void setpx(){
        this.posx = posx;
    }
    public void setpy(){
        this.posy = posy;
    }
    public int getpx(){    
        return posx;
    }
    public int getpy(){   
        return posy;
    }
}
