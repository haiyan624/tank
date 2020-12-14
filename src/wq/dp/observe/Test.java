package wq.dp.observe;

public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        try {
            child.cry();
            Thread.sleep(100);
            System.out.println("-------");
            Thread.sleep(3000);
            child.cry();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
