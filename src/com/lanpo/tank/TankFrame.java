package com.lanpo.tank;



import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 * @author li zhipeng
 * @date 2021/5/12
 */
public class TankFrame extends Frame {
//qie huan fen zhi
    GameModel gm = GameModel.getInstance();



    public TankFrame(){
        this.setSize(gm.GAME_WIDTH,gm.GAME_HEIGHT);
        setResizable(false);
        setTitle("tank world");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(gm.GAME_WIDTH, gm.GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,gm.GAME_WIDTH,gm.GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);

    }

    @Override
    public void paint(Graphics g){
        gm.paint(g);
    }

    class MyKeyListener extends KeyAdapter{
        boolean BL = false, BR = false, BU = false, BD = false;
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = true;
                    break;
                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    gm.getMainTank().fire();
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = false;
                    break;
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    gm.getMainTank().fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir(){
            Tank myTank = gm.getMainTank();
            if(!BU && !BD && !BR && !BL){
                myTank.setMoving(false);
            }
            else {
                myTank.setMoving(true);
                if(BL) myTank.setDir(DirEnum.LEFT);
                if(BR) myTank.setDir(DirEnum.RIGHT);
                if(BU) myTank.setDir(DirEnum.UP);
                if(BD) myTank.setDir(DirEnum.DOWN);
            }



        }
    }
}
