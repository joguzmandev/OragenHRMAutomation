package helpers;

public class SleepThread {
    public static void by(long millis) {
        try{
            Thread.sleep(millis);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}