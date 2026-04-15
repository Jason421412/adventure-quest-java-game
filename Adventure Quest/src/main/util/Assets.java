package main.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public final class Assets {
    private Assets() {}

    /** 从 classpath 读取图片。resourcePath 一定以 “/” 开头，例如：/image/dungeon1.jpg */
    public static BufferedImage img(String resourcePath) throws java.io.IOException {
        try (InputStream is = Assets.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new java.io.IOException("Resource not found: " + resourcePath);
            }
            return ImageIO.read(is);
        }
    }
}
