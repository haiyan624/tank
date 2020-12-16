package wq.dp.cor.servlet;

public class Filter1 implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("before Filter1");
        filterChain.doFilter(request,response);
        System.out.println("after Filter1");

    }
}
