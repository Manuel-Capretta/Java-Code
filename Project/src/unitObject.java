public class unitObject {
    //Arrays
    String mArr[] = {"mm", "cm", "dm", "m", "km"};
    int mArrNum[] = {1, 10, 100, 1000, 1000000};
    String lArr[] = {"ml", "cl", "dl", "l", "hl"};
    int lArrNum[] = {1, 10, 100, 1000, 100000};

    public int convertToMM(String unit, int value){
        //convert into the smallest unit
        for(int i = 0; i < 5; i++){
            if(unit.equals(mArr[i])){ //check which unit we're using
                value *= mArrNum[i]; //convert value to mm
                System.out.println("CONVERTING VALUE INTO MM...\nValue is now: " + value);
                break;
            } else if(unit.equals(lArr[i])){ //check which unit we're using
                value *= mArrNum[i]; //convert value to mm
                System.out.println("CONVERTING VALUE INTO MM...\nValue is now: " + value);
                break;
            }
        }

        return value;
    }

    public int[] convertToBiggest(String unit, int value, int solArr[]){
        int unitInt = 0;

        //convert into the biggest possible unit
        for(int a = 0; a < 5; a++) {
            if(unit.equals(mArr[a])){ //check which unit we're using
                for (int j = 4; j >= 0; j--) {
                    if (value % mArrNum[j] == 0) { //check for biggest number that %=0
                        value /= mArrNum[j]; //make value as small as possible
                        unitInt = j; //save array position for output
                        System.out.println("Saving numbers " + value + " " + unitInt + "...");
                        break;
                    }
                }
            }else if(unit.equals(lArr[a])){
                for (int j = 4; j >= 0; j--) { //check which unit we're using
                    if (value % lArrNum[j] == 0) { //check for biggest number that %=0
                        value /= lArrNum[j]; //make value as small as possible
                        unitInt = j; //save array position for output
                        System.out.println("Saving numbers " + value +  " " + unitInt+ "...");
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
}
