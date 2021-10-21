import java.awt.*;  //Abstract Window Toolkit

public class tile {

    public int rand(int field_size, int xArr[], int yArr[], int arrSize) {
        int min = 0;
        int max;
        int xRandom;
        max = field_size-1;//field_size;
        //Generate random int value
        xRandom = (int)Math.floor(Math.random()*(max-min+1)+min);

        //check if the apple has spawned in the snake
        for(int i = 0; i < arrSize; i++){
            if(xRandom == xArr[i]){
                rand(field_size, xArr, yArr, arrSize);
            }
            if(xRandom == yArr[i]){
                rand(field_size, xArr, yArr, arrSize);
            }
        }

        return xRandom;
    }

    public void spawn(int x, int y, Graphics draw, int size, int margin){
        draw.setColor(new Color(215, 10, 40));
        draw.fillOval(x*size+margin, y*size+margin, size-2, size-2);
    }
}
