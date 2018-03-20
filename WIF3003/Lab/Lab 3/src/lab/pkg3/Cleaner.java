/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

/**
 *
 * @author user
 */
public class Cleaner extends Thread{

    private Room room;

    public Cleaner(Room room_number){
        room=room_number;
    }

    public void run(){
        try{
            sleep(300);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        try{
            room.cleanerEnter();
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        try{
            sleep(300);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        room.cleanerExit();
    }
}
