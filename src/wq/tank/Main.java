package wq.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyFrame frame = new MyFrame();
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            frame.tanks.add(new Tank(50 + i*80, 200, Dir.Up, frame, Group.BAD));
        }
//        new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while (true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
