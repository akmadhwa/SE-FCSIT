/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l1q3;

/**
 *
 * @author Admin
 */
public class ThreadA {
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
        
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();   // need to catch
            }catch(InterruptedException e){
                e.printStackTrace();    //display error to debug only
            }
            System.out.println("Total is: "+b.getTotal());
        }
    }
    
}
