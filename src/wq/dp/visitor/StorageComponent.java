package wq.dp.visitor;

public class StorageComponent extends AbstractComponent {
    @Override
    void accept(Visitor visitor) {
        visitor.visitorStorage(this);
    }

    @Override
    int getPrice() {
        return 3;
    }
}
