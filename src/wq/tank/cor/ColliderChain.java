package wq.tank.cor;

import wq.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> chain = new LinkedList<>();

    public ColliderChain() {
        add(new TankBulletCollider());
        add(new TankTankCollider());
    }

    public void add(Collider collider) {
        chain.add(collider);
    }

    @Override
    public boolean collide(GameObject g1, GameObject g2) {
        for (Collider collider : chain) {
            if (!collider.collide(g1, g2)) {
                return false;
            }
        }
        return true;
    }
}
