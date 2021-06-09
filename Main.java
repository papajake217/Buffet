package Buffet;

import java.util.Scanner;

//Buffet.Main class where whole program will be ran
public class Main {
    //version number
    static String version = "0.1";
    static String[] availablePrograms = {"Buffet.Calculator","Buffet.Stack"};

    private static int index = 0;

    public static void main(String[] args){

        System.out.println("Welcome to Buffet!\nVersion: " + version);
        while(true) {
            displayMenu();
            runCommand();

        }
    }

    //Display the beginning text and all available features with corresponding numbers
    public static void displayMenu(){

        System.out.println("The following demos/programs are currently available:");
        System.out.println("0.Exit");
        for (int i=0;i<availablePrograms.length;i++){
            System.out.println(i+1 + "." + availablePrograms[i]);
        }
        //Choice to exit

    }

    public static void runCommand(){
        System.out.println("Enter the integer that corresponds to the choice: ");
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        //check to make sure they pick a valid choice
        while(choice < 0 || choice > availablePrograms.length + 1){
            System.out.println("Invalid choice. Please re-type your choice: ");
            choice = sc.nextInt();
        }
        //subtract one because the choices start at 1
        choice--;


        //option to exit is checked first
        switch(choice){
            case -1: System.exit(0); sc.close(); break;
            case 0: Calculator.run(); break;
            case 1: StackTesting.run(); break;
            default: break;
        }


    }
}
