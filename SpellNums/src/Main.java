import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int num = input();
        spell(num);
    }

    public static int input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1 digit int plz:");
        int Zahl = scan.nextInt();
        return Zahl;
    }

    public static void spell(int num){
        switch (num){
            case 0:
                System.out.println("This number is named:");
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("This number is named:");
                System.out.println("One");
                break;
            case 2:
                System.out.println("This number is named:");
                System.out.println("Two");
                break;
            case 3:
                System.out.println("This number is named:");
                System.out.println("Three");
                break;
            case 4:
                System.out.println("This number is named:");
                System.out.println("Four");
                break;
            case 5:
                System.out.println("This number is named:");
                System.out.println("Five");
                break;
            case 6:
                System.out.println("This number is named:");
                System.out.println("Six");
                break;
            case 7:
                System.out.println("This number is named:");
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("This number is named:");
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("This number is named:");
                System.out.println("Nine");
                break;
            default:
                System.out.println("This ain't a 1 digit number pal!");
                break;
        }
    }
}
