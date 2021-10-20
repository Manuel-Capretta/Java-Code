import java.awt.*;

public class snake {
    boolean hitWall = false;
    int score = 0;

    public void spawn(int x, int y, Graphics g, int size, int margin) {
        g.setColor(new Color(80, 200, 80));
        g.fillRect(x * size + margin, y * size + margin, size, size);
    }

    public void score(int counter, Graphics g){
        String a2 = Integer.toString(counter); //convert the counter into a string
        g.setColor(new Color(0, 0, 0));
        g.fillRect(8, 50, 25, 25);
        g.setColor(new Color(255, 255, 255));
        g.drawString(a2, 16, 67); //show counter on the tile

    }

    public int checkIfHitWallOnX(int snakeX) {
        if (snakeX < 0) {
            snakeX = 40;
            return snakeX;
        } else if (snakeX > 39) {
            snakeX = -1;
            return snakeX;
        } else {
            return snakeX;
        }
    }

    public int checkIfHitWallOnY(int snakeY) {
        if (snakeY < 0) {
            snakeY = 40;
            return snakeY;
        } else if (snakeY > 39) {
            snakeY = -1;
            return snakeY;
        } else {
            return snakeY;
        }
    }

    /*public void tail(int xPos, int yPos, Graphics g, int size, int margin){
        int xArr[] = new int[xPos];
        int yArr[] = new int[yPos];

        g.setColor(new Color(255, 255, 255));
        g.fillRect(xArr[0] * size + margin, yArr[0] * size + margin, size, size);
    }*/

    /*public void addBody(int xPos, int yPos, Graphics g, int size, int margin, int score){


        g.setColor(new Color(120, 200, 120));
        g.fillRect(xArr[1] * size + margin, yArr[1] * size + margin, size, size);
    }*/
}
