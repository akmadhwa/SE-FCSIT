/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Room{
	private int guests,cleaners;
	Room(){
		guests = 0;
		cleaners = 0;
	}

	public synchronized void guestEnter(int guestsEnter){
            if((guests+guestsEnter)>5){
                System.err.println("More than 5 guests are trying to enter the room !");
            }else{
                if(cleaners != 0){
			try{
				System.out.println("Guests are waiting, currently have "+cleaners+" cleaners cleaning the room !");
				wait();
			}catch(Exception e){}
		}
                    guests+=guestsEnter;
                    System.out.println(guestsEnter+" guests entered the room."); 
            }
	}

	public synchronized void cleanerEnter(int cleanersEnter){
		if(guests != 0){
			try{
				System.out.println("Cleaners are waiting, currently have "+guests+" guests in the room !");
                                wait();
                        }catch(Exception e){}
		}
		cleaners+=cleanersEnter;
		System.out.println(cleanersEnter+" cleaners entered the room.");
	}

	public synchronized void allLeft(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(cleaners+" cleaners and "+guests+" guests left !");
            cleaners = 0;
            guests = 0;
            notifyAll();
	}
}
