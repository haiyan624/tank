package wq.tank.cor;

import wq.tank.Bullet;
import wq.tank.Explode;
import wq.tank.GameObject;
import wq.tank.Tank;

public class TankBulletCollider implements Collider {
    @Override
    public boolean collide(GameObject g1, GameObject g2) {
        if (g1 instanceof Tank && g2 instanceof Bullet) {
            Tank tank = (Tank) g1;
            Bullet bullet = (Bullet) g2;
            if (tank.getGroup() == bullet.group) {
                return true;
            }

            if (tank.rect.intersects(bullet.rect)) {
                tank.setLiving(false);
                bullet.living = false;
                int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                tank.gm.add(new Explode(eX, eY, tank.gm));
                return false;
            }
        }
        if (g1 instanceof Bullet && g2 instanceof Tank) {
            return collide(g2, g1);
        }
        return true;
    }
}