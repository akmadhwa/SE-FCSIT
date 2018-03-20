package l2q2;
public class Timer {
    
    long startTime,endTime,duration;
    
    public void startTimer(){
        startTime = System.nanoTime();
    }
    
    public void endTime(){
        endTime = System.nanoTime();
    }
    
    public long getTime(){
        return endTime-startTime;
    }
}
