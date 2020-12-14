package wq.dp.cor;

public class Collider2 implements Collider{
    @Override
    public boolean collide(int num) {
        System.out.println("2222222222");

        if(num==2){
            return false;
        }
        return true;
    }
}
