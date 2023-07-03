import java.util.Date;

public class ITJVA3_Assignment_Q1_W2PDHYXV9 {

    public static void main(String[] args) {


    }
    
    //Person Superclass
    public class Person{
        private String name;
        private String address;
        private String number;
        private String email;

        //Class constructor
        public Person(String name, String address, String number, String email) {
            this.name = name;
            this.address = address;
            this.number = number;
            this.email = email;
        }
        //Getter methods
        public String getName() {
            return name;
        }
    
        public String getAddress() {
            return address;
        }
    
        public String getPhoneNumber() {
            return number;
        }
    
        public String getEmail() {
            return email;
        }
    
        @Override
        public String toString() {
            return getClass().getSimpleName() + ": " + getName();
        }
    }
//Student Subclass
    public class Student extends Person{

        //Declaring the different student statuses as constants
        public static final int YFIRST = 1;
        public static final int YSECOND = 2;
        public static final int YTHIRD = 3;

        //Declaring the student variable
        private int status;
    
        // Constructor to intialize the values
        public Student(String name, String address, String number, String email, int status) {
            super(name, address, number, email);
            this.status = status;
        }
    // Getter method for the class status
    public int getStatus() {
        return status;
    }

    // Override the toString method to display the class name and the person's name
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getName();
    }
    }
    
//Employee Subclass
    public class Employee extends Person{
        private String office;
        private double salary;
        private Date dateHired;

        // Constructor to intialize the values
        public Employee(String name, String address, String number, String email, String office, double salary, Date dateHired){
            super(name, address, number, email);
            this.office = office;
            this.salary = salary;
            this.dateHired = dateHired;

        }

        //Getter methods
        public String getOffice(){
            return office;
        }
        public double getSalary(){
            return salary;
        }
        public Date getHireDate(){
            return dateHired;
        }

    // Override the toString method to display the class name and the person's name
        @Override
        public String toString() {
            return getClass().getSimpleName() + ": " + getName() + ", hired in " + dateHired.getYear();
        }
    }

    //Faculty Subclass
    public class Faculty extends Employee{
        private int hours;
        private String rank;

        // Constructor to intialize the values
        public Faculty(String name, String address, String number, String email, String office, double salary, Date dateHired, int hours, String rank){
            super(name, address, number, email, office, salary,dateHired);
            this.hours = hours;
            this.rank = rank;
        }

        //Getter methods
        public int getHours(){
            return hours;
        }
        public String getRank(){
            return rank;
        }
    }

    //Staff Subclass
    public class Staff extends Employee{
        String title;

         // Constructor to intialize the values
        public Staff(String name, String address, String number, String email, String office, double salary, Date dateHired, String title){
            super(name, address, number, email, office, salary,dateHired);
            this.title = title;
        }

        //Getter method
        public String getTitle(){
            return title;
        }

    }

}