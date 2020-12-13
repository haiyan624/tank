package wq.tank;


import java.awt.*;

public class Explode extends GameObject {
    private static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        this.width=WIDTH;
        this.height=HEIGHT;
        GameModel.getInstance().add(this);
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }


    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            GameModel.getInstance().remove(this);

    }
}
