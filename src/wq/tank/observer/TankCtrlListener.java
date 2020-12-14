package wq.tank.observer;

import wq.tank.Tank;

public class TankCtrlListener implements IListener {
    public void fireListener(IEvent e){
        Tank source = e.getSource();
        source.fire();
    }
}
