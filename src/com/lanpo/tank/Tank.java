package com.lanpo.tank;

import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class Tank {
    private int x = 200,y = 200;

    DirEnum dir = DirEnum.DOWN;
    private final static int SPEED = 5;
    private boolean moving = false;

    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirEnum getDir() {
        return dir;
    }

    public void setDir(DirEnum dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, DirEnum dir, boolean moving, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = moving;
        this.tf = tf;
    }

    public void paint(Graphics g){
//        System.out.println("paint");
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x,y,50,50);
        g.setColor(c);
        move();
    }
    private void move(){
        if(!moving) return;
        switch (dir){
            case LEFT:
                x = x - SPEED <= 0 ? 0 : x - SPEED;
                break;
            case RIGHT:
                x = x + SPEED >=850 ? 850 : x + SPEED;
                break;
            case UP:
                y = y -SPEED <=0 ? 0 : y - SPEED;
                break;
            case DOWN:
                y = y + SPEED >=550 ? 550 : y + SPEED;
                break;
            default:
                break;
        }
    }

    public void fire(){
       tf.bullets.add(new Bullet(this.x+23, this.y+23, this.dir, tf));
    }


}
