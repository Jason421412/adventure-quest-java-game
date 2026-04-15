package main;

import entity.*;
import java.awt.image.BufferedImage;

public class Room {
    private Monster[] monsters;
    private Item item;
    private Hero hero;
    private BufferedImage backgroundImage;

    public Room(Monster[] monsters, Item item, BufferedImage backgroundImage){
        this.monsters = monsters;
        this.item = item;
        this.backgroundImage = backgroundImage;
    }

    /** 批量设置当前房间的怪物数组 */
    public void setMonsters(Monster[] monsters){
        this.monsters = monsters;
    }

    /** 向房间里添加一个怪物（找到第一个空位） */
    public void addMonster(Monster monster){
        if (monster == null) return;
        if (monsters == null || monsters.length == 0) {
            this.monsters = new Monster[]{ monster };
            return;
        }
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i] == null) {
                monsters[i] = monster;
                return;
            }
        }
        // 如果没有空位，可以选择扩容（可选）
        // Monster[] newArr = Arrays.copyOf(monsters, monsters.length + 1);
        // newArr[newArr.length - 1] = monster;
        // monsters = newArr;
    }

    public Monster[] getMonsters(){
        return monsters;
    }

    public void removeMonster(Monster monster) {
        if (monsters == null) return;
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i] == monster) {
                monsters[i] = null;
                break;
            }
        }
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public Hero getHero(){
        return hero;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void updateMonsters(long currentTime) {
        if (monsters == null) return;
        for (Monster monster : monsters) {
            if (monster != null) {
                monster.update(currentTime);
            }
        }
    }
}
