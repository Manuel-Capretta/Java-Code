import java.awt.*;

public class snake {
    boolean hitWall = false;
    int score = 0;

    public void spawn(int x, int y, Graphics draw, int size, int margin) {
        draw.fillRect(x * size + margin, y * size + margin, size, size);
    }

    public void spawnBody(int x, int y, Graphics draw, int size, int margin) {
        draw.fillRect(x * size + margin, y * size + margin, size, size);
    }

    public void score(int counter, Graphics draw){
        String a2 = Integer.toString(counter); //convert the counter into a string
        draw.setColor(new Color(0, 0, 0));
        draw.fillRect(8, 33, 25, 25);
        draw.setColor(new Color(255, 255, 255));
        draw.drawString(a2, 16, 50); //show counter on the tile
    }

    public int checkIfHitWallOnX(int snakeX) {
        if (snakeX == -1) {
            snakeX = 39;
            return snakeX;
        } else if (snakeX == 41) {
            snakeX = -1;
            return snakeX;
        } else {
            return snakeX;
        }
    }

    public int checkIfHitWallOnY(int snakeY) {
        if (snakeY == 0) {
            snakeY = 40;
            return snakeY;
        } else if (snakeY == 41) {
            snakeY = 1;
            return snakeY;
        } else {
            return snakeY;
        }
    }
}
