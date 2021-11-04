import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //Inputs
        System.out.print("Unit: ");
        String unit = unit();
        System.out.print("Value: ");
        int value = value();

        //Calculation
        int newValue[] = calc(unit, value);
        output(newValue, unit);
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

    public static int[] calc(String unit, int value){
        String mArr[] = {"mm", "cm", "dm", "m", "km"};
        int mArrNum[] = {0, 10, 100, 1000, 1000000};
        String lArr[] = {"ml", "cl", "dl", "l", "hl"};
        int lArrNum[] = {0, 10, 100, 1000, 100000};

        //Solution variables
        int solArr[] = new int[2];
        int unitInt = 0;

        //recalculate into the smallest unit
        for(int i = 0; i < 5; i++){
            if(unit.equals(mArr[i])){
                value = value * mArrNum[i];
                break;
            } else if(unit.equals(lArr[i])){
                value = value * mArrNum[i];
                break;
            }
        }

        //recalculate into biggest unit
        for(int a = 0; a < 5; a++) {
            unitInt = a; //save array position for output
            if(unit.equals(mArr[a])){
                for (int j = 4; j > -1; j--) {
                    if (value % mArrNum[j] == 0) {
                        value /= mArrNum[j];
                        break;
                    }
                }
            }else if(unit.equals(lArr[a])){
                unitInt = a; //save array position for output
                for (int j = 4; j > -1; j--) {
                    if (value % lArrNum[j] == 0) {
                        value /= lArrNum[j];
                        break;
                    }
                }
            }
        }

        //Save value and unit into solArr
        solArr[0] = value;
        solArr[1] = unitInt;
        return solArr;
    }

    public static void output(int solArr[], String unit){
        String mArr[] = {"mm", "cm", "dm", "m", "km"};
        String lArr[] = {"ml", "cl", "dl", "l", "hl"};

        int unitInt = solArr[1];

        //Check for used unit and go on from there
        for(int i = 0; i < 5; i++){
            if(unit.equals(mArr[i])){
                System.out.println(solArr[0]+ " " + mArr[unitInt]);
                break;
            } else if(unit.equals(lArr[i])){
                System.out.println(solArr[0]+ " " + lArr[unitInt]);
                break;
            }
        }
    }
}