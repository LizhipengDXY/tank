package com.lanpo.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author li zhipeng
 * @date 2021/5/14
 * @Description:
 */
public class ResourceMgr {
    public static BufferedImage goodTankU,goodTankR,goodTankD,goodTankL;
    public static BufferedImage badTankU,badTankR,badTankD,badTankL;
    public static BufferedImage bulletL,bulletU,bulletR,bulletD;

    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GooDTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            goodTankL= ImageUtil.rotateImage(goodTankU,270);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankL= ImageUtil.rotateImage(badTankU,270);

            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletR= ImageUtil.rotateImage(bulletU,90);
            bulletD= ImageUtil.rotateImage(bulletU,180);
            bulletL= ImageUtil.rotateImage(bulletU,270);

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
