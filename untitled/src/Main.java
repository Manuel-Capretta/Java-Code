import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static void main(String[] args){
        int l = input();
        int b = input();

        int f = rectF(l, b);
        int u = rectU(l, b);

        output(f, u);
    }

    public static int input(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a whole number: ");
        int num = reader.nextInt(); //get user num

        return num;
    }

    public static int rectF(int l, int b){
        return l*b; //calc area
    }

    public static int rectU(int l, int b){
        return 2*l + 2*b; //calc scope
    }

    public static void output(int f, int u){
        System.out.println("F = " + f + "\nU = " + u);
    }
}
