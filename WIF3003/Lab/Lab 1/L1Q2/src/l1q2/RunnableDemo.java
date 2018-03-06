/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l1q2;

/**
 *
 * @author Admin
 */
public class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;
    
    RunnableDemo(String name){
        threadName = name;
        System.out.println("Creating "+threadName);
    }
    
    public void run(){
        System.out.println("Running "+threadName);
        try{
            for(int i=4;i>0;i--){
                System.out.println("Thread: "+threadName+", "+i);
                //before continue to next iteration, ask the thread to sleep for a while
                Thread.sleep(50);
            }
        }catch(InterruptedException e){
            System.out.println("Thread: "+threadName+" interrupted.");
        }
        //End or exiting the thread
        System.out.println("Thread: "+threadName+" exiting.");
    }
    
    public void start(){
        System.out.println("Starting "+threadName);
        if (t==null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
    
}
