package com.lanpo.tank;

import com.lanpo.tank.abstractfactory.BaseTank;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public interface FireStrategy {
    void fire(Tank t);
}
