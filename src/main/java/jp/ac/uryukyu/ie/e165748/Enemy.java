/**
 * Created by e165748 on 12/29/16.
 */
package jp.ac.uryukyu.ie.e165748;
public class Enemy extends LivingThing {
    private boolean dead;
    private int attack;

    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void attack(LivingThing opponent) {
        int damage;
        if (isDead() == false) {
            damage = (int) (Math.random() * getAttack());
            if (Math.random() > 0.2) {
                if (damage == 0) {
                    System.out.printf("%s の攻撃!,,,, だが、%sは攻撃を華麗にかわしたn ", getName(), opponent.getName());
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
            } else {
                damage = damage * 2;
                if (damage == 0) {
                    System.out.printf("%s　の攻撃!,,,,だが、%sは攻撃を華麗にかわした!\n", getName(), opponent.getName());
                } else {
                    System.out.printf("%sの攻撃！痛恨の一撃！%sに%dのダメージを与えた！n", getName(), opponent.getName(), damage);
                }
            }
        }
    }

    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() <= 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた！n",getName());
        }
    }
}



