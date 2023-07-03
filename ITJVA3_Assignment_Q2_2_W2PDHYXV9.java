public class ITJVA3_Assignment_Q2_2_W2PDHYXV9 {
    
    public static void main(String[] args) {

        int max = 1000000;
        int[] numberStore = new int[max];

        for (int index = 0; index < max; index++){
            numberStore[index] = index + 1;
        }

        long timeBegin = System.currentTimeMillis();

        for (int index = 0; index < max; index++){
            numberStore[index] = numberStore[index];
        }
        long timeEnd = System.currentTimeMillis();

        long totalTime = (timeEnd - timeBegin);
        System.out.println("The system took " + totalTime + "ms to traverse the numbers list. \n");

        int last = numberStore.length - 1;
        int lastNum = numberStore[last];

        System.out.println("The last number in the list is " + lastNum + ".\n");


    }
}
