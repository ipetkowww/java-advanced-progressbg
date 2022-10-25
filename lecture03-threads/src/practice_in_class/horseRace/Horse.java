package practice_in_class.horseRace;

public class Horse extends Thread {

    private String name;

    public Horse(String name) {
        this.name = name;
    }

    public void move() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.name + " is running " + (i * 10) + " meters @ thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            if (i == 5 && this.name.equals("Marko")) {
//                throw new RuntimeException(this.name + " is dead...");
//            }
        }
    }

    @Override
    public void run() {
        move();
    }
}
