package wq.tank.strategy;

import wq.tank.*;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.x + (tank.WIDTH / 2) - Bullet.WIDTH / 2;
        int bY = tank.y + (tank.HEIGHT / 2) - Bullet.HEIGHT / 2;
        Bullet bullet = new Bullet(bX, bY, tank.dir, tank.group);
        GameModel.getInstance().add(bullet);
        if (tank.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
