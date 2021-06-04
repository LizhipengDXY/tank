package com.lanpo.tank.cor;

import com.lanpo.tank.GameObject;
import com.lanpo.tank.Group;
import com.lanpo.tank.Tank;
import com.lanpo.tank.Wall;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li zhipeng
 * @date 2021/6/4
 * @Description:
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;

            if(t.rect.intersects(w.rect)){
                t.back();
            }

        }
        else if(o1 instanceof Wall && o2 instanceof Tank){
           return collide(o2,o1);
        }
        return true;
    }
}
