package wq.tank;

import java.awt.*;

public abstract class GameObject {
    public int x,y;
    public int width,height;
    public abstract void paint(Graphics g);

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
