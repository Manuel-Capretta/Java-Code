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
    public void paint(Graphics g)
    {
        g.setColor(new Color(200,0,0));  // Farbe setzten in RGB
        g.drawRect(10,31,100,100);	   // Zeichnen eines Rechtecks

        g.setColor(new Color(100,100,10));
        g.fillRect(300,300,100,100);

        g.setColor(new Color(250,50,50));
        g.fillOval(200,200,100,100);
    }

    public static void Main(String[] args) {

        MainPanelGrafik p = new MainPanelGrafik();   // hier instanziieren wir das Panel Objekt (Zeichenfenster)

        //p.paint(null);                // wir rufen die Zeichnungsfunktion auf.

    }



}