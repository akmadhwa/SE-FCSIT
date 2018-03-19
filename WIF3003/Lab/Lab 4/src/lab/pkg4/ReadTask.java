/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4;

/**
 *
 * @author Admin
 */
public class ReadTask implements Runnable{
    
    private ManageStackAccess msa;
    private Integer value;
    
    public ReadTask(ManageStackAccess msa){
        this.msa = msa;
    }
    
    public void run(){
        try{
            for(int i=0;i<5;i++){
                Thread.sleep(50);
                value = msa.popFromStack();
            }
        }catch(InterruptedException e){
            
        }
    }
    
    public Integer getValue(){
        return value;
    }
    
}
