import java.util.Scanner;

public class ITJVA3_Assignment_Q2_W2PDHYXV9 {
    public static void main(String[] args) {

        //Using the scanner class to get user input
        Scanner input = new Scanner(System.in);
        //Declaring a variable for user input
        String userReply;

        //Variable that will increment its value by 1 when the user is correct
        int numCorrect = 0;

        //Declaring the 2 dimensional array where all the city values are stored
        String[][] cities = new String[9][2];


    /*Storing data in the array */
        cities[0][0] ="Gauteng";
        cities[0][1] = "johannesburg";

        cities[1][0] ="Western Cape";
        cities[1][1] = "cape town";

        cities[2][0] ="Limpopo";
        cities[2][1] = "polokwane";

        cities[3][0] ="Eastern Cape";
        cities[3][1] = "queenstown";

        cities[4][0] ="Kwazulu-Natal";
        cities[4][1] = "durban";

        cities[5][0] ="-Mpumalanga";
        cities[5][1] = "mbombela";

        cities[6][0] ="North West";
        cities[6][1] = "potchefstroom";

        cities[7][0] ="Free State";
        cities[7][1] = "bloemfontein";

        cities[8][0] ="Northern Cape";
        cities[8][1] = "springbok";



        //This for loop will run through each province and prompt the answer to answer on the name of a city associated with the province
        for (int qNum = 0; qNum < 9; qNum++){
            System.out.println("Name a city in " + cities[qNum][0]);

            //Prompting the user to answer
            userReply = input.nextLine();
    
            //Changing the user's input to all lowercase
            userReply = userReply.toLowerCase();

            System.out.println("\n");

            //If statement to check whether the user answered correctly
            if (userReply.equals(cities[qNum][1])){

                //If the user answers correctly, the program will display a message and increment the numCorrect variable by 1
                System.out.println("Your answer is correct\n");
                numCorrect++;
            }

            //If the user answers correctly, the program will tell them they are wrong and display the correct answer
            else{ 

                //below the program is separating the first character of a city name, so it can capitalise it and add it back to the original string
                String correctAns = cities[qNum][1];
                String firstChar = correctAns.substring(0,1);
                String remainingText = correctAns.substring(1);
                String newCity = firstChar.toUpperCase() + remainingText;
                
                System.out.println("Incorrect: The Correct answer is " + newCity);

            }
        }

        //Display how many questions the user got correct using the numCorrect variable.
        System.out.println("You answered " + numCorrect + " questions correctly.");

    }
}
