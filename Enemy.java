public class Enemy extends AbstractEnemy{

    public int hp;
    public int xp;
    String name;
    public Enemy(String name, int maxHp,int xp)
    {
        super(name, maxHp, xp);
        this.xp=xp;
        this.hp=maxHp;
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public  int getHp(){return hp;}
    public int ennemy_choose_speel(){
        int damage = 0;
        if (Math.random() < 0.3){
            System.out.println("Your ennemy use Wingardium Leviosa. \n");
            damage=15;
        }else if(Math.random() > 0.3 && Math.random() <0.7){
            System.out.println("Your ennemy use accio.. \n");
            damage=20;
        }else if(Math.random() > 0.7 && Math.random() <0.9){
            System.out.println("Your ennemy use expelliarmus \n");
            damage=30;
        }
        return damage;
    }
    @Override
    public int attack() {
        Execution myExc= new Execution();
        int damage = 0;
        if((myExc.level == 1 )||(myExc.level == 2)  || (myExc.level ==3)){
        damage = (int)(Math.random() * 30) + 1;}
        
        else if( (myExc.level == 4 )||(myExc.level == 5)  || (myExc.level ==6)){
            if((Execution.enemy.name=="Voldemort")){
                damage = ennemy_choose_speel()+25;
            }else
                damage = ennemy_choose_speel();
        }
        else if (myExc.level ==7){
              if(Math.random() > 0.9){
                damage =(Execution.wizard.getHp()) ;
                System.out.println("Your ennemy use Avada Kedavra \n");
            }else{
            if((Execution.enemy.getName()=="Voldemort")){
                damage = ennemy_choose_speel()+25;
            }else
                damage = ennemy_choose_speel();
        }
    }return damage;}

    @Override
    public int defend() {
        int damage;
        if(Execution.wizard.house.equals("Ravenclaw")){
        if (Math.random() > 0.8) {
           damage = 0;
        } else {
            damage = 1;
        }
            return damage;
        }else
            if (Math.random() > 0.6) {
                damage = 0;
                return damage;
            } else {
                damage = 1;
                return damage;
            }
    }
    public void setHp (int newHp){
            this.hp = newHp;
        }
    public static int verifierPreparationFeuArtifice(boolean preparationEnCours) {
        int dommages = 0;
        if (preparationEnCours==true) {

            if (Math.random() > 0.5) {
                 dommages = 25;}
            else{dommages = 0; }
            } else{
            System.out.println("Dolores : I don't know why did you call me but it feels like you are preparing something !");
        }
        return dommages;
    }
}





