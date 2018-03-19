/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Admin
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManageStackAccess msa = new ManageStackAccess();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new ReadTask(msa));
        executor.execute(new WriteTask(msa));
        executor.execute(new ReadTask(msa));
        executor.execute(new WriteTask(msa));
        executor.execute(new ReadTask(msa));
        executor.shutdown();
    }
    
}
