import processing.core.PApplet;

public class Rocket {
    public static PApplet a = Main.processing;
    public static int speedY = 550;
    public static int RocketWidth = 20;
    public static int RocketHeight =50;
    public boolean checkRocket = false;

    private int RocketX;
    private int RocketY;

    public Rocket(int RocketX, int RocketY) {
        this.RocketX = RocketX;
        this.RocketY = RocketY;
    }


    public static void makeRocket(int mouseX) {
        for (int i = 0; i < 1; i++) {
            a = new PApplet();
            Main.rockets.add(new Rocket(mouseX,speedY));
        }
    }

    public int getRocketY() {
        return RocketY;
    }

    public void setRocketY(int RocketY) {
        this.RocketY = RocketY;
    }

    public int getRocketX() {
        return RocketX;
    }



}
