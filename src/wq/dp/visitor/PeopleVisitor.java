package wq.dp.visitor;

public class PeopleVisitor implements Visitor{
    private int totalPrice;
    @Override
    public void visitorCpu(AbstractComponent a) {
        totalPrice = totalPrice+a.getPrice()-1;
    }

    @Override
    public void visitorMemory(AbstractComponent a) {
        totalPrice = totalPrice+a.getPrice()-2;

    }

    @Override
    public void visitorStorage(AbstractComponent a) {
        totalPrice = totalPrice+a.getPrice()-3;

    }

    @Override
    public int getTotalPrice() {
        return totalPrice;
    }
}
