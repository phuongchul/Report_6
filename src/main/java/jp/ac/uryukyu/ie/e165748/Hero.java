/**
 * Created by e165748 on 12/29/16.
 */
package jp.ac.uryukyu.ie.e165748;
public class Hero extends LivingThing {

    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void attack(LivingThing opponent) {
        int damage, rete;

        if (isDead() == false) {
            damage = (int) (Math.random() * getAttack());
            rete = (int) (Math.random() * 1000) / 3;
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            } else {
                if (rete <= 3) {
                    damage = damage * 2;
                    System.out.printf("%sの攻撃！会心の一撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                opponent.wounded(damage);
            }
        }
    }


    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() <= 0) {
            setDead(true);
            System.out.println("勇者は道半で力切尽きてしまった。\n ");
        }
    }
}