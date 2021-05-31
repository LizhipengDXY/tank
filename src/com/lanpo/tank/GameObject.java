package com.lanpo.tank;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/27
 * @Description:
 */
public abstract class GameObject {
    int x,y;

    protected GameObject() {
    }

    public abstract void paint(Graphics g);

}
