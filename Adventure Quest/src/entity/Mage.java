package entity;

import main.GamePanel;
import main.KeyHandler;
import main.util.Assets;   // ✅ 统一资源加载
import java.io.IOException;

public class Mage extends Hero {

    public Mage(GamePanel gp, KeyHandler keyH, String name, int attackPower, int hp) throws IOException {
        super(gp, keyH, name, attackPower, hp, "Mage");
        getPlayerImage();
    }

    @Override
    public void getPlayerImage() {
        try {
            downImage  = Assets.img("/player/mage_down.png");
            upImage    = Assets.img("/player/mage_up.png");
            leftImage  = Assets.img("/player/mage_left.png");
            rightImage = Assets.img("/player/mage_right.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
