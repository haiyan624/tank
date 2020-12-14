package wq.dp.observe;

import java.util.ArrayList;
import java.util.List;

public class Child {
    List<IListener> listenerList = new ArrayList<>();
    public Child(){
        addListener(new MyListener1());
        addListener(new MyListener2());
    }
    public void cry(){
        System.out.println("cryyyyyyyyyyyyy");
        for (IListener iListener : listenerList) {
            iListener.fireListener(new MyEvent<Child>(this));
        }
    }
    public void addListener(IListener listener){
        listenerList.add(listener);
    }
}
