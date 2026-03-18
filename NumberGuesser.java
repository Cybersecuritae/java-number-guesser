import java.util.InputMismatchException; //Handles bad input(like character instead of numbers)
import java.util.Random; //Generates the secret number
import java.util.Scanner; // Reads user inputs from keyboard

public class NumberGuesser { //Method that runs the entire Random Number Guessing Game process

    public void play() { 
        // Scanner for user inputs and random number setup
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random(); 

        boolean playAgain = true; // If true, a new round starts
        
        // Main loop, everytime a player passes through this loop its one full game, will keep going until player says "no"
        while (playAgain) { 
            int secretNumber = random.nextInt(100) + 1; 
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and 100. Try to guess it!");

            //Guessing loop, runs until correct number is guessd
            while (!guessedCorrectly) {
                boolean validInput = false;
                int guess = 0;

                //Safety check, makes sure players input from the keyboard are correct, catches mistakes
                while (!validInput) {
                    try {
                        System.out.print("Enter your guess: ");
                        guess = scanner.nextInt();

                      
                        if (guess < 1 || guess > 100) {
                            System.out.println("Out of range. Please enter a number between 1 and 100.");
                        } else {
                            validInput = true; 
                            attempts++;

                        }

                    } catch (InputMismatchException ex) {
                        System.out.println("Not a valid number. Please enter a number between 1 and 100.");
                        scanner.nextLine(); 
                    }
                }
                

                //Gives feedback to player
                if (guess < secretNumber) {
                    System.out.println("That's incorrect. The guess was too low, please try again!");
                } else if (guess > secretNumber) {
                    System.out.println("That's incorrect. The guess was too high, please try again!");
                } else {
                    System.out.println("That's correct! You got the number in " + attempts + " tries!");
                    guessedCorrectly = true;
                }
            }

            //Ask player if they want to play again
            boolean validResponse = false;
            String response = "";

            while (!validResponse) {
                System.out.print("Would you like to play again? (yes/no): ");
                response = scanner.next().toLowerCase();

                if (response.equals("yes") || response.equals("no")) {
                    validResponse = true;
                } else {
                    System.out.println("Please enter 'yes' or 'no'.");
                }
            }

            playAgain = response.equals("yes");
            
        }

        System.out.println("Thanks for playing!");
    }
}
