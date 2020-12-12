package wq.tank.cor;

import wq.tank.GameObject;

public interface Collider {
    boolean collide(GameObject g1,GameObject g2);
}
