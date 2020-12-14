package wq.dp.cor;

import java.util.ArrayList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> chain = new ArrayList<>();

    public void add(Collider collider) {
        chain.add(collider);
    }

    @Override
    public boolean collide(int num) {
        for (Collider collider : chain) {
            if (!collider.collide(num)) {
                return false;
            }
        }
        return true;
    }
}
