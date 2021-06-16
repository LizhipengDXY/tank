package com.lanpo.tank.strategy;


import com.lanpo.tank.*;
import com.lanpo.tank.decorator.RectDecorator;
import com.lanpo.tank.decorator.TailDecorator;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x +Tank.Width/2 - Bullet.weight/2;
        int bY = t.y + Tank.Height/2 - Bullet.height/2;
        // 有些问题
        GameModel.getInstance().add(
                new RectDecorator(
                        new TailDecorator(
                        new Bullet(bX,bY,t.dir,t.group))));

        if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
     }
}
