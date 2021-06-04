package com.lanpo.tank;


import java.awt.*;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class Bullet extends GameObject{
    private static final int SPEED = 7;
    private int x,y;
    private DirEnum dir;
    public final static int weight = ResourceMgr.bulletD.getWidth();
    public final static int height = ResourceMgr.bulletD.getHeight();

    public Rectangle rect = new Rectangle();

    private boolean live = true;
    public Group group = Group.BAD;


    public Bullet(int x, int y, DirEnum dir,Group group) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = weight;
        rect.height = height;

        GameModel.getInstance().add(this);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void paint(Graphics g){
        if(!live) GameModel.getInstance().remove(this);
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

        rect.x = x;
        rect.y = y;

        if(x < 0 || x > GameModel.getInstance().GAME_WIDTH || y < 0 ||y > GameModel.getInstance().GAME_HEIGHT) live = false;

    }

    public void die(){
        this.live = false;
    }


}
