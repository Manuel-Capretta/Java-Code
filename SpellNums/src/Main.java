//Help from David & https://codippa.com/how-to-convert-number-to-words-in-java/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nummer = input();
        String wort = numberToWord(nummer);
        output(wort);
    }

    public static int input(){
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib mit eine max. 9-Stellige Zahl:");
        number = scanner.nextInt();
        return number;
    }

    public static void output(String wort){
        System.out.println(wort);
    }

    public static String numberToWord(int number) {
        // variable to hold string representation of number
        String words = "";
        String unitsArray[] = { "null", "ein", "zwei", "drei", "vier", "fünf", "sechs",
                "sieben", "acht", "neun", "zehn", "elf", "zwölf",
                "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn",
                "achtzehn", "neunzehn" , "zwanzig"};
        String tensArray[] = { "null", "zehn", "zwanzig", "dreissig", "vierzig", "fünfzig",
                "sechzig", "siebzig", "achzig", "neunzig" };

        if (number == 0) {
            return "null";
        }

/*---------------------------------------------------------------------------------------------------*/
        // add minus before conversion if the number is less than 0
        // this part is copied
        if (number < 0) {
            // convert the number to a string
            String numberStr = "" + number;
            // remove minus before the number
            numberStr = numberStr.substring(1);
            // add minus before the number and convert the rest of number
            return "minus " + numberToWord(Integer.parseInt(numberStr));
        }
/*---------------------------------------------------------------------------------------------------*/

        // check if number is divisible by 1 million and determine its grammar
        if ((number / 1000000) > 0) {
            if(number < 2000000){
                words += numberToWord(number / 1000000) + "e million ";
                number %= 1000000;
            } else {
                words += numberToWord(number / 1000000) + " millionen ";
                number %= 1000000;
            }
        }
        // check if number is divisible by 1000
        if ((number / 1000) > 0) {
            words += numberToWord(number / 1000) + " tausend ";
            number %= 1000;
        }
        // check if number is divisible by 100
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " hundert ";
            number %= 100;
        }
        if (number > 0) {
            // check if number is within tens
            if (number < 21) {
                // get the appropriate value from unit array
                words += unitsArray[number];
            } else {
                //Get the last digit of the number in order to get the right value from units array
                words += unitsArray[number % 10];
                if ((number % 10) > 0) {
                    // get the appropriate value from tens array
                    words += " und " + tensArray[number / 10];
                }
            }
        }
        return words;
    }
}