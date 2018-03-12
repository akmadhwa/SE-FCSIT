/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

/**
 *
 * @author Admin
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Room roomA = new Room();

        Thread threadA = new Thread(){
          public void run(){
              roomA.cleanerEnter(14);
          }  
        };
        
        Thread threadB = new Thread(){
          public void run(){
              roomA.guestEnter(4);
          }  
        };
        
        Thread threadC = new Thread(){
          public void run(){
              roomA.allLeft();
          }  
        };
        
        threadB.setPriority(10);
        threadC.setPriority(5);
        threadA.setPriority(9);
        
        threadB.start();
        threadA.start();
        threadC.start();
        
        threadC.join();
        threadB.join();
        threadA.join();
        
        
        // Aku x tau aku buat apa gais. But it seems working. hm
    }
    
}

