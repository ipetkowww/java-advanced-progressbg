package practice_in_class.practice;

public class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Priority of [" + Thread.currentThread().getName() +  "] = " + Thread.currentThread().getPriority());
            System.out.println("Is daemon [" + Thread.currentThread().getName() +  "] = " + Thread.currentThread().isDaemon());
            System.out.println("State of [" + Thread.currentThread().getName() +  "] = " + Thread.currentThread().getState());
            System.out.println("===============");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
