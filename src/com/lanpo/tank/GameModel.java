package com.lanpo.tank;

import com.lanpo.tank.cor.BulletTankCollider;
import com.lanpo.tank.cor.Collider;
import com.lanpo.tank.cor.ColliderChain;
import com.lanpo.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li zhipeng
 * @date 2021/5/27
 * @Description:
 */
public class GameModel {

    private final static GameModel INSTANCE = new GameModel();

     Tank myTank;
/*    public List<Bullet> bullets = new ArrayList<>();

    public List<Tank> tanks = new ArrayList<>();

    public List<Explode> explodes = new ArrayList<>();*/

    ColliderChain colliderChain = new ColliderChain();

    public static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;

    List<GameObject> objects = new ArrayList<>();

    private GameModel(){
        int initTankCount = Integer.parseInt((String) PropertyMgr.getKey("initTankCount"));
        System.out.println("miantank:");
        myTank = new Tank(550,500,DirEnum.DOWN,Group.GOOD);
     /*   //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            add(new Tank(50+i*100,200,DirEnum.DOWN,Group.BAD));
        }*/
        //初始化墙
        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));
        add(new Wall(550,300,50,200));

    }

    public static GameModel getInstance(){
        return INSTANCE;
    }

    public void add(GameObject go){
        this.objects.add(go);
    }

    public void remove(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g){
//        System.out.println("paint");
        Color color = g.getColor();
        g.setColor(Color.RED);
 /*       g.drawString("子弹的数量"+bullets.size(),10,60);
        g.drawString("敌人的数量"+tanks.size(),10,90);
        g.drawString("敌人的数量"+explodes.size(),10,120);*/
        g.drawString("子弹的数量"+objects.size(),10,60);
        g.setColor(color);
         myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }


        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1,o2);
            }
        }
/*        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        for(int i = 0; i < bullets.size(); i++){

            for(int j = 0; j < tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }*/
    }


    public Tank getMainTank() {
        return myTank;
    }
}
