package wq.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();

    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private static int SPEED = 10;
    private int x;
    private int y;
    private Dir dir;
    private boolean isMove = true;
    private MyFrame tf;
    private boolean living = true;
    private Group group;
    private Random random = new Random();
    Rectangle rect = new Rectangle();

    public Tank(int x, int y, Dir dir, MyFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public void fire() {
        int bX = x + (WIDTH / 2) - Bullet.WIDTH / 2;
        int bY = y + (HEIGHT / 2) - Bullet.HEIGHT / 2;
        Bullet bullet = new Bullet(bX, bY, dir, tf, this.group);
        tf.bullets.add(bullet);
        if (this.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();

    }

    public void paint(Graphics g) {
        if (!living) tf.tanks.remove(this);
        switch (dir) {
            case Left:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case Up:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case Right:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case Down:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }

        move();
        if (group == Group.BAD && random.nextInt(100) > 95) {
            fire();
        }
        if (group == Group.BAD && random.nextInt(100) > 95) {
            randomMove();
        }
        boundsCheck();
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > MyFrame.GAME_WIDTH - Tank.WIDTH - 2) x = MyFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > MyFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = MyFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomMove() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    private void move() {
        if (isMove) {
            switch (dir) {
                case Left:
                    x = x - SPEED;
                    break;
                case Right:
                    x = x + SPEED;
                    break;
                case Up:
                    y = y - SPEED;
                    break;
                case Down:
                    y = y + SPEED;
                    break;
            }
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Group getGroup() {
        return group;
    }
}
