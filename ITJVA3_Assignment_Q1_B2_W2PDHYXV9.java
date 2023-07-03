import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ITJVA3_Assignment_Q1_B2_W2PDHYXV9 {
        private HashMap <String, Integer> ingredientSupply = new HashMap<>();
        private HashMap <String, Set<String>> itemIngredients = new HashMap<>();

        //This constructor will initialize the ingredientSupply and itemIngredients maps.
        public ITJVA3_Assignment_Q1_B2_W2PDHYXV9(){
            ingredientSupply = new HashMap<>();
            itemIngredients = new HashMap<>();
        }
    
        //This method will add new items to the "itemIngredients" map with the necessary ingredients
    public void menuItemAdd(String itemName, Map<String, Integer> ingredients) {
        // Add the menu item to the menuItems map
        // Store the set of ingredients required for the menu item
        itemIngredients.put(itemName, new HashSet<>(ingredients.keySet()));
        // Update the ingredient quantities based on the ingredients required for the menu item
        updateIngredientQuantities(ingredients);
    }

    // Update the quantity of a specific ingredient in the ingredientQuantities map
    public void quantityUpdate(String ingredientName, int quantity) {
        ingredientSupply.put(ingredientName, quantity);
    }

    //This method will display all the menu items alongside the ingredients they need and the quantity for each ingredient
        public void displayMenuItems() {
            System.out.println("Menu Items:");
            for (String itemName : itemIngredients.keySet()) {
                System.out.println("- " + itemName);
                Set<String> ingredients = itemIngredients.get(itemName);
                for (String ingredient : ingredients) {
                    int quantity = ingredientSupply.getOrDefault(ingredient, 0);
                    System.out.println("    " + ingredient + ": " + quantity);
                }
            }
        }

    // Display all the ingredients and their quantities stored in the ingredientQuantities map
    public void displayIngredients() {
        System.out.println("Ingredients:");
        for (String ingredientName : ingredientSupply.keySet()) {
            System.out.println("- " + ingredientName + ": " + ingredientSupply.get(ingredientName));
        }
    }
    // This method will display the menu items that require a specific ingredient along with the quantity of that ingredient required
    public void menuItemswithIngredientDisplay(String ingredientName) {
        System.out.println("Menu Items with " + ingredientName + ":");
        for (String itemName : itemIngredients.keySet()) {
            Set<String> ingredients = itemIngredients.get(itemName);
            if (ingredients.contains(ingredientName)) {
                System.out.println("- " + itemName + " (" + ingredientName + ": " + ingredientSupply.get(ingredientName) + ")");
            }
        }
    }
        // This method will update the ingredient quantities based on the ingredients required for a menu item
        private void updateIngredientQuantities(Map<String, Integer> ingredients) {
        for (String ingredient : ingredients.keySet()) {
            int quantity = ingredients.get(ingredient);
            // Add the quantity to the existing quantity of the ingredient
            ingredientSupply.put(ingredient, ingredientSupply.getOrDefault(ingredient, 0) + quantity);
        }
    }

    public static void main(String[] args){
        ITJVA3_Assignment_Q1_B2_W2PDHYXV9 progManager = new ITJVA3_Assignment_Q1_B2_W2PDHYXV9();

        int progRepeat = 0;
        int userOption = 0;
        //Calling the scanner class to receive user input
        Scanner prompt = new Scanner(System.in);
        


        //This do while statement will run the menu switch case statement until the user enters the -1 value to exit the program
        do{
        System.out.println("Please Select an option below: \n1. Add new Menu Items \n2. Update Ingredient quantities \n3. View all Menu Items \n4. View all Ingredients and Quantities \n5. View all menu items that require a specific ingredient \nOR TYPE -1 TO EXIT");
        userOption = prompt.nextInt();
        prompt.nextLine();

        switch(userOption){
            //When the user select -1, immediately break
            case -1:
                break;
            /*When the user selects the first option they will be prompted to enter the item information */
            case 1:
            progRepeat =0;
            do{
            System.out.println("Enter the item Name:");
            String itemName  = prompt.nextLine();

            System.out.println("How many ingredients does the item have: ");
            int numIngredients  = prompt.nextInt();
            prompt.nextLine();

            //Initializing a new hashmap that will use a string as the key and an integer as the value
            Map<String, Integer> ingredients = new HashMap<>();

            //running a for loop to store the ingredients and quantity of an ingredient in the hashmap
            for (int index=0; numIngredients > index; index++){
                System.out.println("Enter the name of ingredient "+ (index+1) + ": ");
                String ingredientName = prompt.nextLine();

                System.out.println("How much of "+ (ingredientName) +" is needed:");
                int quantity = prompt.nextInt();
                prompt.nextLine();
            //Storing the ingredient values in the ingredients hashmap
                ingredients.put(ingredientName, quantity);

            }
            //Adding the item name with the ingredients hashmap to the bigger itemIngredients hashmap
            progManager.menuItemAdd(itemName, ingredients);

            //Asking the user if they want to add another item
            System.out.println("Item successfully added.\n Would you like to add another?\n 1. Add another item\n 2.Exit");
            int opt = prompt.nextInt();
            prompt.nextLine();

            if(opt==1){
                progRepeat=0;
            }
            else if(opt==2){
                progRepeat=-1;
            }

        }while(progRepeat==0);
            break;


        case 2:
                progRepeat =0;
                do{
                //Prompting the user to name the ingredient they would like to make changes to and the changes they would like to make
                System.out.println("Please name the ingredient you would like to update:");
                String ingredientName = prompt.nextLine();
                System.out.println("What is the updated quantity for " + ingredientName + ": ");
                int quantity = prompt.nextInt();
                prompt.nextLine();
                /*If the itemIngredients hashmap contains a key that matches with the user input variable, then call
                on the quantityUpdate() method */
                if (progManager.itemIngredients.containsKey(ingredientName)){
                    progManager.quantityUpdate(ingredientName, quantity);
                    System.out.println("Item Quantity successfully updated");

                    //Asking the user if they would like to update another item
                    System.out.println("Would you like to update another item quantity?\n 1. Yes\n2. Exit");
                    int opt = prompt.nextInt();
                    prompt.nextLine();
                    if(opt==1){
                        progRepeat=0;
                    }else if(opt==2){
                    progRepeat=-1;                    
                }
                }
                //Else display an error message on the user's screen
                else{
                    System.out.println("Unable to find ingredient,Would you like to: \n1. Try again\n2. Exit");
                    int opt = prompt.nextInt();
                    prompt.nextLine();
                    if(opt==1){
                        progRepeat=0;
                    }else if(opt==2){
                    progRepeat=-1;                    
                }

                }
            }while(progRepeat==0);
            break;

            //Calling the displayMenuItems() method when the user selects option 3
            case 3:
            progManager.displayMenuItems();
            System.out.println("Would you like to: \n1. Return to Menu\n2. Exit Program");
                    int opt = prompt.nextInt();
                    prompt.nextLine();
                    if(opt==1){
                        continue;
                    }else if(opt==2){
                        userOption= -1;
                    }
                    break;

            //Calling the displayIngredients() method when the user select option 4
            case 4:
                    progManager.displayIngredients();
                    System.out.println("Would you like to: \n1. Return to Menu\n2. Exit Program");
                    opt = prompt.nextInt();
                    prompt.nextLine();
                    if(opt==1){
                        continue;
                    }else if(opt==2){
                        userOption= -1;
                    }
                    break;

            case 5: 
                        progRepeat =0;
                    do{
                    //Prompting the user to enter the ingredient they want to find the associated menu items for
                    System.out.println("Which ingredient would you like to find menu items for?: ");
                    String ingredientName = prompt.nextLine();
                    //if the itemIngredients hashmap has a key that matches with the ingredientName user input, then execute
                    if(progManager.itemIngredients.containsKey(ingredientName)){
                        //Calling the menuItemsWithIngredientDisplay method to display the results to the user
                        progManager.menuItemswithIngredientDisplay(ingredientName);
                    
                    //Asking the user if they would like to return to the menu or overall end the program
                    System.out.println("Would you like to: \n1. Return to Menu\n2. Exit Program");
                    opt = prompt.nextInt();
                    prompt.nextLine();
                    if(opt==1){
                        continue;
                    }else if(opt==2){
                        userOption= -1;
                    }
                    //Else display an error to the user
                    }else{
                        System.out.println("No item with that ingredient has been found.\n");
                        System.out.println("Would you like to: \n1. Try again\n2. Exit");
                        opt = prompt.nextInt();
                        prompt.nextLine();
                        if(opt==1){
                            progRepeat=0;
                        }else if(opt==2){
                            progRepeat=-1;
                            continue;
                        }
                    }
                    }while(progRepeat==0);
                    break;
            default:
                    System.out.println("Invalid Selection.\n");
                    userOption=-1;
                    break;

                    


    }
}while (userOption != -1);


    }
}
