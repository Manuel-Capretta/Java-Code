import javax.swing.*;
import java.awt.*;  //Abstract Window Toolkit


public class MainPanelGrafik extends JFrame{   // extends -> PanelGrafik child of Jframe


    //Variables
    int fieldSizeInTiles = 10;
    int halfTileLength = 25;
    int fieldSizeInPx = halfTileLength*22; //Always big enough for 100 tiles

    public MainPanelGrafik() {
        setTitle("Snake");
        setSize(fieldSizeInPx, fieldSizeInPx);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // draw with paint method
    public void paint(Graphics g) {

        int counter = 10; //counter for nums in tiles. Starts with 10 due to simplicity
        int aAddon = (halfTileLength/5)*4; //somewhat middles x axis
        int bAddon = (halfTileLength/5)*6; //somewhat middles y axis
        int drawField[][] = new int[fieldSizeInTiles][fieldSizeInTiles]; //save field in 2d arr -> [row][column]
        int multi = halfTileLength*2; //Multiply by total tile length
        int margin = 25; //a little margin for better visibility

        //Creation of Grid & Array
        for(int row = 0; row < fieldSizeInTiles; row++) {
            for(int column = 0; column < fieldSizeInTiles; column++) {
                drawField[row][column] = counter; //save every tile in the array
                //Draw Squares
                g.setColor(new Color(136, 0, 255));
                g.fillRect(column*multi+margin, row*multi+margin, halfTileLength *2, halfTileLength *2);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(column*multi+margin, row*multi+margin, halfTileLength *2, halfTileLength *2);
                String a2 = Integer.toString(counter); //convert the counter into a string
                g.drawString(a2, column*multi+margin+aAddon, row*multi+margin+bAddon); //show counter on the tile
                counter++;
            }
        }

        //print field positions
        for (int a = 0; a < fieldSizeInTiles; a++) {
            for (int b = 0; b < fieldSizeInTiles; b++){
                System.out.print(drawField[a][b] + "  ");
            }
            System.out.println("\n");
        }//

        /*------------------2D Array--------------------------------*
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
}
