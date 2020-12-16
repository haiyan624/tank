package wq.dp.cor.servlet;

public class Filter2 implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("before Filter2");
//        System.out.println("2 不让走到三了");
        filterChain.doFilter(request,response);
        System.out.println("after Filter2");

    }
}
