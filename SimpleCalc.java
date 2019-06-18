/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

class Calc{
    static int add(int x, int y){
        return x+y;
    }
    static int sub(int x, int y){
        return x-y;
    }
    static int mul(int x, int y){
        return x*y;
    }
    static int div(int x, int y){
        return x-y;
    }
}

class Output{
    public static void main(String[] args){
        System.out.println("Addition is :"+Calc.add(5,5));
        System.out.println("Substraction is :"+Calc.sub(5,5));
        System.out.println("Multiplication is :"+Calc.mul(5,5));
        System.out.println("Division is :"+Calc.div(5,5));
    }
}

