package com.lanpo.tank.cor;

import com.lanpo.tank.Bullet;
import com.lanpo.tank.GameObject;
import com.lanpo.tank.Tank;

/**
 * @author li zhipeng
 * @date 2021/5/31
 * @Description:
 */
public class BulletTankCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            b.collideWith(t);
        }else if(o1 instanceof Tank  && o2 instanceof  Bullet){
            collide(o2, o1);
        }else {
            return;
        }
    }
}
