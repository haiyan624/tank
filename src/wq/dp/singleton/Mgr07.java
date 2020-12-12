package wq.dp.singleton;

/**
 * 懒汉完美.静态内部类，外面类加载，里面不加载
 */
public class Mgr07 {
    private Mgr07(){

    }
   private static class Mgr07Holder{
       private static Mgr07 instance= new Mgr07();
   }
   public static Mgr07 getInstance(){
        return  Mgr07Holder.instance;
   }
}
