package com.lanpo.tank;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private DirEnum dir;
    private final static int weight = 15,height = 15;
    private TankFrame tf = null;
    private boolean live = true;

    public Bullet(int x, int y, DirEnum dir, TankFrame tf) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!live) tf.bullets.remove(this);
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,weight,height);

        g.setColor(c);
        move();
    }

    private void move(){
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if(x < 0 || x > 800 || y < 0 ||y > 600) live = false;

    }
}
