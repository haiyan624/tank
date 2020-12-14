package wq.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public MyFrame() {
        this.setVisible(true);
        this.setTitle("MyTitle");
        this.setResizable(false);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        GameModel.getInstance().paint(g);
    }

    private class MyKeyListener extends KeyAdapter {
        boolean bR, bL, bU, bD;

        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
            }
            setMainDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    GameModel.getInstance().getMainTank().handleFire();
            }
            setMainDir();
        }

        private void setMainDir() {
            Tank mainTank = GameModel.getInstance().getMainTank();
            if (!bL && !bR && !bU && !bD) {
                mainTank.setMove(false);
            } else {
                mainTank.setMove(true);
                if (bL) mainTank.setDir(Dir.Left);
                if (bR) mainTank.setDir(Dir.Right);
                if (bU) mainTank.setDir(Dir.Up);
                if (bD) mainTank.setDir(Dir.Down);
            }
        }
    }
}
