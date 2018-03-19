/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4;

import java.util.Stack;
import java.util.concurrent.locks.*;

/**
 *
 * @author Admin
 */
public class ManageStackAccess {
    
    Stack<Integer> stack = new Stack();
    int CAPACITY = 6;
    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();
    
    public void pushToStack(Integer item){
        try{
            lock.lock();
            while(stack.size() == CAPACITY)
                stackFullCondition.await();
            stack.push(item);
            System.out.println("Thread #"+Thread.currentThread().getId()+" push "+item);
        }catch(InterruptedException e){
        }finally{
            lock.unlock();
        }
    }
    
    public Integer popFromStack(){
        try{
            lock.lock();
            while(stack.size() == 0){
                stackEmptyCondition.await();
            }
            int value = stack.pop();
            System.out.println("Thread #"+Thread.currentThread().getId()+" pop "+value);
            return value;
        }catch(InterruptedException e){
        }finally{
            stackFullCondition.signalAll();
            lock.unlock();
        }
        return -1;
    }
    
}
