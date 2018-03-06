package l2q2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class L2Q2 {

    public static void main(String[] args) {
        // TODO code application logic here
        final int number_of_thread = 4;
        final int total_array = 60000;
        int maxNum = 0;
        
        ArrayList<FindMaxThread> threads = new ArrayList();
        Timer time = new Timer();
        time.startTimer();
        for(int i=0;i<number_of_thread;i++){
            threads.add(new FindMaxThread(total_array/number_of_thread));
            threads.get(i).start();
        }
        
        // To join all the threads, making sure every thread has finished before going into next sequence
        try {
            for(int i=0;i<number_of_thread;i++)
                threads.get(i).join();
        } catch (InterruptedException ex) {
            Logger.getLogger(L2Q2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Find out max value for each thread
        for(int i=0;i<number_of_thread;i++){
            System.out.println(threads.get(i).getName()+" max is : "+threads.get(i).getMax());
            if(threads.get(i).getMax() > maxNum){
                maxNum = threads.get(i).getMax();
            }
        }
        time.endTime();
        System.out.println("Biggest number among the thread is : "+maxNum);
        System.out.println("Time taken to complete all thread : "+time.getTime());
        
        }
}
