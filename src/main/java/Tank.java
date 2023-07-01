import processing.core.PApplet;

public class Tank {

    public static PApplet a = Main.processing;
    public static int speedY = -90;
    public static int TankWidth = 50;
    public static int TankHeight = 120;
    public int preventDeg = 2;
    public boolean checkTankScoreUp = false;
    public boolean CheckTankScoreDown = false;
    private int TankX;
    private int TankY;
    private int tankNum;

    public Tank(int blockX, int blockY) {
        TankX = blockX;
        TankY = blockY;
    }

    int i = 0;

    public static void makeBlocks() {
        for (int i = 0; i < 10; i++) {
            a = new PApplet();
            Main.tanks.add(new Tank((int) a.random(60, 220), speedY));
            speedY -= 350;
            Main.tanks.add(new Tank((int) a.random(220, 390), speedY));
            speedY += 360;
            Main.tanks.add(new Tank((int) a.random(390, 560), speedY));
            speedY -= 340;
            Main.tanks.add(new Tank((int) a.random(560, 730), speedY));
            speedY += 330;
            Main.tanks.add(new Tank((int) a.random(730, 850), speedY));
            speedY -= 380;
            Main.tanks.add(new Tank((int) a.random(850, 1000), speedY));
            speedY += 350;
            Main.tanks.add(new Tank((int) a.random(1000, 1100), speedY));
            speedY -= 500;
        }
    }

    public int getTankY() {
        return TankY;
    }

    public void setBlockY(int TankY) {
        this.TankY = TankY;
    }

    public int getTankX() {
        return TankX;
    }


}

