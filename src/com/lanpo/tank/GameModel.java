package com.lanpo.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li zhipeng
 * @date 2021/5/27
 * @Description:
 */
public class GameModel {



    Tank myTank = new Tank(200,100,DirEnum.DOWN,Group.GOOD,this);
    public List<Bullet> bullets = new ArrayList<>();

    public List<Tank> tanks = new ArrayList<>();

    public List<Explode> explodes = new ArrayList<>();

    public static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    public GameModel(){
        int initTankCount = Integer.parseInt((String) PropertyMgr.getKey("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tanks.add(new Tank(50+i*100,200,DirEnum.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g){
//        System.out.println("paint");
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawString("子弹的数量"+bullets.size(),10,60);
        g.drawString("敌人的数量"+tanks.size(),10,90);
        g.drawString("敌人的数量"+explodes.size(),10,120);
        g.setColor(color);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        for(int i = 0; i < bullets.size(); i++){

            for(int j = 0; j < tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }


    public Tank getMainTank() {
        return myTank;
    }
}
