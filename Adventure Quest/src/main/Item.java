package main;

import main.util.Assets;               // ✅ 统一从 resources 加载
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

public class Item { // 物品类 / Item
    // Attributes
    private String name;
    private int x;
    private int y;
    private BufferedImage itemImage;

    // 构造：保持原签名不变（兼容现有代码）
    public Item(JPanel gp, String name) throws IOException {
        this.name = name;
        direction();            // 随机生成位置
        loadItemImageOnce();    // ✅ 只加载一次，避免每帧 IO
    }

    // === Getters / Setters ===
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
        try { loadItemImageOnce(); } catch (IOException ignored) {}
    }
    public int getY() { return y; }
    public int getX() { return x; }
    public void setY(int y) { this.y = y; }
    public void setX(int x) { this.x = x; }
    public BufferedImage getItemImage() { return itemImage; }
    public void setItemImage(BufferedImage itemImage) { this.itemImage = itemImage; }

    // 随机生成物品位置
    public void direction() {
        Random r = new Random();
        this.x = r.nextInt(GamePanel.SCREEN_WIDTH - 50);
        this.y = r.nextInt(GamePanel.SCREEN_HEIGHT - 50);
    }

    // ✅ 资源化加载（只在构造/改名时加载一次）
    private void loadItemImageOnce() throws IOException {
        if (name == null) return;
        switch (name) {
            case "axe":
                itemImage = Assets.img("/image/axe.png");
                break;
            case "dagger":
                itemImage = Assets.img("/image/dagger.png");
                break;
            case "potion":
                itemImage = Assets.img("/image/potion.png");
                break;
            default:
                System.out.println("Unknown item: " + name);
                itemImage = null;
        }
    }

    // 绘制（不再每帧读文件）
    public void draw(Graphics2D g) {
        if (itemImage != null) {
            g.drawImage(itemImage, x, y, null);
        }
    }
}
