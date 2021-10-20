import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit

public class tile {

    public int rand(int field_size) {
        int min = 0;
        int max;
        int xRandom;
        max = 10;//field_size;
        //Generate random int value
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        xRandom = (int)Math.floor(Math.random()*(max-min+1)+min);
        return xRandom;
    }

    public void spawn(int x, int y, Graphics g, int size, int margin){
        g.setColor(new Color(215, 10, 40));
        g.fillOval(x*size+margin, y*size+margin, size, size);
    }
}
