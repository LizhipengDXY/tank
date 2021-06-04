package com.lanpo.tank;

import com.lanpo.tank.cor.ColliderChain;

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


        
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
