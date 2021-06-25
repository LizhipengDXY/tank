package com.lanpo.tank.observer;

import com.lanpo.tank.T;
import com.lanpo.tank.Tank;

/**
 * @author li zhipeng
 * @date 2021/6/21
 * @Description:
 */
public class TankFireEvent {
    Tank tank;

    public Tank getSource() {
        return tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

}
