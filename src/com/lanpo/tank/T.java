package com.lanpo.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i *100,200,DirEnum.DOWN,Group.BAD,tf));
        }
        
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
