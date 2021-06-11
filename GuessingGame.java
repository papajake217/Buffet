package Buffet;

import java.util.Scanner;

import static java.lang.System.exit;

public class GuessingGame {
    public static void run(){
        boolean isGuessed = false;
        int answer = generateNum();
        int guess;
        int guessCount = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the number guessing game! You will guess a number from 1 to 100 and I will tell you if you must go higher or lower.");
        while (!(isGuessed)){
            System.out.println("Enter a guess: ");
            guess = sc.nextInt();
            sc.nextLine();
            guessCount++;
            if(guess > answer){
                System.out.println("Lower");
            } else if(guess < answer){
                System.out.println("Higher");
            } else if (guess == answer){
                isGuessed = true;
            }
        }
        System.out.println("Success! The number was " + answer + ".");
        System.out.println("It took you " + guessCount + " guesses.");
        System.out.println("Play Again? (Y/N)");
        String input = sc.nextLine();
        while(input.compareToIgnoreCase("Y") != 0 && input.compareToIgnoreCase("N") != 0){
            System.out.println("Please type a valid answer (Y/N): ");
            input = sc.nextLine();
        }
        if(input.compareToIgnoreCase("Y") == 0){
            run();
        }
    }

    public static int generateNum(){
        return (int) ((Math.random() * 100) + 1);
    }
}
