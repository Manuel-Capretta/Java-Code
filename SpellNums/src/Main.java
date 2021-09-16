import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int num = input();
        checkForLastDigit(num);
    }

    public static int input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1 digit int plz:");
        int userNum = scan.nextInt();
        return userNum;
    }

    public static void checkForLastDigit(int num){
        if(num%10==0){//check if last digit is 0
            System.out.println("zero");
        }else{ //check for the other digits
            if(num%3==0){
                System.out.println("three");
            }else if(num%4==0){
                System.out.println("four");
            }else if(num%6==0){
                System.out.println("six");
            }else if(num%7==0){
                System.out.println("seven");
            }else if(num%8==0){
                System.out.println("eight");
            }else if(num%9==0){
                System.out.println("nine");
            }else if(num%5==0){
                System.out.println("five");
            }else if(num%2==0){
                System.out.println("two");
            }else{
                System.out.println("one");
            }
        }
    }
}
