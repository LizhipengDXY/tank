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
    public final static int weight = ResourceMgr.bulletD.getWidth();
    public final static int height = ResourceMgr.bulletD.getHeight();
    private TankFrame tf = null;
    private boolean live = true;
    private Group group = Group.BAD;

    public Bullet(int x, int y, DirEnum dir,Group group, TankFrame tf) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!live) tf.bullets.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }
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

    private void die(){
        this.live = false;
    }

    public boolean collideWith(Tank tank){
        if(this.group == tank.getGroup()) return false;
        Rectangle rectangle = new Rectangle(this.x, this.y, weight, height);
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.Width, Tank.Height);

        if(rectangle.intersects(rectangle2)){
            System.out.println("TRUE");
            tank.die();
            this.die();
            return true;

        }
        return false;
    }
}
