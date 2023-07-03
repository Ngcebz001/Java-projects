import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//Creating a class for all patients
class Patients{
    private String name;
    private int age;
    private int priority;

    //Creating constructor for Patients class
    public Patients(String name, int age, int priority){
        this.name = name;
        this.age = age;
        this.priority = priority;        
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getPriority(){
        return priority;
    }

    //Returning patient details
    @Override
    public String toString(){
        return ("Patient{\n Name: "+ name + "\n Age: "+ age +"\n Priority: " +priority+ "\n}");
    }
}


public class ITJVA3_Assignment_Q3_B2_W2PDHYXV9 {
    //Initializing queue values, we will be using one standard queue and one priority queue, both will be loaded with the 
    //same data, one will just allow us to allocate priority to the values
    private Queue<Patients> prQueue;
    private PriorityQueue<Patients> prPriorityQueue;

    //Defining a constructor for the queues 
    public ITJVA3_Assignment_Q3_B2_W2PDHYXV9() {
        prQueue = new LinkedList<>();
        prPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(Patients::getPriority));
    }

    //Method to add patient to both queues, it will accept the patient's name, age and priority status.
    public void addPatient(String name, int age, int priority){
        Patients patient = new Patients(name, age, priority);
        prQueue.offer(patient);
        prPriorityQueue.offer(patient);
        System.out.println(name +"has been added to the system.");
    }

    //Method to remove patient data from both queues
    public void removePatient(String name){
        boolean queueRemove = prQueue.removeIf(patient -> patient.getName().equals(name));
        boolean queuePriorityRemove = prPriorityQueue.removeIf(patient -> patient.getName().equals(name));

        if (queueRemove && queuePriorityRemove) {
            System.out.println(name + " has been removed from the system");
        } else {
            System.out.println(name + " has not been found in the system");
        }
    }

    /*This method allows us to search for a patient in the system using their name. A for loop will be used to
    iterate through every name to see if the input value matches with any of the names in the standard queue*/ 
    public void searchPatient(String name){
        for(Patients patient : prQueue){
            if(patient.getName().equals(name)){
                System.out.println("Patient exists in System:" + patient);
                return;
            }
        }
        System.out.println("Patient " + name + "has not been found in the system.");
    }

    //This method calls on the set Priority queue to sort patients by their priority status
    public void sortByPriority(){
        System.out.println("List of patients by Priority:\n");

        for (Patients patient : prPriorityQueue){
            System.out.println(patient + "\n");
        }

    }

    /*This method creates a new sorted list in which the queue name values are stored and sorted in ascending order
    it calls on the getName() method to store the name data in the list*/
    public void sortByName(){
        List<Patients> sortedList = new ArrayList<>(prQueue);
        sortedList.sort(Comparator.comparing(Patients::getName));
        System.out.println("List of patients by Name:\n");
        for (Patients patient : sortedList) {
            System.out.println(patient);
        }
    }

    /*This method sorts the patients by their age, it creates a sorted list that calls on the getAge() method in the 
     * in the patient class, then it stores the returned age value in the list to get sorted in ascending order.
     */
    public void sortByAge(){
        List<Patients> sortedList = new ArrayList<>(prQueue);
        sortedList.sort(Comparator.comparingInt(Patients::getAge));
        System.out.println("List of Patients by Age:\n");
        for (Patients patient : sortedList) {
            System.out.println(patient);
        }
    }

