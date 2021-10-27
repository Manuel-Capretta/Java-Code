import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayingField extends JFrame implements KeyListener, ActionListener {   // extends -> Playing field child of Jframe
    //Field Variables
    int fieldSizeInTiles = 20; //grid
    int tileSize = (40/fieldSizeInTiles)*20; //tile length -> formula works for 10x10, 20x20 and 40x40 grids
    int fieldSizeInPx = 900; //1000x1000 window
    boolean gridDrawn = false; //checking if grid is drawn
    boolean fieldDrawn = false;

    //generate food item
    tile apple = new tile();//generate new food item object
    int appleX;//positions
    int appleY;
    boolean foodSpawned = false; //checking if food is there

    //snake
    snake snake = new snake();
    int xPos = 2;
    int yPos = 2;
    int bodyPart = 1; //start with 1 body part

    //score
    boolean timeIsTicking = false;
    int timeUsed = 0;
    int Score;

    //Body
    //array contain as many indexes as there are tiles in the grid
    int arraySize = fieldSizeInTiles*fieldSizeInTiles;
    int xArr[] = new int[arraySize];
    int yArr[] = new int[arraySize];

    //Gui
    GUI gui = new GUI();

    public PlayingField() {
        setTitle("Snake Game Board");
        setSize(fieldSizeInPx, fieldSizeInPx);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(this);

        Timer t = new Timer(200, this);
        t.start();
    }

    // draw with paint method
    public void paint(Graphics draw) {
        int counter = 0; //counter for numbers in tiles. Starts with 10 due to simplicity
        int drawField[][] = new int[fieldSizeInTiles][fieldSizeInTiles]; //save field in 2d arr -> [row][column]
        int multi = tileSize; //Multiply by total tile length
        int margin = 60; //a little margin for better visibility

        //put head position in array
        xArr[0] = xPos;
        yArr[0] = yPos;

        //Creation of Grid & Array
        if(!fieldDrawn) {
            for (int row = 0; row < fieldSizeInTiles; row++) {
                for (int column = 0; column < fieldSizeInTiles; column++) {
                    //Draw Grid Squares (no tile objects)
                    draw.setColor(new Color(59, 59, 56)); //smokey
                    draw.fillRect(column * multi + margin, row * multi + margin, tileSize-1, tileSize-1);
                }
            }
            fieldDrawn = true;
        }

        //Array for coordinates and grid lines
        for (int row = 0; row < fieldSizeInTiles; row++) {
            for (int column = 0; column < fieldSizeInTiles; column++) {
                drawField[row][column] = counter; //save every tile in the array
                counter++;
                draw.drawLine(row, 0, row, 40);
                draw.drawLine(0, column, 40, column);
            }
        }

        if(!gridDrawn) {
            //print field positions into console
            for (int a = 0; a < fieldSizeInTiles; a++) {
                for (int b = 0; b < fieldSizeInTiles; b++) {
                    System.out.print(drawField[a][b] + "  ");
                }
                System.out.println("\n");
            }
            gridDrawn = true;
        }

        //Spawn food
        if(!foodSpawned) {
            //generate 2 random positions
            appleX = apple.rand(fieldSizeInTiles, xArr, yArr, bodyPart);
            appleY = apple.rand(fieldSizeInTiles, xArr, yArr, bodyPart);
            //spawn food item
            apple.spawn(appleX, appleY, draw, tileSize, margin);
            //apple has spawned
            foodSpawned = true;
            timeIsTicking = true;
        }

        //spawn snakes tail
        draw.setColor(new Color(59, 59, 56)); //smokey
        snake.spawnBody(xArr[bodyPart], yArr[bodyPart], draw, tileSize, margin);

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
        draw.setColor(new Color(80, 200, 80));
        snake.spawn(xPos, yPos, draw, tileSize, margin);

        //If snake hits apple
        if(xPos == appleX && yPos == appleY){
            bodyPart++;
            System.out.println("\n Apples eaten: "+ bodyPart + "\n");
            foodSpawned = false;
            timeIsTicking = false;

            //Score calculating
            if(timeUsed < fieldSizeInTiles/2){
                Score += 100;
            } else {
                Score += 50;
            }
            snake.score(Score, draw);//displays the number of apples eaten
        }

        //check if snake hits wall on x or y and if it hits tail -> end the program
        xPos = snake.checkIfHitWallOnX(xPos, fieldSizeInTiles);
        yPos = snake.checkIfHitWallOnY(yPos, fieldSizeInTiles);
        snake.hitTail(xArr, yArr, arraySize);


        //Score
        int arrayLoopSize = bodyPart;
        gui.drawSnakeHead(xArr, yArr, bodyPart, draw, xPos, yPos, drawField);
        gui.drawControllInfo(draw);

        //draw new body part
        draw.setColor(new Color(80, 150, 80));
        for(int j = 0; j < arrayLoopSize; j++) {//draw as many body parts as apples were eaten
            snake.spawnBody(xArr[j], yArr[j], draw, tileSize, margin);
        }
        //pass down positions
        for(int i = arrayLoopSize; i > 0; i--){//pass down values into the array as far as apple were eaten
            yArr[i] = yArr[i-1];
            xArr[i] = xArr[i-1];
        }
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
        if(e.getKeyCode() == KeyEvent.VK_DOWN && !keyDown || e.getKeyCode() == KeyEvent.VK_S && !keyDown) {
            keyDown = true;
            keyUp = false;
            keyLeft = false;
            keyRight = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP && !keyUp  || e.getKeyCode() == KeyEvent.VK_W && !keyUp){
            keyDown = false;
            keyUp = true;
            keyLeft = false;
            keyRight = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT && !keyLeft || e.getKeyCode() == KeyEvent.VK_A && !keyLeft ) {
            keyDown = false;
            keyUp = false;
            keyLeft = true;
            keyRight = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !keyRight  || e.getKeyCode() == KeyEvent.VK_D && !keyRight){
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
        if(timeIsTicking){ //ticker
            timeUsed++;
        }
        repaint(); //refresh
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