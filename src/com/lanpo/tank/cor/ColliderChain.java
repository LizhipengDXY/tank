package com.lanpo.tank.cor;

import com.lanpo.tank.GameObject;
import com.lanpo.tank.PropertyMgr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author li zhipeng
 * @date 2021/5/31
 * @Description:
 */
public class ColliderChain implements Collider{
    private List<Collider> colliders = new LinkedList<>();
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ColliderChain(){
/*        String s = properties.get("colliders").toString();
        String[] str = s.split(",");
        for (int i = 0; i < str.length; i++) {
            try {
                Class c = Class.forName(str[i]);
                add((Collider) c.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }*/
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1,o2)){
                return false;
            }
        }
        return true;
    }
}
