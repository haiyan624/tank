package wq.dp.visitor;

public class MemoryComponent extends AbstractComponent {
    @Override
    void accept(Visitor visitor) {
        visitor.visitorMemory(this);
    }

    @Override
    int getPrice() {
        return 11;
    }
}
