package jp.ac.uryukyu.ie.e165748;

/**
 * Created by e165748 on 12/29/16.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;


    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    public void setDead(boolean dead ) {this.dead = dead;}
    public void setName(String name) {this.name = name;}
    public void setAttack(int attack){this.attack = attack;}
    public void setHitPoint(int hitPoint) {this.hitPoint = hitPoint;}

    public  boolean isDead(){return this.dead;}

    public String getName(){
        return this.name;
    }

    public int getAttack(){
        return attack;
    }

    public int getHitPoint(){
        return hitPoint;
    }



    //public  void  ddead(boolean dead){
    //this.dead = dead;
    //}

    //public void Fall(){}



    /**
     * 攻撃対象へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、.wounded()によりダメージ処理を実行。
     * @param
     **/
    public void attack (LivingThing opponent) {
        int damage;
        if (dead == false) {
            damage = (int)(Math.random()*attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！\n",name,opponent.getName(),damage);
            opponent.wounded(damage);
        }

    }
    //public abstract int attacksistem(int damage,LivingThing opponent);

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            //Fall();
        }
    }
}
