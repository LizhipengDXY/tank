package com.lanpo.tank;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class Explode {

    private int x,y;

    public final static int weight = ResourceMgr.bulletD.getWidth();
    public final static int height = ResourceMgr.bulletD.getHeight();
    private TankFrame tf = null;
    private boolean living = true;

    private int step =0;


    public Explode(int x, int y,TankFrame tf) {

        this.x = x;
        this.y = y;

        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step > ResourceMgr.explodes.length-1)
            tf.explodes.remove(this);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
