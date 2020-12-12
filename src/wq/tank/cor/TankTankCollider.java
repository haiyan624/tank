package wq.tank.cor;

import wq.tank.GameObject;
import wq.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject g1, GameObject g2) {
        if (g1 instanceof Tank && g2 instanceof Tank) {
            Tank tank1 = (Tank) g1;
            Tank tank2 = (Tank) g2;
            if(tank1.rect.intersects(tank2.rect)){
                tank1.back();
                tank2.back();
            }
        }
        return true;
    }
}
