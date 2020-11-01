//*
//Arnav Pawar
//4/9/18
 //*/
import javax.swing.JFrame;     //class for main canvas(window)
import java.awt.*;

public class FrameSetup {
    
    public static void initializeJFrame(JFrame jf){
        
        jf.getContentPane().setBackground(Color.blue);    //set color of main window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the exit icon work correctly
        jf.setSize(600,800);                 //sets the size of the window
    //    jf.setLayout(new FlowLayout(0));
        jf.setLocationRelativeTo(null);                    //centers the window
        jf.setTitle("My Pong Game");                  // sets the title bar
        jf.setVisible(true);                              // makes the window visible
    }
    public static void main(String[] args) 
    {
        JFrame window = new JFrame();            //makes a jframe
                        
      
        Pong panel1 = new Pong(); 
        window.add(panel1);                 //adds the jpanel to your window
        
        initializeJFrame(window);          //initializes the window to your settings 
    }
}
