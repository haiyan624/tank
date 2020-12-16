package wq.dp.cor.servlet;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    int index;
    private List<Filter> list = new ArrayList<>();

    void doFilter(Request request, Response response) {
        if (index >= list.size()) {
            return;
        }
        list.get(index++).doFilter(request, response, this);
    }
    public void add(Filter filter){
        list.add(filter);
    }
}
