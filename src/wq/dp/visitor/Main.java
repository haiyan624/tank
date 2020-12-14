package wq.dp.visitor;

public class Main {
    public static void main(String[] args) {
        Visitor p = new PeopleVisitor();
        Computer computer = new Computer();
        computer.accept(p);
        System.out.println(p.getTotalPrice());
        CorpVisitor c = new CorpVisitor();
        computer.accept(c);
        System.out.println(c.getTotalPrice());


    }
}
