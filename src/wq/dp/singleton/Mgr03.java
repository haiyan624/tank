package wq.dp.singleton;

public class Mgr03 {
    private volatile static Mgr03 instance;

    private Mgr03() {

    }

    public static Mgr03 getInstance() {
        if (instance == null) {
            synchronized (Mgr03.class) {
                if(instance == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Mgr03();
                }

            }

        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Mgr03.getInstance());
                }
            }).start();
        }

    }
}
