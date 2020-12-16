package wq.dp.observe;

/**
 * 观察者模式
 * 接口：观察者/Listener  、 事件（包含source）
 * 被观察者需要有List存放Listener，并且需要观察的地方新建事件，进行遍历，调用观察者的指定方法， 触发事件
 */
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
