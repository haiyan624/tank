package wq.tank;

import java.awt.*;

public class Bullet extends GameObject {
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private static int SPEED = 10;
    public boolean living = true;
    private Dir dir;
    public final Group group;
    public Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        GameModel.getInstance().add(this);
        this.width = WIDTH;
        this.height = HEIGHT;

    }

    public Dir getDir() {
        return dir;
    }

    @Override
    public void paint(Graphics g) {

        if (!living) {
            GameModel.getInstance().remove(this);
        }

        switch (dir) {
            case Left:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceMgr.bulletR, x, y, null);

                break;
            case Up:
                g.drawImage(ResourceMgr.bulletU, x, y, null);

                break;
            case Down:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();

    }

    private void move() {
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

        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 | x > MyFrame.GAME_WIDTH | y < 0 | y > MyFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void die() {
        living = false;
    }
}
