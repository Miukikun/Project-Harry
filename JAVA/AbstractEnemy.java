public abstract class AbstractEnemy extends Character{

    public AbstractEnemy(String name, int maxHp,int xp){
        super(name, maxHp, xp);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }


}
