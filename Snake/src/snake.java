import java.awt.*;

public class snake {
        public void spawn(int x, int y, Graphics g, int size, int margin){
            g.setColor(new Color(80, 200, 80));
            g.fillRect(x*size+margin, y*size+margin, size, size);
        }
}
