import java.util.Scanner;

public class ITJVA3_Assignment_Q4_3_W2PDHYXV9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your age: ");
        int age = input.nextInt();

        if (age < 18){
            System.out.println("You are not old enough to vote.");
        }
        else if ((age > 17) && (age < 66)){
            System.out.println("You are eligible to vote.");
        }
        else if (age > 65){
            System.out.println("You are eligible to vote by mail.");
        }
    }

}
