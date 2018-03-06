/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l2q1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class L2Q1 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        final int limit_size = 60000;
        int maxNum = 0;
        
        Random a = new Random();
        ArrayList<Integer> numbers = new ArrayList();
        
        for(int i=0; i<limit_size; i++){
            numbers.add(a.nextInt(60000));
        }
        
        for(int num : numbers)
            if(num>maxNum)
                maxNum = num;
        
        System.out.println("Max number is "+maxNum);
    }
    
}
