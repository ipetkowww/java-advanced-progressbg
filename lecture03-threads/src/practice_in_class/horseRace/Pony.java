package practice_in_class.horseRace;

public class Pony implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Pony is hopping " + (i * 10) + " meters @ thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(215);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
