package com.lanpo.tank.decorator;

import com.lanpo.tank.GameObject;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/6/16
 * @Description:
 */
public class TailDecorator extends GODecorator{
    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine(super.go.x,super.go.y,super.go.x+getWidth(),super.go.y+getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
