package wq.tank.strategy;

import wq.tank.*;

public class FourFireStrategy implements  FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.x + (tank.WIDTH / 2) - Bullet.WIDTH / 2;
        int bY = tank.y + (tank.HEIGHT / 2) - Bullet.HEIGHT / 2;
        for (Dir value : Dir.values()) {
            GameModel.getInstance().add(new Bullet(bX, bY, value, tank.group));
        }

        if (tank.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
