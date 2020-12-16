package wq.dp.cor.servlet;

public class Main {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.add(new Filter1());
        chain.add(new Filter2());
        chain.add(new Filter3());
        chain.doFilter(new Request(),new Response());
    }
}
