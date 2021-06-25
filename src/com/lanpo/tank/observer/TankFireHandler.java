package com.lanpo.tank.observer;

import com.lanpo.tank.Tank;

/**
 * @author li zhipeng
 * @date 2021/6/21
 * @Description:
 */
public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
