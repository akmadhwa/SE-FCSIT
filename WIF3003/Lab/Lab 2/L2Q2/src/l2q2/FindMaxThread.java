package l2q2;

import java.util.ArrayList;
import java.util.Random;

public class FindMaxThread extends Thread{
    
    private int maxNum=0;
    private ArrayList<Integer> numbers;
    private String threadName;
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
            random = a.nextInt(60000);
            numbers.add(random);
            if(random>this.maxNum)
                this.maxNum = random;
        }
    }
    
    public int getMax(){
        return this.maxNum;
    }
    
}
