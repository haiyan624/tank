package wq.tank.observer;

import wq.tank.Tank;

public interface IEvent {
    Tank getSource();
}
