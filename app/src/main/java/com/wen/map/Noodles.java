package com.wen.map;

public class Noodles extends Thread {

    public static final int DIERCTION_NONE = -1;
    public static final int DIERCTION_RIGHT = 0;
    public static final int DIERCTION_LEFT = 1;
    public static final int DIERCTION_DOWN = 2;
    public static final int DIERCTION_UP = 3;
    public static final int DIERCTION_NG = 9;
    private final GameView gameView;
    int x = 0;
    int y = 0;
    int direction = DIERCTION_NONE;

    public Noodles(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void run() {
        while (direction != DIERCTION_NONE && direction != DIERCTION_NG) {
            switch (direction) {
                case DIERCTION_RIGHT:
                    if (x < gameView.getWidth()-230) {
                        x += 50;
                    } else {
                        direction = DIERCTION_NG;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case DIERCTION_LEFT:
                    if (x > 50) {
                        x -= 50;
                    } else {
                        direction = DIERCTION_NG;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case DIERCTION_DOWN:
                    if (y < gameView.getHeight()-230) {
                        y += 50;
                    } else {
                        direction = DIERCTION_NG;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case DIERCTION_UP:
                    if (y > 50) {
                        y -= 50;
                    } else {
                        direction = DIERCTION_NG;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (this.direction == DIERCTION_NONE) {
            start();
        }
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
