import java.util.Scanner;

//Creating a class call Book
class Book {
    //Declaring variables needed in the class
    String title;
    String author;
    int isbn;

        //Declaring the constructor for the Book class
        public Book(String title, String author, int isbn){
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
}
//Class for the different nodes in the Binary Search Tree
class Node{
    Book book;
    Node left;
    Node right;

        public Node(Book book){
            this.book = book;
            this.left = null;
            this.right = null;
        }
}

//Creating a class for the library system
class LibrarySystem{
    private Node root;

    //Calling the recursive method to add a book
    public void addBook(Book book){
        root = recursiveBookAdd(root, book);
    }
    //This method will create a new node if the current node is null
    private Node recursiveBookAdd(Node current, Book book){
        if (current == null){
            return new Node(book);
        }
        //it will also go through the whole tree to find the position that the new book should go into
        if (book.isbn < current.book.isbn){
            current.left = recursiveBookAdd(current.left, book);
        }else if(book.isbn > current.book.isbn){
            current.right = recursiveBookAdd(current.right, book);
        }
        return current;
    }

    //Calling the recursive method to search for a book
    public Book searchBook(int isbn){
        return searchBookRecursive(root, isbn);
    }
    //This method will return the current node if the ISBN matches OR if the current node is null
    private Book searchBookRecursive(Node current, int isbn){
        if((current==null) || (current.book.isbn==isbn)){
            return current != null ? current.book : null;
        }
        //Recursively search left or right on the subtree according to the ISBN value
        if (isbn < current.book.isbn){
            return searchBookRecursive(current.left, isbn);
        }
        return searchBookRecursive(current.right, isbn);
    }

    //Calling the recursive method to remove a book
    public void removeBook(int isbn){
        root = removeBookRecursive(root,isbn);
    }
    private Node removeBookRecursive(Node current, int isbn){
        //return Null if the current node is null
        if (current == null){
            return null;
        }

        //Recursively search through the whole tree to find the book that needs to be removed
        if(isbn < current.book.isbn){
            current.left = removeBookRecursive(current.left, isbn);
        }else if(isbn > current.book.isbn) {
            current.right = removeBookRecursive(current.right, isbn);
        }else{
            //IF the book has been found
            if ((current.left == null) && (current.right ==null)){
                //The node has no children
                return null;
            } else if (current.left == null){
                //The node has a right child
                return current.right;
            }else if(current.right == null){
                //THe node has a left child
                return current.left;
            }

            //Find the smallest value in the right subtree
            Node smallestNode = findSmallestNode(current.right);
            //Replace the current node with the smallest node
            current.book = smallestNode.book;
            //Remove the smallest value node from the right subtree
            current.right = removeBookRecursive(current.right, smallestNode.book.isbn);
        }
        return current;
    }

    //Method to find the smallest node
    private Node findSmallestNode(Node node){
        if(node.left ==null){
            return node;
        }
        return findSmallestNode(node.left);
    }

}
public class ITJVA3_Assignment_Q4_B2_W2PDHYXV9 {
    //The main program starts here
    public static void main(String[] args) {
        //Calling the scanner class for input and LibrarySystem class to access data and methods
        Scanner prompt = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();

        int userOption = 0;

        System.out.println("Welcome to the Library Management System");
        //Allowing user to select a menu option
        do {
            System.out.println("Please select a menu option:\n1. Add a Book\n2. Search for a Book\n3. Remove a book\n4. Exit");
            userOption= prompt.nextInt();
            prompt.nextLine();

            switch(userOption){

                /*If the user selects one, they will be prompted to enter the book's infromation, that will then 
                be stored as a Book class type after which the addBook() method will be called to store the data */
                case 1:
                int progRepeat = 0;
                do{
                    System.out.println("What is the Name of the book: ");
                    String title = prompt.nextLine();

                    System.out.println("Who is the Author of the book: ");
                    String author = prompt.nextLine();

                    System.out.println("What is the isbn Number for the book: ");
                    int isbn = prompt.nextInt();
                    prompt.nextLine();

                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    System.out.println("Book Successfully Added.\n");

                    //Asking the user if they would like to add another book
                    System.out.println("Would you like to add another book?\n1. Yes\n2. Exit to menu");
                    int opt = prompt.nextInt();
                    prompt.nextLine();
                    if (opt == 1){
                        continue;
                    }else if(opt == 2){
                        progRepeat = -1;
                    }
                }while(progRepeat != -1);
                break;

                /* IF the user selects 2, they will be prompted to enter the ISBN value of the book they are searching
                 * for, thereafter the searchBook() method will be called to find the book details.
                 * IF the book exists, the book info will be printed out, otherwise the user will get a "Book Not Found" message
                 */
                case 2:
                progRepeat = 0;
                do{
                System.out.println("Please enter Book ISBN: ");
                int isbn = prompt.nextInt();
                prompt.nextLine();

                Book searchResult = library.searchBook(isbn);
                if (searchResult != null){
                    System.out.println("Book Found!");

                    System.out.println("Title: " + searchResult.title + "\n");
                    System.out.println("Author: " + searchResult.author + "\n");
                    System.out.println("ISBN: " + searchResult.isbn + "\n");

                }else{
                    System.out.println("Book Not Found");
                }
                    System.out.println("Would you like to search for another book?\n1. Yes\n2. Exit to menu");
                    int opt = prompt.nextInt();
                    prompt.nextLine();
                    if (opt == 1){
                        continue;
                    }else if(opt == 2){
                        progRepeat = -1;
                    }                
            }while(progRepeat != -1);
            break;

            /*IF the user selects option 3, they will be prompted to give the ISBN of the book they want to remove, thereafter
             * the removeBook() will be called, the user will then be asked if they want to delete another book
             */
            case 3:
            progRepeat = 0;
            do{
                System.out.println("Enter Book ISBN to delete:");
                int isbn = prompt.nextInt();
                prompt.nextLine();

                library.removeBook(isbn);
                System.out.println("Book Successfully Removed");

                    System.out.println("Would you like to remove another book?\n1. Yes\n2. Exit to menu");
                    int opt = prompt.nextInt();
                    prompt.nextLine();
                    if (opt == 1){
                        continue;
                    }else if(opt == 2){
                        progRepeat = -1;
                    }                
            }while(progRepeat != -1);
            break;
            //Default statement if the user selects another options outside of the ones available
            default:
                    System.out.println("Invalid Selection.\n");
                    userOption=-1;
                    break;
        }

        }while(userOption != -1);
    }
}
