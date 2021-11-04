import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        unitObject Converter = new unitObject(); //create converter object

        //Inputs
        System.out.print("Value: ");
        int value = value();
        System.out.print("Unit: ");
        String unit = unit();

        //Calculation
        int newValue[] = calc(unit, value, Converter);
        output(newValue, unit, Converter.mArr, Converter.lArr);
    }

    private static String unit() {
        Scanner scan = new Scanner(System.in);
        String string;

        //Scan
        string = scan.nextLine();
        return string;
    }

    private static int value() {
        Scanner scan = new Scanner(System.in);
        int num;

        //Scan
        num = scan.nextInt();
        return num;
    }

    public static int[] calc(String unit, int value, unitObject Converter){

        //Solution variables
        int solArr[] = new int[2];

        //conversion to MM
        value = Converter.convertToMM(unit, value);

        //conversion to the biggest unit
        solArr = Converter.convertToBiggest(unit, value, solArr);

        return solArr;
    }

    public static void output(int solArr[], String unit, String mArr[], String lArr[]){

        int unitInt = solArr[1];

        //Check for used unit and go on from there
        for(int i = 0; i < 5; i++){
            if(unit.equals(mArr[i])){ //check which unit we're using
                System.out.println(solArr[0]+ " " + mArr[unitInt]);
                break;
            } else if(unit.equals(lArr[i])){ //check which unit we're using
                System.out.println(solArr[0]+ " " + lArr[unitInt]);
                break;
            }
        }
    }
}