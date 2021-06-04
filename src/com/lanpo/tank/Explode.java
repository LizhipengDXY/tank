package com.lanpo.tank;



import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class Explode extends GameObject{

    private int x,y;

    public final static int weight = ResourceMgr.bulletD.getWidth();
    public final static int height = ResourceMgr.bulletD.getHeight();
    private boolean living = true;

    private int step =0;


    public Explode(int x, int y) {

        this.x = x;
        this.y = y;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
        GameModel.getInstance().add(this);
    }


    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step > ResourceMgr.explodes.length-1)
            GameModel.getInstance().remove(this);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
