//package com.company;    //Login nach 3 falschen Versuchen aufhören
import java.util.*;

public class main {

    public static void main(String[] args) {
        int tries = 1;
        boolean isdone = false;

        //first activations
        String inputLogin = input(tries, isdone);
        login(inputLogin, tries, isdone);
    }

    public static String input(int tries, boolean isdone) {
        //get users input
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Password: ");
        String inputLogin = sc1.nextLine();

        //check if he already did input before
        //if yes, check it again in this method
        if(isdone){
            isdone = false;
            main.login(inputLogin, tries, isdone);
        }
        return inputLogin;
    }

    public static int login(String log, int tries, boolean isdone) {
        //actual pass
        String pass = "123lol";
        //check if all tries are used
        if (tries < 3) {//if he used 3 tries or not
            //if it is correct
            if(log.equals(pass)){
                System.out.println("Success");
            }else{
                //if incorrect, add a try, let him input again
                tries++;
                System.out.println("Try again");
                isdone = true;
                input(tries, isdone);
            }
        }else{
            //you failed you dummy
            System.out.println("no tries left");
        }
        return tries;
    }
}