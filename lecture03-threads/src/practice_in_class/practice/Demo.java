package practice_in_class.practice;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        new Thread(() -> System.out.println("Hello from another thread." + Thread.currentThread().getName())).start();

        System.out.println("Hello here. " + Thread.currentThread().getName());
    }
}
