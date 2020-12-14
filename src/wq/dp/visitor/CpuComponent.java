package wq.dp.visitor;

public class CpuComponent extends AbstractComponent {
    @Override
    void accept(Visitor visitor) {
        visitor.visitorCpu(this);
    }

    @Override
    int getPrice() {
        return 200;
    }
}
