package wq.tank.observer;

import wq.tank.Tank;

public class TankEvent implements IEvent{
    private Tank source;
    public TankEvent(Tank source){
        this.source=source;
    }
    public Tank getSource(){
        return  source;
    }
}
