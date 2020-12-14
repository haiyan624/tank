package wq.dp.cor;

public class Collider3 implements Collider{
    @Override
    public boolean collide(int num) {
        System.out.println("33333333");

        if(num==3){
            return false;
        }
        return true;
    }
}
