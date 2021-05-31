package com.lanpo.tank.cor;

import com.lanpo.tank.Bullet;
import com.lanpo.tank.GameObject;
import com.lanpo.tank.Tank;

/**
 * @author li zhipeng
 * @date 2021/5/31
 * @Description:
 */
public class TankTankCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
           if(t1.getRect().intersects(t2.getRect())){
               t1.stop();
               t2.stop();
           }
        }else {
            return;
        }
    }
}
