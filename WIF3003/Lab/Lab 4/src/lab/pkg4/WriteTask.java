/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class WriteTask implements Runnable{
    
    private ManageStackAccess msa;
    
    public WriteTask(ManageStackAccess msa){
        this.msa = msa;
    }
    
    public void run(){
        int value;
        try{
            for(int i=0;i<10;i++){
                Thread.sleep(20);
                value = new Random().nextInt(100);
                msa.pushToStack(value);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
