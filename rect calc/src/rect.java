import java.awt.*;

//objects are always generated in a new class for simplifying and easy-to-use purposes
public class rect {
    int l;
    int w;
    Color color;


    public int area(int l, int w) { //method for calculating area value
        return l * w;
    }

    public int scope(int l, int w) { //method for calculating scope value
        return 2 * (l * w);
    }

    //Color stuff
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}