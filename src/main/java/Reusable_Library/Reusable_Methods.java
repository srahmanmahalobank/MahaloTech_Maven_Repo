package Reusable_Library;

public class Reusable_Methods {


    //create a void method that will add two numbers
    public static void add (int x, int y){

        System.out.println("Result of addition is " + (x+y));

    }// end of add method

    // create a void method that will subtract two number
    public static void subtract(int x, int y){
        System.out.println("Result of subtraction is " + (x-y));
    } // end of subtract method

    //create a return method that will add two numbers and return the result of it

    public static int addReturn(int x, int y){

        //declare and define a new integer variable to story x+y
        int result = x+y;
        System.out.println("Result of addition is " + result);

        //returning the variable result which is storing X+Y values
        return result;


    }// end of addReturn method


}
