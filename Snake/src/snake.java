import java.awt.*;

public class snake {

    public void spawn(int x, int y, Graphics draw, int size, int margin) {
        draw.fillRect(x * size + margin, y * size + margin, size-1, size-1);
    }

    public void spawnBody(int x, int y, Graphics draw, int size, int margin) {
        draw.fillRect(x * size + margin, y * size + margin, size-1, size-1);
    }

    public void score(int counter, Graphics draw){
        int boxWidth;
        String a2 = Integer.toString(counter); //convert the counter into a string
        draw.setColor(new Color(0, 0, 0));
        //score background size fits score
        if(counter < 100) {
            boxWidth = 25;
        } else if(counter < 1000){
            boxWidth = 33;
        } else {
            boxWidth = 50;
        }
        draw.fillRect(12, 33, boxWidth, 25);
        draw.setColor(new Color(255, 255, 255));
        draw.drawString(a2, 16, 50); //show counter on the tile
    }

    public int checkIfHitWallOnX(int snakeX, int fieldSize) {
        if (snakeX < 0) {
            //snakeX = fieldSize-1;
            System.exit(1);
        } else if (snakeX > fieldSize-1) {
            //snakeX = 0;
            System.exit(1);
        } else {
            return snakeX;
        }
        return snakeX;
    }

    public int checkIfHitWallOnY(int snakeY, int fieldSize) {
        if (snakeY < 0) {
            //snakeY = fieldSize-1;
            System.exit(1);
        } else if (snakeY > fieldSize-1) {
            //snakeY = 0;
            System.exit(1);
        } else {
            return snakeY;
        }
        return snakeY;
    }

    public void hitTail(int xArr[], int yArr[], int arraySize){
        for(int i = 1; i < arraySize-1; i++) {
            if (xArr[0] == xArr[i] && yArr[0] == yArr[i]){
                System.exit(1);
            }
        }
    }
}
