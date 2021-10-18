public class Main {
    public static void main(String[] args){
        rect first_obj = new rect(); //generate new object
        first_obj.l = 2; //give values
        first_obj.w = 3;

        int area = first_obj.area(first_obj.l, first_obj.w); //calc area
        int scope = first_obj.scope(first_obj.l, first_obj.w); //calc scope

        System.out.println("Area: " + area + "\n" + "Scope: " + scope);
    }
}