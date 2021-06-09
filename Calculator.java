package Buffet;

import java.util.Scanner;

public class Calculator {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        char sign = 'a';

        System.out.println("Welcome to the calculator!");

        while(sign != 'E' && sign != 'e') {
            System.out.println("Enter your first number: ");
            double first = sc.nextDouble();
            System.out.println("Enter your second number: ");
            double second = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter the operator you would like to use (+,-,*,/,^) or E to exit: ");
            sign = sc.nextLine().charAt(0);
            while (sign != '+' && sign != '-' && sign != '*' && sign != '/' && sign != '^' && sign != 'E' && sign != 'e') {
                System.out.println("Error, invalid sign, please type a valid sign (+,-,*,/,^) or E to exit: ");
                sign = sc.nextLine().charAt(0);

            }
            if(sign != 'E' && sign != 'e') {
                double result = calculate(first, second, sign);
                System.out.println("Answer: " + result);
            }

        }



    }

    // returns the answer to the users problem
    public static double calculate(double first, double second, char sign){
        double answer = 0;
        switch(sign){
            case '+': answer = first + second; break;
            case '-': answer = first - second; break;
            case '*': answer = first * second; break;
            case '/':
                if(second != 0) {
                    answer = first / second;
                    break;
                } else{
                    System.out.println("Error, cannot divide by 0");
                    break;
                }
            case '^': answer = Math.pow(first,second); break;
            default: break;
        }


        return answer;
    }
}
