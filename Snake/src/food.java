import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit

public class food {
    //int score = 0;

    public int rand(int field_size) {
        int min = 0;
        int max;
        int xRandom;
        max = field_size;
        //Generate random int value
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        xRandom = (int)Math.floor(Math.random()*(max-min+1)+min);
        return xRandom;
    }

    public void spawn(int x, int y, Graphics g, int size){
        int margin = 40; //a little margin for better visibility
        g.setColor(new Color(215, 10, 40));
        g.fillOval(x*size+margin, y*size+margin, size, size);
    }
}
