package com.lanpo.tank.cor;

import com.lanpo.tank.GameObject;

/**
 * @author li zhipeng
 * @date 2021/5/31
 * @Description:
 */
public interface Collider {
    void collide(GameObject o1, GameObject o2);
}
