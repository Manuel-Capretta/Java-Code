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

    //Test
    int xPos = 1;
    int yPos = 2;

    public PlayingField() {
        setTitle("Snake Game Board");
        setSize(fieldSizeInPx, fieldSizeInPx);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(this);

        Timer t = new Timer(500, this);
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

        g.drawRect(xPos*halfTileLength*2+margin, yPos*halfTileLength*2+margin, halfTileLength*2, halfTileLength*2);

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
