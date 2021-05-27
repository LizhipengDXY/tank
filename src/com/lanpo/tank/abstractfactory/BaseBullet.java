package com.lanpo.tank.abstractfactory;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
