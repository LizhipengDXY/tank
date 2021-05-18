package com.lanpo.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,100,DirEnum.DOWN,Group.GOOD,this);
    List<Bullet> bullets = new ArrayList<>();

    List<Tank> tanks = new ArrayList<>();

    List<Explode> explodes = new ArrayList<>();


    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank world");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);

    }

    @Override
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

    class MyKeyListener extends KeyAdapter{
        boolean BL = false, BR = false, BU = false, BD = false;
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = true;
                    break;
                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = false;
                    break;
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir(){
            if(!BU && !BD && !BR && !BL){
                myTank.setMoving(false);
            }
            else {
                myTank.setMoving(true);
                if(BL) myTank.setDir(DirEnum.LEFT);
                if(BR) myTank.setDir(DirEnum.RIGHT);
                if(BU) myTank.setDir(DirEnum.UP);
                if(BD) myTank.setDir(DirEnum.DOWN);
            }



        }
    }
}
