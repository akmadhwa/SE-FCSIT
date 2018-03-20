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
public class Room{

	//	Set global variables
    private int guests;
    private int cleaners;

    public Room(){
    	cleaners = 0;
    	guests = 0;
    }

    public synchronized void guestEnter() throws InterruptedException{
        while (guests>=6 || cleaners>0){
        	wait();
        }
        guests++;
        System.out.println("Guest enters. \t\tCleaner = "+cleaners+"\tGuest= "+guests);
    }

    public synchronized void guestExit(){
        guests--;
        System.out.println("Guest exits. \t\tCleaner = "+cleaners+"\tGuest= "+guests);
        notify();
    }

    public synchronized void cleanerEnter() throws InterruptedException{
        while(cleaners>0 || guests>0){
        	wait();
        }
        cleaners++;
        System.out.println("Cleaner enters. \t\tCleaner = "+cleaners+"\tGuest= "+guests);
    }

    public synchronized void cleanerExit(){
        cleaners--;
        System.out.println("Cleaner exits. \t\tCleaner = "+cleaners+"\tGuest= "+guests);
        notify();
    }
}
