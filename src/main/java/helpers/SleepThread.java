package helpers;

public class SleepThread {
    public static void by(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}