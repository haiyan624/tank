package wq.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyFrame frame = new MyFrame();
//        new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while (true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
