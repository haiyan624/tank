package wq.dp.visitor;

public interface Visitor {
    void visitorCpu(AbstractComponent a);
    void visitorMemory(AbstractComponent a);
    void visitorStorage(AbstractComponent a);
    int getTotalPrice();
}
