package wq.dp.observe;

public class MyEvent<T> implements IEvent<T>{
    private T source;

    public MyEvent(T source) {
        this.source = source;
    }

    @Override
    public T getSource() {
        return source;
    }
}
