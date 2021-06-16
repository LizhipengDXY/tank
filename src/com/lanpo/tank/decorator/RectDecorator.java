package com.lanpo.tank.decorator;

import com.lanpo.tank.GameObject;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/6/16
 * @Description:
 */
public class RectDecorator extends GODecorator{
    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        System.out.println("x,y = " + x + y);
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(super.go.x,super.go.y,getWidth()+10,getHeight()+10);
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