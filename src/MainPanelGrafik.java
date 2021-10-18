import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit


public class MainPanelGrafik extends JFrame   // extends heist MainPanel ist ein "Kind" von JFrame
{

    public MainPanelGrafik()
    {
        setTitle("Mein erstes GUI Fenster");
        setSize(500,500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // wir brauchen eine Methode "paint" um etwas zeichnen kann
    public void paint(Graphics g) {



        //Solution 1: Lines
        /*for(int i = 0; i < 500; i+= 25){
            g.drawLine(i, 0, i, 500);
            g.drawLine(0, i, 500, i);
        }*/



        //Solution 2: Rectangles
        for(int a = 25; a < 475; a+=50) {
            for(int b= 25; b < 475; b+=50) {
                g.setColor(new Color(255, 0, 0));
                g.fillRect(a, b, 50, 50);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(a, b, 50, 50);
            }
        }



    }
}