package Buffet;

import java.util.Scanner;

public class StackTesting {
    public static void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to my Stack program!");

        System.out.println("Enter the size of your stack: ");
        //initializes size of stack to be used in stack object
        int size = sc.nextInt();
        //nextInt() does not account for newline character when enter is hit so a nextLine() is needed to absorb it
        sc.nextLine();

        //creating the users stack with their chosen size
        Stack userStack = new Stack(size);

        //initializes command as default, this can be anything however because it changes in the while loop
        String command = "default";

        //declares an integer to be reused throughout the program for either user input or storing the integer at the top of the stack
        int value;

        //while loop always runs unless the user wants to exit
        while(command.toLowerCase().compareTo("exit") != 0){
            System.out.println("Available commands: Push, Pop, Peek, Exit");
            System.out.println("Enter one of the available commands: ");
            //command being changed to lowercase to simplify the switch cases
            command = sc.nextLine().toLowerCase();

            switch(command){
                case "push":
                    //checks if the stack is not full first before asking for a value
                    if(!(userStack.isFull())) {
                        System.out.println("Enter integer to push: ");
                        value = sc.nextInt();
                        sc.nextLine();
                        userStack.push(value);
                        System.out.println(value + " has been pushed onto the stack");
                    } else{
                        System.out.println("Error cannot push, stack is full");
                    }
                    break;
                case "pop":
                    //checks if the stack is not empty before popping a value because there would be no value to pop.
                    if(!(userStack.isEmpty())) {
                        value = userStack.pop();
                        System.out.println(value + " has been popped from the stack.");
                    } else{
                        System.out.println("Error cannot pop, stack is empty");
                    }
                    break;
                case "peek":
                    //checks if the stack is not empty before peeking because there would be no value to peek.
                    if(!(userStack.isEmpty())) {
                        value = userStack.peek();
                        System.out.println(value + " is currently on the top of the stack.");
                    } else{
                        System.out.println("Error cannot peek, stack is empty");
                    }
                    break;
                case "exit":
                    //exit is a valid command so it needs its own case which is just a break statement.
                    //stops the program from saying it is an invalid command before the program ends.
                    break;
                default:
                    System.out.println("Error, invalid command");
            }
            //This just adds a space between one command and the next so each loop is more distinct and easier to read.
            System.out.println();
        }

    }
}
