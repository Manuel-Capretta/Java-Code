import java.awt.*;  //Abstract Window Toolkit

public class tile {

    public int rand(int field_size, int xArr[], int yArr[], int arrSize) {
        int min = 0;
        int max;
        int randNum;
        max = field_size-1;//field_size;
        //Generate random int value
        randNum = (int)Math.floor(Math.random()*(max-min+1)+min);

        //check if the apple has spawned in the snake
        for(int i = 0; i < arrSize; i++){
            if(randNum == xArr[i]){
                randNum = (int)Math.floor(Math.random()*(max-min+1)+min);
            }
            if(randNum == yArr[i]){
                randNum = (int)Math.floor(Math.random()*(max-min+1)+min);
            }
        }

        return randNum;
    }

    public void spawn(int x, int y, Graphics draw, int size, int margin){
        draw.setColor(new Color(215, 10, 40));
        draw.fillOval(x*size+margin, y*size+margin, size-2, size-2);
    }
}
