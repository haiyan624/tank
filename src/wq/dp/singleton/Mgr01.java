package wq.dp.singleton;

public class Mgr01 {
    private static Mgr01 instance = new Mgr01();

    private Mgr01() {

    }

    public static Mgr01 getInstance() {
        return instance;
    }
}
