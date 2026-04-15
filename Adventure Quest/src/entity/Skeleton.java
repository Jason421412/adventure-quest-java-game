package entity;

import main.util.Assets;   // ✅ 新增：统一从 resources 读取图片
import java.io.IOException;

public class Skeleton extends Monster {
    public Skeleton(int hp, int attackPower) {
        super("Skeleton", 50 + hp, 20 + attackPower); // type, HP, attackPower
        getMonsterImage();
    }

    @Override
    public void getMonsterImage() {
        try {
            leftImage  = Assets.img("/image/skeleton1.png");
            rightImage = Assets.img("/image/skeleton2.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
