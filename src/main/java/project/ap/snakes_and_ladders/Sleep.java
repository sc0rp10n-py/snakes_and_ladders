package project.ap.snakes_and_ladders;

public class Sleep extends Thread {
    private int time;

    public Sleep(int time) {
        this.time = time;
    }

    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
