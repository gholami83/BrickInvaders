import processing.core.PApplet;

public class Giant {
    public static PApplet a = Main.processing;
    public static int speedY = -6500;
    public static int GiantWidth = 400;
    public static int GiantHeight = 300;
    public int preventDeg = 15;
    public boolean checkGiantScoreUp = false;
    public boolean CheckGiantScoreDown = false;
    private int GiantX;
    private int GiantY;
    private int giantNum;

    public Giant(int blockX, int blockY) {
        GiantX = blockX;
        GiantY = blockY;
    }


    public static void makeBlocks() {
        for (int i = 0; i < 1; i++) {
            a = new PApplet();
            Main.giants.add(new Giant((int) a.random(100,200), speedY));
            speedY -=200;
            Main.giants.add(new Giant((int) a.random(300,400), speedY));
            speedY +=200;
            Main.giants.add(new Giant((int) a.random(600,700), speedY));
        }
    }

    public int getGiantY() {
        return GiantY;
    }

    public void setGiantY(int GiantY) {
        this.GiantY = GiantY;
    }

    public int getGiantX() {
        return GiantX;
    }


}
