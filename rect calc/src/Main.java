import java.awt.*;

public class Main {
    public static void main(String[] args){
        rect first_obj = new rect(); //generate new object
        first_obj.l = 2; //give values
        first_obj.w = 3;

        first_obj.setColor(new Color(69));

        int area = first_obj.area(); //calc area
        int scope = first_obj.scope(); //calc scope

        System.out.println(
                "Area: " + area + "\n"
                + "Scope: " + scope + "\n"
                + "Color: " + first_obj.getColor().toString());
    }
}