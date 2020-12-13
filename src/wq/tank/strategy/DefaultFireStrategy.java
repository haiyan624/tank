package wq.tank.strategy;

import wq.tank.*;
import wq.tank.decorator.RectDecorator;
import wq.tank.decorator.TailDecorator;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.x + (tank.WIDTH / 2) - Bullet.WIDTH / 2;
        int bY = tank.y + (tank.HEIGHT / 2) - Bullet.HEIGHT / 2;


        new RectDecorator(
                new TailDecorator(
                        new Bullet(bX, bY, tank.dir, tank.group)));

        if (tank.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
