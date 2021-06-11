package com.lanpo.tank.cor;

import com.lanpo.tank.*;

/**
 * @author li zhipeng
 * @date 2021/5/31
 * @Description:
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            //TODO copy code from method collideWith
            if(b.group == t.group) return false;

            if(b.getRect().intersects(t.getRect())){
                if(t.group == Group.BAD){
                    t.die();
                    b.die();
                }
                int eX = t.getX() + Tank.Width/2 - Explode.weight/2;
                int eY = t.getY() + Tank.Height/2 - Explode.height/2;
                new Explode(eX,eY);
                return true;
            }
            return false;
        }else if(o1 instanceof Tank  && o2 instanceof  Bullet){
           return collide(o2, o1);
        }
        return true;
    }
}