    // Main Program Begins here
        public static void main(String[] args) {
            ITJVA3_Assignment_Q3_B2_W2PDHYXV9 progManager = new ITJVA3_Assignment_Q3_B2_W2PDHYXV9();

            //Calling the scanner class to allow for user input on the system
            Scanner prompt = new Scanner(System.in);
            int userPrompt = 0;

                        System.out.println("Welcome to the Patient System");
            /*This loop will run the menu, it will run while the userPrompt value is not equal to one, above we initialized 
            the userPrompt variable to 0*/
            do{
                //Allowing user to select a menu option
                System.out.println("Select an Option:\n 1. Add new Patient\n 2. Remove a Patient\n3. Search for a patient\n 4. Display Patients by Priority\n5. Display Patients by Name\n 6. Display Patients by Age\n ");
                userPrompt = prompt.nextInt();
                prompt.nextLine();
                //Switch case statement that will run the menu logic
                switch(userPrompt){

                    //If the user enters 1, they will be redirected to the AddPatient prompts.
                    case 1:
                        int addPatientMenu =0;
                        do{
                            //Declaring patient variable
                            String name;
                            int age;
                            int priority;
                            int addPrompt =0;

                            //Prompting user to enter patient details
                            System.out.println("What is the Patient's Name: ");
                            name = prompt.nextLine();
                            System.out.println("What is the Patient's Age: ");
                            age = prompt.nextInt();
                            prompt.nextLine();
                            System.out.println("What is the Patient's Priority: ");
                            priority = prompt.nextInt();
                            prompt.nextLine();

                            //Calling the System's class to allow us to access the add patient method and storing the user input data
                            progManager.addPatient(name, age, priority);

                            //Confirming user data storage and asking the user what they would like to do next
                            System.out.println("Patient Added!\n Would you like to add another?\n 1. Yes\n 2. Exit");
                            addPrompt = prompt.nextInt();
                            prompt.nextLine();
                            if(addPrompt==1){
                                addPatientMenu = 0;
                            }else if(addPrompt ==2){
                                addPatientMenu = -1;                           
                            }


                        }while(addPatientMenu!=-1);
                        break;

                    //If the user selects 2, they will be prompted to enter the name of the patient they would like to remove
                    case 2: 
                    int removePatientMenu = 0;
                    do{
                        //Prompting user to input the patient's name
                        int removePrompt =0;
                        System.out.println("Which Patient would you like to remove?:");
                        String name = prompt.nextLine();
                        //Calling the removePatient() method from the system's class
                        progManager.removePatient(name);

                        //Asking the user if they would like to remove another patient or exit
                        System.out.println("Would you like to remove another: \n1. Yes\n2. Exit");
                        removePrompt = prompt.nextInt();
                        prompt.nextLine();
                        if (removePrompt == 1){
                            removePatientMenu=0;
                        }else if(removePrompt==2){
                            removePatientMenu=-1;
                        }

                    }while (removePatientMenu != -1);
                    break;

                    //If the user selects 3, they will be asked to enter the name of the patient they are searching for
                    case 3:
                        int searchMenu = 0;
                        do{
                            //Declaring needed variables
                            String name;
                            int searchPrompt;

                            //Prompting user to enter the patient's name
                            System.out.println("Patient Name: ");
                            name = prompt.nextLine();
                            //Running the searchPatient() with the name variable being passed through
                            progManager.searchPatient(name);

                            //Asking the user if they would like to search again
                            System.out.println("Would you like to Search for another: \n1. Yes\n2. Exit");
                            searchPrompt = prompt.nextInt();
                            prompt.nextLine();
                            if (searchPrompt == 1){
                                searchMenu=0;
                            }else if(searchPrompt==2){
                                searchMenu=-1;
                            }   

                        }while(searchMenu!= -1);
                        break;

                        //If the user selects 4, they will get all stored user data sorted by priority
                        case 4:
                            //Running the sortByPriority() method 
                            progManager.sortByPriority();
                            break;
                        //If the user selects 5, they will get all stored user data sorted by their names
                        case 5:
                            //Running the sortByName() method                         
                            progManager.sortByName();
                            break;
                            //If the user selects 6, they will get all stored user data sorted by their ages
                        case 6:
                            //Running the sortByAge() method 
                            progManager.sortByAge();
                            break;
                        default:
                        System.out.println("Invalid Selection.\n");
                        userPrompt=-1;
                        break;

                }


            }while(userPrompt != -1);
        }

}