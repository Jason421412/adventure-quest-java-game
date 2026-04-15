package entity;

import main.util.Assets;   // ✅ 引入资源加载工具
import java.io.IOException;

public class Goblin extends Monster {
    public Goblin(int hp, int attackPower) {
        super("Goblin", 70 + hp, 40 + attackPower); // type, HP, attackPower
        getMonsterImage();
    }

    @Override
    public void getMonsterImage() {
        try {
            leftImage  = Assets.img("/image/goblin_left.png");
            rightImage = Assets.img("/image/goblin_right.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
