package Buffet;


import java.util.Scanner;

public class PokemonBattle {

    //name,hp,type,move1name,move1Type,move1Dmg, ~ same for 4 moves
    //can add any pokemon as long as its the right format, should just work when added to the available pokemon list
     Pokemon Charizard = new Pokemon("Charizard",300,"Fire","Flamethrower","Fire",100,"Ember","Fire",50,"Cut","Normal",30,"Fly","Flying",80);
     Pokemon Blastoise = new Pokemon("Blastoise",300,"Water","Hydro Pump","Water",100,"Water Gun","Water",50,"Shell Smack","Normal",30,"Bite","Dark",80);
     Pokemon Venusaur = new Pokemon("Venusaur",300,"Grass","Solar Beam","Grass",100,"Razor Leaf","Grass",50,"Stomp","Normal",30,"Bulldoze","Ground",80);
     Pokemon[] availablePokemon = {Charizard,Blastoise,Venusaur};
     Pokemon userPokemon;
     Pokemon enemyPokemon;
     boolean playerWins = false;

     //main game loop
    public void run(){
        int choice = startScreen();

        userPokemon = availablePokemon[choice];
        enemyPokemon = availablePokemon[choice];
        userPokemon.hp = userPokemon.maxHp;
        enemyPokemon.hp = enemyPokemon.maxHp;
        while(enemyPokemon.name.compareTo(userPokemon.name) == 0) {
            int enemyChoice = (int) (Math.random() * availablePokemon.length);
            enemyPokemon = availablePokemon[enemyChoice];
        }

        while(userPokemon.hp > 0 && enemyPokemon.hp > 0){
            displayStatus();
            playerMove();
            enemyMove();
        }
        endScreen();
    }

    //welcome screen that asks to choose pokemon
    public int startScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to a Pokemon Battle Simulator! Please choose a Pokemon: ");
        for (int i=0;i<availablePokemon.length;i++){
            System.out.println(i+1 + "." + availablePokemon[i].name);
        }
        int choice = sc.nextInt();
        sc.nextLine();
        while(choice < 1 || choice > availablePokemon.length){
            System.out.println("Please pick a valid choice.");
            choice = sc.nextInt();
            sc.nextLine();
        }
        choice--;
        return choice;
    }

    //Lets player choose a move and then performs it using the pokemon class's attack method
    public void playerMove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose a move: ");

        for(int i=0;i<userPokemon.moves.length;i++){
            System.out.println(i+1 + "." + userPokemon.moves[i].name);
        }
        int moveChoice = sc.nextInt();
        sc.nextLine();
        while(moveChoice < 1 || moveChoice > 4){
            System.out.println("Please pick a valid choice.");
            moveChoice = sc.nextInt();
            sc.nextLine();
        }
        userPokemon.attack(userPokemon.moves[moveChoice-1],enemyPokemon);
        if(enemyPokemon.hp <= 0){
            playerWins = true;
        }
        System.out.println(userPokemon.name + " used " + userPokemon.moves[moveChoice-1].name);
    }

    //enemy attacks by generating a random number and using that move
    public void enemyMove(){
        int choice = (int) (Math.random() * 4);
        enemyPokemon.attack(enemyPokemon.moves[choice],userPokemon);
        System.out.println(enemyPokemon.name + " used " + enemyPokemon.moves[choice].name);
    }

    //displays hp's of user and enemy's pokemon
    public void displayStatus(){
        System.out.println(userPokemon.name + ": " + userPokemon.hp + " HP");
        System.out.println(enemyPokemon.name + ": " + enemyPokemon.hp + " HP");
    }

    //Final screen that depends on if the user wins or the enemy does
    public void endScreen(){
        Scanner sc = new Scanner(System.in);

        if(playerWins){
            System.out.println("Congratulations! You have defeated the enemy's " + enemyPokemon.name + "!");
        } else{
            System.out.println("You have been defeated by the enemy's " + enemyPokemon.name + ". Better luck next time.");
        }
        System.out.println("Press enter to go back to the main menu.");
        sc.nextLine();
    }
}
