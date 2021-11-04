import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mass masses = new mass(); //create mass object along with built-in units
        Converter Converter = new Converter(); //create converter object

        //activate those units
        masses.arrayDeclarations();

        //Inputs
        System.out.print("Value: ");
        int value = value();
        System.out.print("Unit: ");
        String unit = unit();

        //Calculation
        int newValue[] = calc(unit, value, Converter, masses);
        output(newValue, unit, masses, value);
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

    public static int[] calc(String unit, int value, Converter Converter, mass unitArray){

        //Solution variables
        int solArr[] = new int[2];

        //conversion to MM
        value = Converter.convertToSmallest(unit, value, unitArray);

        //conversion to the biggest massUnit
        solArr = Converter.convertToBiggest(unit, value, solArr, unitArray);

        return solArr;
    }

    public static void output(int solArr[], String unit, mass unitArray, int value){

        int unitInt = solArr[1];

        //Check for used massUnit and go on from there
        for(int i = 0; i < 5; i++){
            if(unit.equals(unitArray.meters[i].name)){ //check which massUnit we're using
                System.out.println(value + unit + " converted into the biggest possible unit\nSolution: " + solArr[0]+ " " + unitArray.meters[unitInt].name);
                break;
            } else if(unit.equals(unitArray.liquids[i].name)){ //check which massUnit we're using
                System.out.println(value + unit + " converted into the biggest possible unit\nSolution: " + solArr[0]+ " " + unitArray.liquids[unitInt].name);
                break;
            }
        }
    }
}