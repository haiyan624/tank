package wq.dp.cor;

/**
 * 创建基础接口，有方法collide
 * 分别实现自己的实现类，Collider1,2等
 * 重点：创建chain类，实现collider，维护一个collider的list，在接口中定义的collide方法遍历list，
 */
public class Test {
    public static void main(String[] args) {
        ColliderChain colliderChain= new ColliderChain();
        colliderChain.add(new Collider1());
        colliderChain.add(new Collider2());
        colliderChain.add(new Collider3());
        colliderChain.collide(2);

        System.out.println("----------");
        colliderChain.collide(3);

    }
}
