/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;
import java.util.Random;

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
        Room room = new Room();
        
        Guest guest = new Guest(room);
        Cleaner cleaner = new Cleaner(room);
        
        int i=0;
        while(i<20){
            if(new Random().nextBoolean() == true){
                guest = new Guest(room);
                guest.start();
            }
            if(new Random().nextInt(5) < 2){
                cleaner = new Cleaner(room);
                cleaner.start();
            }
            i++;
        }
    }
    
}

