import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayingField extends JFrame implements KeyListener, ActionListener {   // extends -> Playing field child of Jframe
    //Variables
    int fieldSizeInTiles = 40; //40x40 grid
    int tileSize = 20; //20px tile length
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
    int appleCounter = 1; //start with 1 body part

    //Body
    //array contain as many indexes as there are tiles in the grid
    int xArr[] = new int[fieldSizeInTiles*fieldSizeInTiles];
    int yArr[] = new int[fieldSizeInTiles*fieldSizeInTiles];

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
        int multi = tileSize; //Multiply by total tile length
        int margin = 70; //a little margin for better visibility

        //put head position in array
        xArr[0] = xPos;
        yArr[0] = yPos;

        //Creation of Grid & Array
        for (int row = 0; row < fieldSizeInTiles; row++) {
            for (int column = 0; column < fieldSizeInTiles; column++) {
                drawField[row][column] = counter; //save every tile in the array
                //Draw Grid Squares (no tile objects)
                g.setColor(new Color(59, 59, 56)); //smokey
                g.fillRect(column * multi + margin, row * multi + margin, tileSize, tileSize);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(column * multi + margin, row * multi + margin, tileSize, tileSize);
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
            apple.spawn(appleX, appleY, g, tileSize, margin);
            foodSpawned = true;
        } else {
            apple.spawn(appleX, appleY, g, tileSize, margin);
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
        snake.spawn(xPos, yPos, g, tileSize, margin);

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
        //display snake head infos on the game board
        int arrayLoopSize = snake.score(appleCounter, g);//displays the number of apples eaten
        g.drawString("Snake Head x-Position: " + xArr[0], 100, 50); //show counter on the tile
        g.drawString("Snake Head y-Position: " + yArr[0], 300, 50); //show counter on the tile
        g.drawString("Snake Head is on tile: " + drawField[xPos][yPos], 500, 50); //show counter on the tile
        g.drawString("Body parts: " + appleCounter, 700, 50); //show counter on the tile

        //draw new body part
        for(int j = 0; j < arrayLoopSize; j++) {//draw as many body parts as apples were eaten
            snake.spawnBody(xArr[j], yArr[j], g, tileSize, margin);
        }
        //pass down positions
        for(int i = arrayLoopSize; i > 0; i--){//pass down values into the array as far as apple were eaten
            yArr[i] = yArr[i-1];
            xArr[i] = xArr[i-1];
        }

        for(int j = 0; j < arrayLoopSize; j++) {//show all the positions in the console
            System.out.println("\nSnake Position:" + j +
                    "\nHead X: " + xArr[j] +
                    "\nHead Y: " + yArr[j]);
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