package practice_in_class.horseRace;

public class Demo {

    public static void main(String[] args) {
        Horse marko = new Horse("Marko");
        Horse jory = new Horse("Jory");

        marko.start();
        jory.start();

        Thread pony = new Thread(new Pony());

        Runnable supporter = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("GO GO MARKO!!! @ thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(supporter).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("GO PONY, GO PONY! @ thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        pony.start();

        System.out.println("END OF RACE @ thread " + Thread.currentThread().getName());
    }
}
