package wq.tank;

import wq.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private Tank myTank;
    //    public List<Tank> tanks = new ArrayList<>();
//    public List<Bullet> bullets = new ArrayList<>();
//    public List<Explode> explodes = new ArrayList<>();
    private List<GameObject> objects = new ArrayList<>();
    private ColliderChain chain = new ColliderChain();
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    private void init(){
        myTank = new Tank(200, 200, Dir.Up, Group.GOOD);
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        // 初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.Down, Group.BAD);
        }

        // 初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }
    private GameModel() {

    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObject go) {
        objects.add(go);
    }

    public void remove(GameObject go) {
        objects.remove(go);
    }

    public void paint(Graphics g) {

//        Color c = g.getColor();
//        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
//        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
//        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) { //Comparator.compare(o1,o2)
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
