import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayingField extends JFrame implements KeyListener, ActionListener {   // extends -> Playing field child of Jframe
    //Variables
    int fieldSizeInTiles = 40; //40x40 grid
    int halfTileLength = 10; //20px tile length
    int fieldSizeInPx = 900; //1000x1000 window
    boolean gridDrawn = false; //checking if grid is drawn

    //generate food item
    tile apple = new tile();//generate new food item object
    int appleX;//positions
    int appleY;
    boolean foodSpawned = false; //checking if food is there

    //snake
    snake snake = new snake();
    int xPos = 1;
    int yPos = 2;
    int appleCounter = 0;

    //Snake body
    int xArr[] = new int[40];
    int yArr[] = new int[40];
    int test = 4;

    public PlayingField() {
        setTitle("Snake Game Board");
        setSize(fieldSizeInPx, fieldSizeInPx);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(this);

        Timer t = new Timer(150, this);
        t.start();
    }

    // draw with paint method
    public void paint(Graphics g) {
        int counter = 10; //counter for numbers in tiles. Starts with 10 due to simplicity
        /*int aAddon = (halfTileLength/5)*4; //somewhat middles x-axis
        /int bAddon = (halfTileLength/5)*6; //somewhat middles y-axis*/
        int drawField[][] = new int[fieldSizeInTiles][fieldSizeInTiles]; //save field in 2d arr -> [row][column]
        int multi = halfTileLength*2; //Multiply by total tile length
        int margin = 50; //a little margin for better visibility

        //Creation of Grid & Array
        for (int row = 0; row < fieldSizeInTiles; row++) {
            for (int column = 0; column < fieldSizeInTiles; column++) {
                drawField[row][column] = counter; //save every tile in the array
                //Draw Grid Squares (no tile objects)
                g.setColor(new Color(59, 59, 56)); //smokey
                g.fillRect(column * multi + margin, row * multi + margin, halfTileLength * 2, halfTileLength * 2);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(column * multi + margin, row * multi + margin, halfTileLength * 2, halfTileLength * 2);
            /*String a2 = Integer.toString(counter); //convert the counter into a string
            /g.drawString(a2, column*multi+margin+aAddon, row*multi+margin+bAddon); //show counter on the tile*/
                counter++;
            }
        }

        if(!gridDrawn) {
            //print field positions into console
            for (int a = 0; a < fieldSizeInTiles; a++) {
                for (int b = 0; b < fieldSizeInTiles; b++) {
                    System.out.print(drawField[a][b] + "  ");
                }
                System.out.println("\n");
            }//
            gridDrawn = true;
        }

        //Spawn food
        if(!foodSpawned) {
            //generate 2 random positions
            appleX = apple.rand(fieldSizeInTiles);
            appleY = apple.rand(fieldSizeInTiles);
            //spawn food item
            apple.spawn(appleX, appleY, g, halfTileLength*2, margin);
            foodSpawned = true;
            /*print out apples position in array
            System.out.print(drawField[appleX][0] + "\n");
            System.out.print(drawField[0][appleY] + "\n");
            System.out.print(drawField[appleX][appleY] + "\n");*/
        } else {
            apple.spawn(appleX, appleY, g, halfTileLength*2, margin);
        }

        //movements
        if(keyDown){
            yPos++;
        } else if(keyUp){
            yPos--;
        } else if(keyRight){
            xPos++;
        } else if(keyLeft){
            xPos--;
        } else {
            yPos++;
        }

        //draw snake head
        snake.spawn(xPos, yPos, g, halfTileLength*2, margin);

        //If snake hits apple
        if(xPos == appleX && yPos == appleY){
            appleCounter++;
            System.out.println("\n Apples eaten: "+ appleCounter + "\n");
            foodSpawned = false;
        }

        //check if snake hits wall on x or y
        xPos = snake.checkIfHitWallOnX(xPos);
        yPos = snake.checkIfHitWallOnY(yPos);

        //Score
        snake.score(appleCounter, g);

        //Make two tile trail the head
        xArr[0] = xPos;
        yArr[0] = yPos;

        System.out.println("\nSnake Positions:" +
                "\nHead X: " + xArr[0] +
                "\nHead Y: " + yArr[0] +
                "\nBody1 X: " + xArr[1] +
                "\nBody1 Y: " + yArr[1] +
                "\nBody2 X: " + xArr[2] +
                "\nBody2 Y: " + yArr[2]);

        //1st body part
        g.setColor(new Color(120, 200, 120));
        g.fillRect(xArr[1] * halfTileLength*2 + margin, yArr[1] * halfTileLength*2 + margin, halfTileLength*2, halfTileLength*2);

        //2nd body part
        g.fillRect(xArr[2] * halfTileLength*2 + margin, yArr[2] * halfTileLength*2 + margin, halfTileLength*2, halfTileLength*2);

        //3rd body part
        g.fillRect(xArr[3] * halfTileLength*2 + margin, yArr[3] * halfTileLength*2 + margin, halfTileLength*2, halfTileLength*2);

        //4th body part
        g.fillRect(xArr[4] * halfTileLength*2 + margin, yArr[4] * halfTileLength*2 + margin, halfTileLength*2, halfTileLength*2);

        for(int i = test; i > 0; i--){
            yArr[i] = yArr[i-1];
            xArr[i] = xArr[i-1];
        }


            /*yArr[2] = yArr[1];
            xArr[2] = xArr[1];
            yArr[1] = yArr[0];
            xArr[1] = xArr[0];*/


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    boolean keyDown = false; //in order to prevent big jumps
    boolean keyUp = false; //in order to prevent big jumps
    boolean keyLeft = false; //in order to prevent big jumps
    boolean keyRight = false; //in order to prevent big jumps

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN && !keyDown){
            keyDown = true;
            keyUp = false;
            keyLeft = false;
            keyRight = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP && !keyUp){
            keyDown = false;
            keyUp = true;
            keyLeft = false;
            keyRight = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT && !keyLeft) {
            keyDown = false;
            keyUp = false;
            keyLeft = true;
            keyRight = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !keyRight){
            keyDown = false;
            keyUp = false;
            keyLeft = false;
            keyRight = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clock's ticking");
        repaint();
    }
}

/*-------------------------2D Array-------------------------*
/*int twoDArr[][] = new int[3][3];

int counter = 1;
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        twoDArr[i][j] = counter;
        counter++;
    }
}

for (int a = 0; a < 3; a++) {
    for (int b = 0; b < 3; b++){
        System.out.println(twoDArr[a][b]);
    }
}*/
/*----------------------------------------------------------*/