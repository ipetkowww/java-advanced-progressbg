package practice_in_class.practice;

public class SimpleThread {

    static void threadMessage(String message) {
        System.out.printf("%s: %s%n", Thread.currentThread().getName(), message);
    }

    static class MessageLoop implements Runnable {

        @Override
        public void run() {
            String[] messages =
                    {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};

            try {
                for (String message : messages) {
                    Thread.sleep(4000); // 4 seconds pause
                    threadMessage(message); // print a message
                }
            } catch (InterruptedException e) {
                threadMessage("I was not done!");
            }
        }

        public static void main(String[] args) throws InterruptedException {
            long patience = 10000;

            threadMessage("Starting MessageLoop thread!");
            long startTime = System.currentTimeMillis();
            Thread t = new Thread(new MessageLoop());
            Thread t1 = new Thread(new MessageLoop());
            t.start();
            t1.start();
            threadMessage("Waiting for MessageLoop thread to finish");

            while (t.isAlive()) {
                threadMessage("Still waiting...");
                t.join(2500);

                if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                    threadMessage("Tired of waiting!");
                    t.interrupt();
                    t1.interrupt();
                }
            }
            threadMessage("Finally!!!!");
        }
    }

}
