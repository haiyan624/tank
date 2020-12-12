package wq.tank;

import java.awt.*;

public class Bullet {
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private static int SPEED = 10;
    private boolean living = true;
    GameModel gm;

    private int x;
    private int y;
    private Dir dir;
    private final Group group;
    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, GameModel gm, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        gm.bullets.add(this);

    }

    public Dir getDir() {
        return dir;
    }

    public void paint(Graphics g) {

        if (!living) {
            gm.bullets.remove(this);
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

    public void collideWith(Tank tank) {
        if (tank.getGroup() == this.group) return;

        if(rect.intersects(tank.rect)) {
            tank.setLiving(false);
            this.living=false;
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gm.explodes.add(new Explode(eX, eY, gm));
        }
    }
}
