public abstract class Character {
    public int maxHp;
    public  int xp,hp;
    public String name;

    //fonction de tout les personnages
    public Character(String name, int maxHp,int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp=xp;
    }



    public  int getHp(){return hp;}
    public abstract  int attack();

    public abstract int defend();
    // public abstract int defend();
    public String getName(){return name;}
    public int getXp(){return xp;}
    public void setHp(int i){this.hp=i;}

}
