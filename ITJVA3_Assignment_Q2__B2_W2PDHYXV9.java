import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

//Setting a class that uses the Runnable interface
class Cars implements Runnable{
    //Declaring all the variables available in the Cars class
    private String model;
    private String driver;
    private double speed;
    private double acceleration;
    private int laps;
    private CountDownLatch startLatch;
    private CountDownLatch finishLatch; 

    //Declaring the constructor for all the variables
    public Cars(String model, String driver, double speed, double acceleration, int laps, CountDownLatch startLatch, CountDownLatch finisLatch){
        this.model = model;
        this.driver = driver;
        this.speed = speed;
        this.acceleration = acceleration;
        this.laps = laps;
        this.startLatch = startLatch;
        this.finishLatch = finisLatch;
    }

    //Setting get methods for the model, driver, speed and acceleration variables.
    public String getModel(){
        return model;
    }
    public String getDriver(){
        return driver;
    }
    public double getSpeed(){
        return speed;
    }
    public double getAcceleration(){
        return acceleration;
    }

    @Override
    //Setting the functional method to use the runnable interface
    public void run(){
        try{
            /*Calling the await method from within the CountDownLatch class, this will simulate the cars waiting for 
            the start signal*/
            startLatch.await();

            //The race is being simulated
            double totalDistance = 0;
            // A for loop simulating the time in which each car completes a lap
            for (int index = 0; index < laps; index++){
                totalDistance += calcDistance(speed, acceleration);
            }

            //Calling the countdown method from within the CountDownLatch class which waits for all the cars to finish
            finishLatch.countDown();

            //Displaying finishing times on the user's screen

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //This method calculates the distance each car completed.
    private double calcDistance(double speed, double acceleration){
        double time = speed/acceleration;
        double distance = (speed*time) + (0.5 * acceleration *Math.pow(time, 2));
        return distance;
    }
}

public class ITJVA3_Assignment_Q2__B2_W2PDHYXV9 {
    //Setting the number of laps as final, preventing them from being changed later
    private static final int NUM_LAPS = 10;
    //Running the main program
        public static void main(String[] args) throws InterruptedException {
            CountDownLatch starLatch = new CountDownLatch(1);
            //The number of cars that should be waited for
            CountDownLatch finisLatch = new CountDownLatch(5);

            //Creating a new list that will accept values of the Cars class type, we will pass all the driver information through this list
            List <Cars> cars = new ArrayList<>();
            cars.add(new Cars("Ferrari", "Michael Schumacher", 20, 5, NUM_LAPS, starLatch, finisLatch));
            cars.add(new Cars("Porsche", "Rob De Gea", 18, 4, NUM_LAPS, starLatch, finisLatch));
            cars.add(new Cars("Mercedes", "Lewis Hamilton", 22, 6, NUM_LAPS, starLatch, finisLatch));
            cars.add(new Cars("BMW", "Fredrick Martinez", 16, 3, NUM_LAPS, starLatch, finisLatch));
            cars.add(new Cars("Lamborghini", "Luciano Porque", 24, 7, NUM_LAPS, starLatch, finisLatch));

            //STARTING THE RACE!!
            System.out.println("Let The Race Begin!");
            System.out.println("There are " + NUM_LAPS + " Laps\n GOOD LUCK!");

            //Setting a thread for each car in the race
            for (Cars car :cars) {
                new Thread(car).start();
            }
            //Waiting 3 seconds before starting the race
            Thread.sleep(3000);
            //Releasing the start signal
            starLatch.countDown();

            //Waiting for all the cars to finish
            finisLatch.await();

            //THE RACE IS FINISHED!!
            System.out.println("Race Complete!");

            //Setting the fastest variable as the largest possible double value
            double fastest = Double.MAX_VALUE;
            String winner ="";

            Thread.sleep(2000);

            //Running a loop to calculate the completes time for each driver and deciding the winner
            for (Cars car: cars){
            double time = (NUM_LAPS * car.getSpeed()) / car.getAcceleration();
            System.out.println(car.getModel() + " finished the race in " + time + "s(Driver: " +car.getDriver() + ")");

            if (time < fastest) {
                fastest = time;
                winner = car.getDriver() + " in " + car.getModel();
                }
            }

            //Displaying the winner info
            System.out.println("\n\n "+ winner +"\n\n");

        }
}
