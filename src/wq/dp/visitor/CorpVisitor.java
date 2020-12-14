package wq.dp.visitor;

public class CorpVisitor implements Visitor {
    private int totalPrice;

    @Override
    public void visitorCpu(AbstractComponent a) {
        totalPrice = totalPrice + a.getPrice() - 5;
    }

    @Override
    public void visitorMemory(AbstractComponent a) {
        totalPrice = totalPrice + a.getPrice() - 5;

    }

    @Override
    public void visitorStorage(AbstractComponent a) {
        totalPrice = totalPrice + a.getPrice() - 5;

    }

    @Override
    public int getTotalPrice() {
        return totalPrice;
    }
}
