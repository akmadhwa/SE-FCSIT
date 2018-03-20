package l2q2;

import java.util.ArrayList;
import java.util.Random;

public class FindMaxThread extends Thread{
    
    private int maxNum=0;
    private ArrayList<Integer> numbers;
    public int limit_size;
    
    FindMaxThread(int limit_size){
        this.limit_size = limit_size;
    }
    
    @Override
    public void run(){
        numbers = new ArrayList();
        System.out.println("Starting thread : "+this.getName());
        Random a = new Random();
        int random;
        for(int i=0;i<this.limit_size;i++){
            random = a.nextInt(60000);  // Set random number value limit
            numbers.add(random);    // Keep the random number in the array
            if(random>this.maxNum)  // Straight away comparing the random number
                this.maxNum = random;
        }
    }
    
    public int getMax(){
        return this.maxNum;
    }
    
}
