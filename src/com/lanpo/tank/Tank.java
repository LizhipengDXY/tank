package com.lanpo.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class Tank {
    private int x = 200,y = 200;

    public static int Width = ResourceMgr.tankD.getWidth();
    public static int Height = ResourceMgr.tankD.getHeight();

    DirEnum dir = DirEnum.DOWN;
    private final static int SPEED = 5;
    private boolean moving = true;

    private boolean living = true;

    private Random random = new Random();

    private Group group = Group.BAD;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Tank(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
//        System.out.println("paint");
        if(!living) tf.tanks.remove(this);

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
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


        if(this.group == Group.BAD && random.nextInt(10)>8) {
            this.fire();
            int i = new Random().nextInt(5);
            System.out.println("i: "+i);
            switch (i){
                case 1:
                    this.dir = DirEnum.LEFT;
                    break;
                case 2:
                    this.dir = DirEnum.RIGHT;
                    break;
                case 3:
                    this.dir = DirEnum.UP;
                    break;
                case 4:
                    this.dir = DirEnum.DOWN;
                    break;
                default:
                    break;
            }
        }
    }

    public void fire(){
        int xl = x + Width/2 - Bullet.weight/2;
        int yl = y + Height/2 - Bullet.height/2;
       tf.bullets.add(new Bullet(xl,yl, this.dir,this.group, tf));
    }

    public void die(){
        this.living = false;
    }

}
