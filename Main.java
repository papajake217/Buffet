package Buffet;

import java.util.Scanner;

//Main class where whole program will be ran
public class Main {
    //version number
    static String version = "0.3";
    //Add new programs into this list and it will automatically be added, also need to add it to the switch case at the bottom
    static String[] availablePrograms = {"Calculator","Stack","Number Guessing Game","Pokemon Battle"};


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

        //exception to static methods because hp wasn't being reset
        PokemonBattle pokemon = new PokemonBattle();

        //add the new program being added here, in a new case with the next number. I change all programs main methods to just be called run, hence the uniform naming convention
        switch(choice){
            case -1: System.exit(0); sc.close(); break;
            case 0: Calculator.run(); break;
            case 1: StackTesting.run(); break;
            case 2: GuessingGame.run(); break;
            case 3: pokemon.run(); break;
            default: break;
        }


    }
}
