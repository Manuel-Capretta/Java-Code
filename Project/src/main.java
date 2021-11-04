import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Arrays
        String mArr[] = {"mm", "cm", "dm", "m", "km"};
        int mArrNum[] = {0, 10, 100, 1000, 1000000};
        String lArr[] = {"ml", "cl", "dl", "l", "hl"};
        int lArrNum[] = {0, 10, 100, 1000, 100000};

        //Inputs
        System.out.print("Unit: ");
        String unit = unit();
        System.out.print("Value: ");
        int value = value();

        //Calculation
        int newValue[] = calc(unit, value, mArr, lArr, mArrNum, lArrNum);
        output(newValue, unit, mArr, lArr);
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

    public static int[] calc(String unit, int value, String mArr[], String lArr[], int mArrNum[], int lArrNum[]){

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
            if(unit.equals(mArr[a])){
                for (int j = 4; j >= 0; j--) {
                    if (value % mArrNum[j] == 0) {
                        value /= mArrNum[j];
                        unitInt = j; //save array position for output
                        break;
                    }
                }
            }else if(unit.equals(lArr[a])){
                for (int j = 4; j >= 0; j--) {
                    if (value % lArrNum[j] == 0) {
                        value /= lArrNum[j];
                        unitInt = j; //save array position for output
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

    public static void output(int solArr[], String unit, String mArr[], String lArr[]){

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