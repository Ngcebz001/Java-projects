import java.io.IOException;
import java.io.RandomAccessFile;

public class ITJVA3_Assignment_Q3_2_W2PDHYXV9 {
    public static void main(String[] args) {

        //The name of the file that the program will read from
        String fileName = "C:/PrimeNum.dat";
            try{
                //Calling the RandomAccessFile class to allow us to read from the file
                RandomAccessFile myFile = new RandomAccessFile(fileName, "r");

                //Getting the length of the file in bytes
                long fileLength = myFile.length();

                //Each integer takes up 4 bytes, by subtracting 4*100, our positon will start from the last 100 integer.
                long placement = fileLength - 4 * 100;

                //Using seek method from RandomAccessFile to position the file pointer
                myFile.seek(placement);

                //Declaring the new array to store all the values
                int[] finalNums = new int[100];

                //For loop running through the file and storing each read value in the array
                for (int index = 0; index < 100; index++){
                    finalNums[index] = myFile.readInt();
                }

                //Closing the file
                myFile.close();

                //Displaying the numbers on the user's screen
                System.out.println("The 100 prime numbers are: ");

                for (int index = 0; index < 100; index++){
                    System.out.println(finalNums[index] + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

    }
}
