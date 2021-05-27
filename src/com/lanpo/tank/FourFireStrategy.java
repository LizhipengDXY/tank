package com.lanpo.tank;

import com.lanpo.tank.abstractfactory.BaseTank;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public class FourFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bX = t.x +Tank.Width/2 - Bullet.weight/2;
        int bY = t.y + Tank.Height/2 - Bullet.height/2;

        DirEnum[] dirs = DirEnum.values();
        for (DirEnum dir:dirs) {
            t.tf.gf.createBullet(bX,bY,dir,t.group,t.tf);
        }

        if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();



    }
}
