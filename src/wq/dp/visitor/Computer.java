package wq.dp.visitor;

public class Computer {
    private AbstractComponent cpu = new CpuComponent();
    private AbstractComponent memory = new MemoryComponent();
    private AbstractComponent storage = new StorageComponent();

    void accept(Visitor v){
        cpu.accept(v);
        memory.accept(v);
        storage.accept(v);
    }
}
