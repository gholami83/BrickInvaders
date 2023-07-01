import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    SoundFile soundFile1;
    SoundFile soundFile2;
    SoundFile soundFile3;
    private int life = 5;
    String giantString = "target/generated-sources/Tank/pngwing.com(5).png";
    String lifeImg = "target/generated-sources/win or lost background/pngwing.com(7).png";
    String bg1 = "target/generated-sources/background/31377.jpg";
    String bg2 = "target/generated-sources/background/85285.jpg";
    String bg3 = "target/generated-sources/background/130224.jpg";
    String bg4 = "target/generated-sources/background/188122.jpg";
    String bg5 = "target/generated-sources/background/214926.jpg";
    String bg6 = "target/generated-sources/background/439759.jpg";
    String bg7 = "target/generated-sources/background/439762.jpg";
    String bg8 = "target/generated-sources/background/439764.jpg";
    String bg9 = "target/generated-sources/background/439766.jpg";
    String bg10 = "target/generated-sources/background/439824.jpg";
    String menuBg = "target/generated-sources/win or lost background/peakpx(4).jpg";
    String winBg = "target/generated-sources/win or lost background/peakpx(3).jpg";
    String lostBg = "target/generated-sources/win or lost background/peakpx(5).jpg";
    String JetBg = "Jet-background.png";
    String jet1 = "target/generated-sources/F14/kisspng-grumman-f-14-tomcat-mcdonnell-douglas-f-15-eagle-u-5b0f45ca71f866.9024850215277275624668.png";
    String jet2 = "target/generated-sources/F14/kisspng-xenonauts-2-fighter-aircraft-airplane-5af90b141eb143.8598210915262707401257.png";
    String jet3 = "target/generated-sources/F14/pngwing.com(1).png";
    String jet4 = "target/generated-sources/F14/pngwing.com(2).png";
    String jet5 = "target/generated-sources/F14/pngwing.com.png";
    String jet6 = "target/generated-sources/F14/kisspng-grumman-f-14-tomcat-iai-lavi-air-force-3d-modeling-mig-21-5b4a9878d06e63.6451220915316153528537.png";
    String rocket = "target/generated-sources/F14/Rocket.png";
    String tank1 = "target/generated-sources/Tank/pngwing.com(4).png";
    String tank2 = "target/generated-sources/Tank/pngwing.com(5).png";
    String tank3 = "target/generated-sources/Tank/pngwing.com(6).png";
    boolean menu1 = false;
    boolean menu2 = false;
    boolean checkX = true;
    boolean gameOver = false;
    public int score = 0;
    public boolean win = false;
    public static PApplet processing;
    public static ArrayList<Tank> tanks = new ArrayList<>();
    public static ArrayList<Rocket> rockets = new ArrayList<>();
    public static ArrayList<Giant> giants = new ArrayList<>();
    PImage pImageJet;
    PImage pImageBg;
    PImage pImageLife;
    PImage tankImg;
    PImage rocketImg;
    PImage giantImg;
    public int mX;
    HashMap<Integer, String> hashBg = new HashMap<>();
    HashMap<Integer, String> hashTank = new HashMap<>();

    public void showTank(int x, int y) {
        image(tankImg, x, y, Tank.TankWidth, Tank.TankHeight);
    }

    public void moveTank() {
        if (!win && !gameOver) {
            for (Tank tank : tanks) {
                tank.setBlockY((int) (tank.getTankY() + random(3, 4)));
            }
            if (gameOver) {
                for (Tank tank : tanks) {
                    tank.setBlockY(0);
                }
            }
        }
    }

    public void showRocket(int x, int y) {
        image(rocketImg, x, y, Rocket.RocketWidth, Rocket.RocketHeight);
    }

    public void moveRocket() {
        if (!win && !gameOver) {
            for (Rocket rocket : rockets) {
                rocket.setRocketY((int) (rocket.getRocketY() - 8));
            }
            if (gameOver) {
                for (Tank tank : tanks) {
                    tank.setBlockY(0);
                }
            }
        }
    }

    public void showGiant(int x, int y) {
        image(giantImg, x, y, Giant.GiantWidth, Giant.GiantHeight);
    }

    int plus;

    public void moveGiant() {

        if (!win && !gameOver) {

            for (Giant giant : giants) {
                if (giant.getGiantY() < -100) {
                    plus = 4;
                }
                if (giant.getGiantY() == -100) {
                    plus = 2;
                }
                if (giant.getGiantY() > 500) {
                    plus = -4;
                }
                giant.setGiantY((int) (giant.getGiantY() + plus));
            }
            if (gameOver) {
                for (Giant giant : giants) {
                    giant.setGiantY(0);
                }
            }
        }
    }

    @Override
    public void setup() {
        ///////////////////////////////////////////////////////////////////////
        hashBg.put(1, bg1);
        hashBg.put(2, bg2);
        hashBg.put(3, bg3);
        hashBg.put(4, bg4);
        hashBg.put(5, bg5);
        hashBg.put(6, bg6);
        hashBg.put(7, bg7);
        hashBg.put(8, bg8);
        hashBg.put(9, bg9);
        hashBg.put(10, bg10);
        giantImg = loadImage(giantString);
        rocketImg = loadImage("target/generated-sources/F14/Rocket.png");
        pImageBg = loadImage(bg6);
        tankImg = loadImage(tank1);
        pImageLife = loadImage(lifeImg);
        soundFile1 = new SoundFile(this, "target/generated-sources/Sound/1629287274_B3uO5.mp3");
        soundFile2 = new SoundFile(this, "target/generated-sources/Sound/Missile Sound.mp3");
        soundFile3 = new SoundFile(this, "target/generated-sources/Sound/urban.warfare_music_sample.mp3");
        Tank.makeBlocks();
        Giant.makeBlocks();
        processing = this;
    }

    @Override
    public void settings() {
        size(1150, 650);
    }

    @Override
    public void draw() {
        playSound();
        menu();
        if (menu1) {
            if (keyPressed) {
                if (key == 'w') {
                    for (Tank tank : tanks)
                        tank.setBlockY(tank.getTankY() + 7);
                }
                if (key == 's') {
                    for (Rocket rocket : rockets)
                        rocket.setRocketY(rocket.getRocketY() - 7);
                }
            }
            image(pImageBg, 0, 0, 1150, 660);
            for (Tank tank : tanks) {
                showTank(tank.getTankX(), tank.getTankY());
            }
            for (Rocket rocket : rockets) {
                showRocket(rocket.getRocketX(), rocket.getRocketY());
            }
            for (Giant giant : giants) {
                showGiant(giant.getGiantX(), giant.getGiantY());
            }
            //////////////////////////////  : text
            fill(30, 255, 0);
            textSize(25);
            text(String.format("score: %s", score), 40, 59);
            image(pImageLife, 40, 80, 35, 40);
            text(life, 100, 110);
            text("Brick invaders", 960, 59);
            ////////////////////////////////
//            scoreUp();
            touchRocket();
            ////////////////////////////// : line
            stroke(200, 200, 80);
            strokeWeight(10);
            line(0, 640, 1150, 640);
            ////////////////////////////////// jet
            noFill();
            image(pImageJet, mouseX - 40, 510, 65, 120);
//            crashed();
            win();
            moveTank();
            moveRocket();
            moveGiant();
            heartDown();
            lost();
        }
    }

    public void mouseClicked() {
        fire();
    }

    public void playSound() {
        if (!soundFile3.isPlaying() && !win && !gameOver) {
            soundFile3.play();
        }
    }

    public void fire() {
        if (menu1) {
            mX = mouseX;
            Rocket.makeRocket(mX - 20);
            soundFile2.play();
        }
    }

    public void stop() {
        Tank.speedY = 0;
        Rocket.speedY = 0;
    }

    public void heartDown() {
        for (Tank tank : tanks) {
            if (life > 0 && tank.getTankX() > mouseX - 70 && tank.getTankX() < mouseX + 55 && tank.getTankY() > 450 && tank.getTankY() < 610 && !(tank.CheckTankScoreDown)) {
                tank.CheckTankScoreDown = true;
                tank.checkTankScoreUp = true;
                life -= 1;

            }
        }
        for (Giant giant : giants) {
            if (life > 0 && giant.getGiantX() < mouseX - 70 && giant.getGiantX() + 400 > mouseX + 50 && giant.getGiantY() > 480 && giant.getGiantY() < 610 && !(giant.CheckGiantScoreDown)) {
                giant.checkGiantScoreUp = true;
                giant.CheckGiantScoreDown = true;
                life -= 1;

            }
        }
    }

    boolean b;

    public void touchRocket() {
        for (Tank tank : tanks) {
            b = false;
            for (Rocket rocket : rockets) {
                if (tank.getTankX() > rocket.getRocketX() - 50 && tank.getTankX() < rocket.getRocketX() + 50 &&
                        tank.getTankY() > rocket.getRocketY() - 50 && tank.getTankY() < rocket.getRocketY() + 50 && tank.preventDeg > 0) {
                    score += 1;
                    soundFile1.play();
                    tank.preventDeg -= 1;
                    rockets.remove(rocket);
                    break;
                }
            }
            if (tank.preventDeg == 0) {
                tanks.remove(tank);
                break;
            }
        }
        for (Giant giant : giants) {
            b = false;
            for (Rocket rocket : rockets) {
                if (giant.getGiantX() < rocket.getRocketX() - 50 && giant.getGiantX() + 400 > rocket.getRocketX() + 50 &&
                        giant.getGiantY() > rocket.getRocketY() - 50 && giant.getGiantY() < rocket.getRocketY() + 50 && giant.preventDeg > 0) {
                    score += 1;
                    soundFile1.play();
                    giant.preventDeg -= 1;
                    rockets.remove(rocket);
                    break;
                }
            }
            if (giant.preventDeg == 0) {
                giants.remove(giant);
                break;
            }
        }
    }

    public void keyPressed() {
        if (key == 'q') {
            pImageBg = loadImage((hashBg.get((int) random(1.0F, 10.0F))).toString());
        }
    }

    public void win() {
        if (giants.size() == 0) {
            win = true;
        }
        if (life > 0 && win) {
            soundFile3.stop();
            soundFile1.stop();
            soundFile2.stop();
            frameRate(2);
            image(loadImage(winBg), 0, 0, 1150, 660);
            //////////////////////////////////////////////////////////////////////
            fill(180, 24, 237);
            textSize(45);
            text(String.format("You won!\nCongratulations!\nYour Score   %s", score), 350, 200);
            /////////////////////////////////////////////////////
            fill(250, 22, 7);
            textSize(48);
            text("Exit", 520, 560);
            if (mouseX > 515 && mouseX < 600 && mouseY > 520 && mouseY < 560) {
                fill(245, 61, 61);
                textSize(48);
                text("Exit", 520, 560);
                if (mousePressed) {
                    System.exit(0);
                }
            }
            stop();
        }
    }

    public void lost() {
        if (life == 0) {
            gameOver = true;
            image(loadImage(lostBg), 0, 0, 1150, 660);
            fill(176, 25, 2);
            textSize(50);
            text(String.format("Game Over!\nhighScore  %s\nYour Score  %s", score), 170, 170);

            ///////////////////////////
            fill(250, 22, 7);
            textSize(48);
            text("Exit", 520, 560);
            //////////////////////////////
            if (mouseX > 515 && mouseX < 600 && mouseY > 520 && mouseY < 560) {
                fill(245, 61, 61);
                textSize(48);
                text("Exit", 520, 560);
                if (mousePressed) {
                    System.exit(0);
                }
            }
            stop();
        }
    }

    public void menu() {
        if (!menu1) {
            image(loadImage(menuBg), 0, 0, 1150, 660);
//            background(63, 204, 209);
            fill(0, 0, 0);
            textSize(90);
            text("BRICK  INVADERS!", 230, 140);
            fill(200, 0, 220);
            textSize(60);
            text("Select a Jet to PLay", 310, 215);
            /////////////////////////\
            fill(250, 22, 7);
            textSize(48);
            text("Exit", 520, 560);
            /////////////////////////////////
            image(loadImage(jet1), 100, 255, 140, 200);
            image(loadImage(jet2), 250, 255, 140, 200);
            image(loadImage(jet3), 405, 255, 140, 200);
            image(loadImage(jet4), 580, 255, 140, 200);
            image(loadImage(jet5), 740, 255, 140, 200);
            image(loadImage(jet6), 890, 255, 140, 200);

            if (mouseX > 125 && mouseX < 215 && mouseY > 280 && mouseY < 430 && mousePressed) {
                pImageJet = loadImage(jet1);
                menu1 = true;
            } else if (mouseX > 270 && mouseX < 360 && mouseY > 290 && mouseY < 440 && mousePressed) {
                pImageJet = loadImage(jet2);
                menu1 = true;
            } else if (mouseX > 435 && mouseX < 520 && mouseY > 280 && mouseY < 440 && mousePressed) {
                pImageJet = loadImage(jet3);
                menu1 = true;
            } else if (mouseX > 600 && mouseX < 700 && mouseY > 280 && mouseY < 440 && mousePressed) {
                pImageJet = loadImage(jet4);
                menu1 = true;
            } else if (mouseX > 765 && mouseX < 860 && mouseY > 283 && mouseY < 443 && mousePressed) {
                pImageJet = loadImage(jet5);
                menu1 = true;
            } else if (mouseX > 910 && mouseX < 1010 && mouseY > 280 && mouseY < 440 && mousePressed) {
                pImageJet = loadImage(jet6);
                menu1 = true;
            }
            if (mouseX > 515 && mouseX < 600 && mouseY > 520 && mouseY < 560) {
                fill(245, 61, 61);
                textSize(48);
                text("Exit", 520, 560);
                if (mousePressed) {
                    System.exit(0);
                }
            }
        }
    }

}
