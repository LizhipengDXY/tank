package com.lanpo.tank.abstractfactory;

import com.lanpo.tank.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class RectTank extends BaseTank {
    int x = 200,y = 200;

    public static int Width = ResourceMgr.badTankL.getWidth();
    public static int Height = ResourceMgr.badTankL.getHeight();

    DirEnum dir = DirEnum.DOWN;
    private final static int SPEED = 5;
    private boolean moving = true;


    private boolean living = true;

    private Random random = new Random();

    Group group = Group.BAD;

    FireStrategy fs;

    TankFrame tf = null;

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

    public RectTank(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = Width;
        rect.height = Height;

        if(group == Group.GOOD) {
            String goodFsName = (String) PropertyMgr.getKey("goodFs");


            try {
                fs = (FireStrategy) Class.forName(goodFsName).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
        else {
          fs = new DefaultFireStrategy();
        }
    }

    public void paint(Graphics g){
//        System.out.println("paint");
        if(!living) tf.tanks.remove(this);

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x,y,40,40);
        g.setColor(c);
        move();

    }

    private void randomDir(){
        int i = random.nextInt(4);
       // System.out.println("i: "+i);
        this.dir = DirEnum.values()[i];
    }

    private void boundsCheck(){
        if(x < 2) x = 2;
        if(y < 2) y = 2;
        if(x > TankFrame.GAME_WIDTH - RectTank.Width -2) x = TankFrame.GAME_WIDTH - RectTank.Width -2;
        if(y > TankFrame.GAME_HEIGHT - RectTank.Height -2) y = TankFrame.GAME_HEIGHT - RectTank.Height -2;
    }

    private void move(){
        if(!moving) return;
        switch (dir){
            case LEFT:
                //x = x - SPEED <= 0 ? 0 : x - SPEED;
                x -= SPEED;
                break;
            case RIGHT:
                //x = x + SPEED >=850 ? 850 : x + SPEED;
                x += SPEED;
                break;
            case UP:
                //y = y -SPEED <=0 ? 0 : y - SPEED;
                y -= SPEED;
                break;
            case DOWN:
                //y = y + SPEED >=550 ? 550 : y + SPEED;
                y += SPEED;
                break;
            default:
                break;
        }

        rect.x = x;
        rect.y = y;

        if(this.group == Group.BAD && random.nextInt(100)>95) {
            this.fire();
            //坦克随机移动
/*            int i = new Random().nextInt(5);
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
            }*/
        }
        if(this.group == Group.BAD && random.nextInt(100)>95){
            randomDir();
        }
        boundsCheck();


    }

    public void fire(){
      //  fs.fire(this);
        int bX = this.x +Tank.Width/2 - Bullet.weight/2;
        int bY = this.y + Tank.Height/2 - Bullet.height/2;

        DirEnum[] dirs = DirEnum.values();
        for (DirEnum dir:dirs) {
            this.tf.gf.createBullet(bX,bY,dir,this.group,this.tf);
        }

        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public void die(){
        this.living = false;
    }

}
