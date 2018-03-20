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
public class ThreadB extends Thread {
    int total;

    @Override
    public void run(){
        synchronized(this){
        for(int i=0;i<100;i++)
            total+=i;
        //how B is gonna notfiy A once threadB completed ? use notify()
        notify();
        }
    }

    public int getTotal() {
        return total;
    }
}
