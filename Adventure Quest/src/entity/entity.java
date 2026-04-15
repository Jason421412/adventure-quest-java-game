package entity;

import java.awt.image.BufferedImage;

/**
 * Base entity class for all movable game objects.
 * 所有可移动游戏对象的基类：英雄、怪物等。
 */
public class entity {
    // Position and movement
    protected int x;
    protected int y;
    protected int speed;

    // Direction and sprite images
    protected String direction;
    protected BufferedImage upImage, downImage, leftImage, rightImage;

    // === Getters / Setters ===
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
