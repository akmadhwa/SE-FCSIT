package l2q2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class L2Q2 {

    public static void main(String[] args) {
        // TODO code application logic here
        final int NUMBER_OF_THREADS = 4;
        final int TOTAL_ARRAY = 60000;  
        int maxNum = 0;
        int average_array = TOTAL_ARRAY/NUMBER_OF_THREADS;    // How many array each thread should hold
        
        
        ArrayList<FindMaxThread> threads = new ArrayList(); // Creating arraylist that receive the threads object
        Timer time = new Timer();   // Importing custom timer class
        time.startTimer();  // Start timer
        for(int i=0;i<NUMBER_OF_THREADS;i++){
            threads.add(new FindMaxThread(average_array));
            threads.get(i).start();
        }
        
        // To join all the threads, making sure every thread has finished before going into next sequence
        try {
            for(int i=0;i<NUMBER_OF_THREADS;i++)
                threads.get(i).join();
        } catch (InterruptedException ex) {
            Logger.getLogger(L2Q2.class.getName()).log(Level.SEVERE, null, ex); // Auto generated code when placing the try catch block
        }
        time.endTime(); // End timer
        
        // Find out max value for each thread
        for(int i=0;i<NUMBER_OF_THREADS;i++){
            System.out.println(threads.get(i).getName()+" max is : "+threads.get(i).getMax());  // Printing out each thread max value
            if(threads.get(i).getMax() > maxNum){   // Comparing each max from different threads, keeping in a local variable
                maxNum = threads.get(i).getMax();
            }
        }
        
        System.out.println("Biggest number among the thread is : "+maxNum); // Print out max
        System.out.println("Time taken to complete all thread : "+time.getTime());
        
        }
}
