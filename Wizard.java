import java.lang.String;

public class Wizard extends Character {
    public String name;
    public static int nbr_de_potion=3;
    public int xp;
    Game game= new Game();
    Pet pet;
    int wand;
    String house;

    public Wizard(String name, int maxHp,int xp, String house, Pet pet, int wand) {
        super(name, maxHp,xp);
        this.house = house;
        this.pet = pet;
        this.wand = wand;

    }


    @Override
    public int attack() {

        int finalDamage;
        int damage = game.Choose_spell();

        if(Execution.wizard.house.equals("Slytherin"))
        {
            finalDamage = damage + 5;
            return finalDamage;
        }else
            finalDamage = damage;
        return finalDamage ;
    }
    public double getLuck() {
        return Math.random();
    }
    public boolean isAlive() {
        return hp > 0;
    }
    //Votre objectif est de la distraire le temps que les feux d’artifice soient prêts à être utilisés.
    @Override
    public int defend() {
        // calcul de la probabilité de défense en fonction de la chance du sorcier
        double defenseProbability = 0.5 + this.getLuck() / 20.0;

        // génération d'un nombre aléatoire entre 0 et 1 pour déterminer si le sorcier réussit à esquiver l'attaque
        double random = Math.random();

        if (random < defenseProbability) {
            System.out.println("You successfully defended against the attack!\n");
            return 0; // aucun dégât n'est infligé
        } else {
            System.out.println("You failed to defend against the attack!\n");
            if (Execution.wizard.house.equals("Gryffindor")) {
                return 1; // 10 points de dégâts sont infligés
            } else return 2;
        }
    }

    public static int distraireEnnemi() {
        int dureeMillis=15000;
        System.out.println("The wizard distract ennemy during " + (dureeMillis / 1000) + " secondes...");
        try {
            Thread.sleep(dureeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The distraction is over !");
        int firework;
        firework=Execution.firework+1;
        return firework;
    }
    public static int prepare_firework() {
        int dureeMillis=5000;
        int firework;
        firework=Execution.firework+2;
        try {
            Thread.sleep(dureeMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return firework;
    }
}


