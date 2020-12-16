package wq.dp.cor.servlet;

public class Filter3 implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("before Filter3");
        filterChain.doFilter(request,response);
        System.out.println("after Filter3");

    }
}
