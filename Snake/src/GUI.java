import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI{
    GUI(){
        JFrame f=new JFrame("Button Example");
        JButton b=new JButton(new ImageIcon("D:\\icon.png"));
        b.setBounds(50,70,100, 40);
        f.add(b);
        f.setSize(100,40);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setText("Play Snake");

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PlayingField p = new PlayingField();
            }
        });
        f.add(b);f.add(b);
        f.setSize(200,200);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void drawSnakeHead(int xArr[], int yArr[], int bodyPart, Graphics draw, int xPos, int yPos, int drawField[][]){
        //display snake head info on the game board
        draw.setColor(new Color(0, 0, 0));
        draw.fillRect(90, 33, 725, 25);
        draw.setColor(new Color(255, 255, 255));
        draw.drawString("Snake Head x-Position: " + xArr[0], 100, 50); //show snake head info on the board
        draw.drawString("Snake Head y-Position: " + yArr[0], 300, 50);
        draw.drawString("Snake Head is on tile: " + drawField[xPos][yPos], 500, 50);
        draw.drawString("Body parts: " + bodyPart, 700, 50);
    }

    public void drawControllInfo(Graphics draw){
        //display control info
        draw.setColor(new Color(0, 0, 0));
        draw.fillRect(8, 135, 50, 120);
        draw.setColor(new Color(255, 255, 255));
        draw.drawString("WASD", 10, 150); //show control info on the board
        draw.drawString("OR", 10, 200); //show control info on the board
        draw.drawString("Arrows", 10, 250); //show control info on the board
    }
}
