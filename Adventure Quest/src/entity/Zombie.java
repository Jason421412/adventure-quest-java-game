package entity;

import main.util.Assets;   // ✅ 引入资源加载工具类
import java.io.IOException;

public class Zombie extends Monster {
    public Zombie(int hp, int attackPower) {
        super("Zombie", 60 + hp, 30 + attackPower); // type, HP, attackPower
        getMonsterImage();
    }

    @Override
    public void getMonsterImage() {
        try {
            leftImage  = Assets.img("/image/zombie_left.png");
            rightImage = Assets.img("/image/zombie_right.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
