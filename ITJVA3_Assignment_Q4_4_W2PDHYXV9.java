import java.util.Random;
import java.util.Scanner;

public class ITJVA3_Assignment_Q4_4_W2PDHYXV9 {

        
        public static void main(String[] args) {
        //New Scanner method to get user input
            Scanner input = new Scanner(System.in);
    
        //New random number generator method with a maximum value of 100
            Random randNum = new Random(); 
    
            int max = 100;
            int randomNum= randNum.nextInt(max);
            int userGuess;
            int attempts = 0;

    
        //Prompting user to input a number between 0 and 100
            System.out.println("Guess a number between 1-100: \n");

            userGuess = input.nextInt();
            


            //Evaluating user guess and giving clue according to whether the number guessed was too high or low
            while ((userGuess != randomNum) && (attempts != 2)){

                //Incrementing the user's attempts
                attempts++;


                System.out.println("Incorrect Guess \n");
                if (userGuess > randomNum){
                    System.out.println("Too high, try again:\n");
                    userGuess = input.nextInt();

                }
                else{
                    System.out.println("Too low, try again:\n");
                    userGuess = input.nextInt();
    
                }
               
            }
            //Congratulating the user on their success
            if (userGuess == randomNum){
                    System.out.println("Congratulations, you guessed the number! ");
            }
            if (attempts == 2){
                    System.out.println("Failed: The correct number is " + randomNum);
            }
    
    }
    }

