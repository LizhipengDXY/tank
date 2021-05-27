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

    Rectangle rect = new Rectangle();

    private boolean live = true;
    public Group group = Group.BAD;

    GameModel gm = null;

    public Bullet(int x, int y, DirEnum dir,Group group, GameModel gm) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = weight;
        rect.height = height;

        gm.bullets.add(this);
    }

    public void paint(Graphics g){
        if(!live) gm.bullets.remove(this);
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

        if(x < 0 || x > gm.GAME_WIDTH || y < 0 ||y > gm.GAME_HEIGHT) live = false;

    }

    private void die(){
        this.live = false;
    }

    public void collideWith(Tank tank){
        if(this.group == tank.group) return;

        if(rect.intersects(tank.rect)){
//            System.out.println("TRUE");
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.Width/2 - Explode.weight/2;
            int eY = tank.getY() + Tank.Height/2 - Explode.height/2;
            gm.explodes.add(new Explode(eX,eY,gm));

        }

    }
}
