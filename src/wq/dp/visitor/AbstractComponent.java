package wq.dp.visitor;

public abstract class AbstractComponent {
    abstract void accept(Visitor visitor);
    abstract int getPrice();
}
