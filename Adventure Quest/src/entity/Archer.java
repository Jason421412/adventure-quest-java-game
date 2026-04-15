package entity;

import main.GamePanel;
import main.KeyHandler;
import main.util.Assets;   // ✅ 使用统一资源加载类
import java.io.IOException;

public class Archer extends Hero {

    public Archer(GamePanel gp, KeyHandler keyH, String name, int attackPower, int hp) throws IOException {
        super(gp, keyH, name, attackPower, hp, "Archer");
        getPlayerImage();
    }

    @Override
    public void getPlayerImage() {
        try {
            downImage  = Assets.img("/player/archer_down.png");
            upImage    = Assets.img("/player/archer_up.png");
            leftImage  = Assets.img("/player/archer_left.png");
            rightImage = Assets.img("/player/archer_right.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
