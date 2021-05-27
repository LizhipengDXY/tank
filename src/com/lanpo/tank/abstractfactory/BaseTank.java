package com.lanpo.tank.abstractfactory;

import com.lanpo.tank.Group;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();
    public abstract void paint(Graphics g);


    public Group getGroup(){
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
