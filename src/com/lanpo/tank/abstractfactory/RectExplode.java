package com.lanpo.tank.abstractfactory;

import com.lanpo.tank.Audio;
import com.lanpo.tank.ResourceMgr;
import com.lanpo.tank.TankFrame;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public class RectExplode extends BaseExplode{
    private int x,y;

    public final static int weight = ResourceMgr.bulletD.getWidth();
    public final static int height = ResourceMgr.bulletD.getHeight();
    private TankFrame tf = null;

    private int step =0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        step++;
        if(step >= 5){
            tf.explodes.remove(this);
        }

        g.setColor(c);
    }
}
