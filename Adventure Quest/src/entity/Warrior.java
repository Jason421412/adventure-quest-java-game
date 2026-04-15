package entity;

import main.GamePanel;
import main.KeyHandler;
import main.util.Assets;   // ✅ 统一资源加载方式
import java.io.IOException;

public class Warrior extends Hero {

    public Warrior(GamePanel gp, KeyHandler keyH, String name, int attackPower, int hp) throws IOException {
        super(gp, keyH, name, attackPower, hp, "Warrior");
        getPlayerImage();
    }

    @Override
    public void getPlayerImage() {
        try {
            downImage  = Assets.img("/player/warrior_down.png");
            upImage    = Assets.img("/player/warrior_up.png");
            leftImage  = Assets.img("/player/warrior_left.png");
            rightImage = Assets.img("/player/warrior_right.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
