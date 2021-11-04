public class Converter {
    public int convertToSmallest(String unit, int value, mass unitArray){
        //convert into the smallest unit
        for(int i = 0; i < 5; i++){
            if(unit.equals(unitArray.meters[i].name)){ //check which unit we're using
                value *= unitArray.meters[i].factor; //convert value to mm
                System.out.println("CONVERTING VALUE INTO MM...\nValue is now: " + value);
                break;
            }
            if(unit.equals(unitArray.liquids[i].name)){ //check which unit we're using
                value *= unitArray.liquids[i].factor; //convert value to mm
                System.out.println("CONVERTING VALUE INTO MM...\nValue is now: " + value);
                break;
            }
        }
        return value;
    }

    public int[] convertToBiggest(String unit, int value, int solArr[], mass unitArray){
        int unitInt = 0;
        //convert into the biggest possible unit
        for(int a = 0; a < 5; a++) {
            if(unit.equals(unitArray.meters[a].name)){ //check which unit we're using
                for (int j = 4; j >= 0; j--) {
                    if (value % unitArray.meters[j].factor == 0) { //check for biggest number that %=0
                        value /= unitArray.meters[j].factor; //make value as small as possible
                        unitInt = j; //save array position for output
                        System.out.println("Saving numbers [" + value +  "] [" + unitInt+ "]...");
                        break;
                    }
                }
            }
            if(unit.equals(unitArray.liquids[a].name)){
                for (int j = 4; j >= 0; j--) { //check which unit we're using
                    if (value % unitArray.liquids[j].factor == 0) { //check for biggest number that %=0
                        value /= unitArray.liquids[j].factor; //make value as small as possible
                        unitInt = j; //save array position for output
                        System.out.println("Saving numbers [" + value +  "] [" + unitInt+ "]...");
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
