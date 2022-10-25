package practice_in_class.interrupt;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            printMessage("I sleep...");
            try {
                Thread.sleep(10000); // sleep for 10 seconds
            } catch (InterruptedException e) {
                printMessage("What happen? Someone interrupted me...");
            }
            printMessage("I am awake.");
        };
        Thread t = new Thread(runnable);
        t.start();

        Thread.sleep(3000);
        printMessage("I cannot wait you to sleep anymore!!!");
        t.interrupt();
    }

    public static void printMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s: %s%n", threadName, message);
    }
}
