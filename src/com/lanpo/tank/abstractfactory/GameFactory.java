package com.lanpo.tank.abstractfactory;

import com.lanpo.tank.DirEnum;
import com.lanpo.tank.Group;
import com.lanpo.tank.TankFrame;

/**
 * @author li zhipeng
 * @date 2021/5/24
 * @Description:
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, DirEnum dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y,DirEnum dir, Group group, TankFrame tf);
}
