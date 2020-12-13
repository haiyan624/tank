package wq.tank.cor;

import wq.tank.*;

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
                int eX = tank.getX() + Tank.WIDTH / 2 - bullet.getWidth() / 2;
                int eY = tank.getY() + Tank.HEIGHT / 2 - bullet.getHeight() / 2;
                new Explode(eX, eY);
                return false;
            }
        }
        if (g1 instanceof Bullet && g2 instanceof Tank) {
            return collide(g2, g1);
        }
        return true;
    }
}
