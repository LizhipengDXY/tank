package com.lanpo.tank.decorator;

import com.lanpo.tank.GameObject;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/6/16
 * @Description:
 */
public abstract class GODecorator extends GameObject {
    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);
    }
}
