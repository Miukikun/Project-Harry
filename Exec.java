import java.util.Objects;
import java.util.Scanner;
import java.lang.System;
import java.lang.String;
import java.util.Timer;
import java.util.TimerTask;




public class Exec {
    public static int result;
    Game game= new Game();
    House Hue= new House();
    Story story = new Story();
    static Scanner scanner = new Scanner(System.in);
    public static Wizard wizard;
    public static Enemy enemy,minion;
    public static int nbr_accio=0;
    public static int firework=0;
    public static String patronus;
    boolean go_with_voldemort=false;
    public static int place =0,level=1;
    public static String[] places ={"The philosopher's stone","The chamber of secret","The prisoner of azkaban", "The goblet of fire","The order of the phoenix","The half-blood prince","The deathly Hallows"};



    //methode pour commencer le jeu
    public void  startGame(){
        boolean nameSet = false;
        String name;
        // print title screen
        game.clearconsole();
        game.seperator(20);
        System.out.println(" RPG Harry Potter");
        System.out.println("BY CONSTANCE PERSAD");
        game.seperator(20);
        game.anythingtocontinue();

        do {
            game.clearconsole();
            game.Header("What's your name ?");
            name = scanner.next();
            //asking the player if he wants to correct his choice
            game.clearconsole();
            game. Header("Your name is " + name + ".\nIs that correct ?");
            System.out.println("(1) Yes !");
            System.out.println("(2) No i want to change my name !");
            int input = game.readInt("->", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);


        game.anythingtocontinue();

        wizard=new Wizard(name,100,0,Hue.your_house(),Pet.choosePet(), Wand.choose_wand());

        //setting isRunning to true so the game loop can continue
        game.isRunning =true;

        //start main game loop
        game.gameLoop();

        }
        //method to continue the journey


   public  void checkAct(){
        if( level==1){
            story.Thephilosopherstone_Intro();
            enemy = new Enemy("Troll", 30, 10);
            battle();
            story.Thephilosopherstone_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=2;
            place=1;
           wizard.xp=10;
            game.gameLoop();

        }else if(level==2){
            story.TheChamberOfSecret_Intro();
            enemy = new Enemy("Basilic", 30, 60);
            battle();
            story.TheChamberOfSecret_Outro();
            game.clearconsole();
            game. anythingtocontinue();
            level=3;
            place=2;
            wizard.xp=20;
            game.gameLoop();

        }else if(level==3){
             story.The_prisoner_of_azkaban_Intro();
             enemy = new Enemy("Dementor", 50,70 );
             patronus =Patronus.your_patronus();
             battle();
             story.The_prisoner_of_azkaban_Outro();
             game.clearconsole();
             game.anythingtocontinue();
             level=4;
             place=3;
            wizard.xp=30;
             game.gameLoop();

        }else if( level==4){
            story.The_goblet_of_fire_Intro();
            enemy = new Enemy("Voldemort", 45,20);
            minion = new Enemy("Peter Pettigrow", 30,70 );
            battle_level4();
            story.The_goblet_of_fire_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=5;
            place=4;
            wizard.xp=40;
            game.gameLoop();

        }else if(level==5){
            story.The_order_of_the_phoenix_Intro();
            enemy = new Enemy("Dolores Ombrage", 45,70 );
            battle_level5();
            story.The_order_of_the_phoenix_Outro();
            game.clearconsole();
            game.anythingtocontinue();
            level=6;
            place=5;
            game.gameLoop();
            wizard.xp=50;

        }else if(level==6){
            story.The_half_blood_prince_Intro();
            enemy = new Enemy("Death Eater", 55,250);
            battle_6();
            story.The_half_blood_prince_Outro();
            level=7;
            place=6;
            wizard.xp=60;
        }

   }
   public  void battle(){

       // Boucle principale du jeu
       while (wizard.isAlive() && enemy.isAlive()) {
           wizard.xp=Spell.damage;
           // Tour du sorcier
           System.out.println( wizard.getName() + " (" + wizard.hp
                   + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
           String message ="What do you want to do ?\n"+
                   "1 - Fight "+ enemy.getName()+" !\n" +
                   "2 - Use a sort to have more Hp (only if your life is < 100)\n"
                   +"3 - Leave";
           game.slowPrint(message,1);
           int choice = game.readInt("->",3);
           switch (choice) {
               case 1 -> {
                   int damage =  wizard.attack();
                   int reducedDamage = enemy.defend();
                   int totalDamage = reducedDamage * damage;
                   int enemy_hp = enemy.getHp()- totalDamage;
                   enemy.setHp(enemy_hp);

                   String message1 = wizard.getName()+ " attack inflict " + damage + " damage points\n";
                   game.slowPrint(message1,1);

                   if(totalDamage==0){
                       String message2= enemy.getName() + " dodge your attack\n";
                       game.slowPrint(message2,1);
                   }else {

                       String message3= enemy.getName() + " was hit!\n";
                       game.slowPrint(message3,1);
                   }
               }
               case 2 -> {
                   if((Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100))
                   {
                       int healed = 20;
                       wizard.setHp(wizard.getHp() +healed);
                       System.out.println("You healed "+ healed+" Hp !\n");
                       Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                   }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp()<100)){
                       int healed = 25;
                       System.out.println("You healed "+ healed+" Hp !\n");
                       wizard.setHp(wizard.getHp() +healed);
                       Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                   }  else if (wizard.getHp() >=100) {
                       System.out.println("You have enough hp\n");
                   }
               }

               case 3 -> {
                   System.out.println(wizard.getName() + " leave");
                   System.out.println("You are either very smart or either a little bit coward");
                   game.gameLoop();
               }
               default -> System.out.println("Choice not valid");
           }

           if (enemy.isAlive()) {
               int damage = enemy.attack();
               int reducedDamage = wizard.defend();
               int totalDamage = reducedDamage * damage;
               int wizard_hp = wizard.getHp()- totalDamage;
               wizard.setHp(wizard_hp);
               String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                       + wizard.getName() + " take " + totalDamage + " damage points.\n";
               game.slowPrint(message4,75);
           }
       }
       // Fin du jeu
       if (wizard.isAlive()) {
           String message5 = wizard.getName()+ " defeat " + enemy.getName() + " !\n";
           game.slowPrint(message5,25);
       } else {
           String message6= enemy.getName()+ " defeat " + wizard.getName()+ " !\n";
           game.slowPrint(message6,25);
           game.wizardDied();
       }
   }

    public  void battle_level4() {
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive() && minion.isAlive() && (nbr_accio !=3)){
            // Tour du sorcier
            System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp) vs " + minion.getName() + " (" + minion.getHp() + " hp, " +  minion.getXp() + " xp)");
            String message = "What do you want to do ?\n" +
                    "1 - Attack " + enemy.getName() + " !\n" +
                    "2 - Attack " + minion.getName() + " !\n" +
                    "3 - Use a sort to have more Hp (only if your life is < 100)\n"+
                    "4 - Leave";
            game.slowPrint(message, 1);
            int choice = game.readInt("->",4);
            switch (choice) {
                case 1 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy.setHp( enemy.getHp() - totalDamage);
                    String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                    game.slowPrint(message1, 1);
                    if (totalDamage == 0) {
                        String message2 = enemy.getName() + " dodge your attack\n";
                        game.slowPrint(message2, 1);
                    } else {
                        String message3 = enemy.getName() + " was hit!\n";
                        game.slowPrint(message3, 1);
                    }

                }
                case 2 -> {
                    int damage = wizard.attack();
                    int reducedDamage = minion.defend();
                    int totalDamage = reducedDamage * damage;
                    minion.setHp(minion.hp - totalDamage);
                    String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                    game.slowPrint(message1, 1);
                    if (totalDamage == 0) {
                        String message2 = minion.getName() + " dodge your attack\n";
                        game.slowPrint(message2, 1);
                    } else {
                        String message3 = minion.getName() + " was hit!\n";
                        game.slowPrint(message3, 1);
                    }

                }
                case 3 -> {
                    if ((Execution.wizard.house.equals("Hufflepuff")) && (enemy.getHp() < 100)) {
                        int healed = 20;
                        wizard.setHp(wizard.getHp() + healed);
                        System.out.println("You healed " + healed + " Hp !\n");
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                    } else if ((!Execution.wizard.house.equals("Hufflepuff")) && (enemy.getHp() < 100)) {
                        int healed = 25;
                        System.out.println("You healed " + healed + " Hp !\n");
                        wizard.setHp(wizard.getHp() + healed);
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                    } else if (wizard.getHp() >= 100) {
                        System.out.println("You have enough hp\n");
                    }
                }

                case 4 -> {
                    System.out.println(wizard.getName() + " leave");
                    System.out.println("You are either very smart or either a little bit coward");
                    game.gameLoop();
                }
                default -> System.out.println("Choice not valid");
            }
            if (Math.random() > 0.5) {
                if (enemy.isAlive()) {
                    int damage = enemy.attack();
                    int reducedDamage = wizard.defend();
                    int totalDamage = reducedDamage * damage;
                    wizard.setHp(wizard.getHp() - totalDamage);
                    String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n";
                    game.slowPrint(message4, 75);
                }
            } else {
                if (minion.isAlive()) {
                    int damage = minion.attack();
                    int reducedDamage = wizard.defend();
                    int totalDamage = reducedDamage * damage;
                    wizard.setHp(wizard.getHp() - totalDamage);
                    String message4 = minion.getName() + " attack causing " + damage + " damage points. \n";


                    game.slowPrint(message4, 75);
                }
            }}
        // Fin du jeu
        if(nbr_accio==3) {
            String message6 = """
                    You managed to attract the Portolion, and thus to escape!
                    It was a close one, you are very lucky !\s
                    """;
            game.slowPrint(message6, 25);
        } else {
            if (wizard.isAlive()) {
                String message5 = wizard.name + " defeat " + enemy.name + " !\n";
                game.slowPrint(message5, 25);
            } else if (enemy.isAlive()) {
                String message6 = enemy.name + " defeat " + wizard.name + " !\n";
                game.slowPrint(message6, 25);
                game.wizardDied();
            } else if (minion.isAlive()) {
                String message6 = enemy.name + " defeat " + wizard.name + " !\n";
                game.slowPrint(message6, 25);
                game.wizardDied();
            }
        }}
      public void battle_level5(){
        int dureeMillis = 100000;
        final Timer timer = new Timer();
        final boolean[] finDuTimer = {false};
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finDuTimer[0] = true;
                timer.cancel();
            }
        }, dureeMillis);

          while ((firework != 6) && (!finDuTimer[0])){
           // Tour du sorcier
           System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
           String message ="What do you want to do ?\n"+
           "1 - Distract "+ enemy.getName() +" during 15 secondes while your friend prepare a firework!\n" +
           "2 - Prepare a 2 firework (it take 5 secondes)\n"+
            "3 - Use a sort to have more Hp (only if your life is < 100)\n"+
            "4 - Leave";
           game.slowPrint(message,1);
           int choice = game.readInt("->",4);
           switch (choice) {
               case 1 -> firework=Wizard.distraireEnnemi();
               case 2 -> {
                   firework = Wizard.prepare_firework();
                   int damage = Enemy.verifierPreparationFeuArtifice(true);
                   if(damage==0){
                       System.out.println("Dolores didn't see you preparing the firework ! Continue");
                   }else{
                       System.out.println("Dolores caught you preparing  firework, you lose "+damage +" hp and lost 1 firework");
                       wizard.setHp(wizard.getHp() - damage);
                       firework=firework-1;
                   }

               }
                   case 3 -> {
                       if((Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100))
                       {
                           int healed = 20;
                           wizard.setHp(wizard.getHp()+healed);
                           System.out.println("You healed "+ healed+" Hp !\n");
                           Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                       }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100)){
                           int healed = 25;
                           System.out.println("You healed "+ healed+" Hp !\n");
                           wizard.setHp(wizard.getHp() +healed);
                           Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                       }  else if (wizard.getHp() >=100) {
                           System.out.println("You have enough hp\n");
                       }
                   }
                   default -> System.out.println("Choice not valid");
               case 4 -> {
                   System.out.println(wizard.name + " leave");
                   System.out.println("You are either very smart or either a little bit coward");
                   game.gameLoop();
               }
           }}

       // Fin du jeu
       if (firework == 6 ) {
           String message5 = wizard.getName()+ " prepared enough firework during the allotted time and so defeat " + enemy.getName() + " !\n";
           game.slowPrint(message5,75);
       } else {
           String message6= "You didn't prepare enough firework during the alloted time";
           game.slowPrint(message6,75);
           game.wizardDied();
       }
   }
    public  void battle_6(){
        if (Objects.equals(wizard.house, "Slytherin")){
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive()) {
            wizard.xp=Spell.damage;
            // Tour du sorcier
            System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");
            String message ="What do you want to do ?\n"+
                    "1 - Fight "+ enemy.getName() +" !\n" +
                    "2 - Use a sort to have more Hp (only if your life is < 100)\n"+
                    "3 - You are Slytherin you can join Death Eaters\n"
                    +"4 - Leave";
            game.slowPrint(message,1);
            int choice = game.readInt("->",4);
            switch (choice) {
                case 1 -> {
                    int damage = wizard.attack();
                    int reducedDamage = enemy.defend();
                    int totalDamage = reducedDamage * damage;
                    enemy.setHp(enemy.getHp() - totalDamage);
                    String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                    game.slowPrint(message1,1);
                    if(totalDamage==0){
                        String message2= enemy.getName() + " dodge your attack\n";
                        game.slowPrint(message2,1);
                    }else {
                        String message3= enemy.getName() + " was hit!\n";
                        game.slowPrint(message3,1);
                    }

                }
                case 2 -> {
                    if((Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100))
                    {
                        int healed = 20;
                        wizard.setHp(wizard.getHp()+healed);
                        System.out.println("You healed "+ healed+" Hp !\n");
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                    }else if((!Execution.wizard.house.equals("Hufflepuff"))&&(wizard.getHp() <100)){
                        int healed = 25;
                        System.out.println("You healed "+ healed+" Hp !\n");
                        wizard.setHp(wizard.getHp() +healed);
                        Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                    }  else if (wizard.getHp()>=100) {
                        System.out.println("You have enough hp\n");
                    }
                }

                case 3 -> {
                    System.out.println("You decided to join Voldemort army, you will have to figth against your friend");
                    go_with_voldemort=true;
                    enemy.setHp(0);
                    game.gameLoop();
                }
                case 4 -> {
                    System.out.println(wizard.getName()+ " leave");
                    System.out.println("You are either very smart or either a little bit coward");
                    game.gameLoop();
                }
                default -> System.out.println("Choice not valid");
            }

            if (enemy.isAlive()) {
                int damage = enemy.attack();
                int reducedDamage = wizard.defend();
                int totalDamage = reducedDamage * damage;
                wizard.setHp(wizard.getHp() - totalDamage);
                String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                        +wizard.getName() + " take " + totalDamage + " damage points.\n";
                game.slowPrint(message4,75);
            }
        }
        // Fin du jeu
        if (wizard.isAlive()) {
            String message5 = wizard.getName()+ " defeat " + enemy.getName()+ " !\n";
            game.slowPrint(message5,25);
        } else {
            String message6= enemy.getName() + " defeat " + wizard.getName() + " !\n";
            game.slowPrint(message6,25);
            game.wizardDied();
        }
    }else {
                // Boucle principale du jeu
                while (wizard.isAlive() && enemy.isAlive()) {
                    wizard.xp = Spell.damage;
                    // Tour du sorcier
                    System.out.println(wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " + enemy.getXp() + " xp)");
                    String message = "What do you want to do ?\n" +
                            "1 - Fight " + enemy.getName() + " !\n" +
                            "2 - Use a sort to have more Hp (only if your life is < 100)\n" +
                            "3 - Leave";
                    game.slowPrint(message, 1);
                    int choice = game.readInt("->", 4);
                    switch (choice) {
                        case 1 -> {
                            int damage = wizard.attack();
                            int reducedDamage = enemy.defend();
                            int totalDamage = reducedDamage * damage;
                            enemy.setHp(enemy.getHp() - totalDamage);
                            String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                            game.slowPrint(message1, 1);
                            if (totalDamage == 0) {
                                String message2 = enemy.getName() + " dodge your attack\n";
                                game.slowPrint(message2, 1);
                            } else {
                                String message3 = enemy.getName() + " was hit!\n";
                                game.slowPrint(message3, 1);
                            }

                        }
                        case 2 -> {
                            if ((Execution.wizard.house.equals("Hufflepuff")) && (wizard.getHp() < 100)) {
                                int healed = 20;
                                wizard.setHp(wizard.getHp() + healed);
                                System.out.println("You healed " + healed + " Hp !\n");
                                Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                            } else if ((!Execution.wizard.house.equals("Hufflepuff")) && (wizard.getHp() < 100)) {
                                int healed = 25;
                                System.out.println("You healed " + healed + " Hp !\n");
                                wizard.setHp(wizard.getHp() + healed);
                                Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                            } else if (wizard.getHp() >= 100) {
                                System.out.println("You have enough hp\n");
                            }
                        }

                        case 3 -> {
                            System.out.println(wizard.getName() + " leave");
                            System.out.println("You are either very smart or either a little bit coward");
                            game.gameLoop();
                        }
                        default -> System.out.println("Choice not valid");
                    }

                    if (enemy.isAlive()) {
                        int damage = enemy.attack();
                        int reducedDamage = wizard.defend();
                        int totalDamage = reducedDamage * damage;
                        wizard.setHp(wizard.getHp() - totalDamage);
                        String message4 = enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                                + wizard.getName() + " take " + totalDamage + " damage points.\n";
                        game.slowPrint(message4, 75);
                    }
                }
                // Fin du jeu
                if (wizard.isAlive()) {
                    String message5 = wizard.getName() + " defeat " + enemy.getName() + " !\n";
                    game.slowPrint(message5, 25);
                } else {
                    String message6 = enemy.getName() + " defeat " + wizard.getName() + " !\n";
                    game.slowPrint(message6, 25);
                    game.wizardDied();
                }
            }
        }
    public static int Getnbr_accio(){return nbr_accio;}
    public static int Getlevel(){return level;}
    public void continueJourney(){
        Core enemy_wand;
        //check if game isn't in last act
        if(level != 7) checkAct();
        else{
            boolean ennemi1_en_vie = true;
           boolean  ennemi2_en_vie = true;
           story.The_deathly_HallowsIntro();
            enemy = new Enemy("Voldemort", 250,20);
            /*
            enemy_wand = Core.ennemy_choose_Core();
            System.out.println("Voldemort wand is made of " + enemy_wand);
            */
            minion = new Enemy("Bellatrix Lestrange", 200,70 );
            System.out.println("Before you fight you want to..\n");
            System.out.println("1 - Increase your damage\n");
            System.out.println("2 - Increase your life by 100\n");
             result = game.readInt("->",2);
            if(result == 2) {
                wizard.setHp(wizard.getHp() + 100);
            }
            while (wizard.isAlive() && (enemy.isAlive() || minion.isAlive())){
                System.out.println( wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp) vs " + minion.getName() + " (" + minion.getHp() + " hp, " +  minion.getXp() + " xp)");
                String message = "What do you want to do ?\n" +
                        "1 - Attack " + enemy.getName() + " !\n" +
                        "2 - Attack " + minion.getName() + " !\n" +
                        "3 - Use a sort to have more Hp (only if your life is < 100)\n"+
                        "4 - Leave";
                game.slowPrint(message, 1);
                int choice = game.readInt("->",4);
                switch (choice) {
                    case 1 -> {
                        if(enemy.isAlive()) {
                            int damage = wizard.attack();
                            int reducedDamage = enemy.defend();
                            int totalDamage = reducedDamage * damage;
                            enemy.setHp(enemy.getHp() - totalDamage);
                            String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                            game.slowPrint(message1, 1);
                            if (totalDamage == 0) {
                                String message2 = enemy.getName() + " dodge your attack\n";
                                game.slowPrint(message2, 1);
                            } else {
                                String message3 = enemy.getName() + " was hit!\n";
                                game.slowPrint(message3, 1);
                            }
                        } else System.out.println("This ennemy is already dead fight the other ennemy");                    }
                    case 2 -> {if(minion.isAlive()) {
                        int damage = wizard.attack();
                        int reducedDamage = minion.defend();
                        int totalDamage = reducedDamage * damage;
                        minion.setHp(minion.hp - totalDamage);
                        String message1 = wizard.getName() + " inflict " + damage + " damage points\n";
                        game.slowPrint(message1, 1);
                        if (totalDamage == 0) {
                            String message2 = minion.getName() + " dodge your attack\n";
                            game.slowPrint(message2, 1);
                        } else {
                            String message3 = minion.getName() + " was hit!\n";
                            game.slowPrint(message3, 1);
                        }

                    } else System.out.println("This ennemy is already dead fight the other ennemy");                    }
                    case 3 -> {
                        if ((Execution.wizard.house.equals("Hufflepuff")) && (wizard.getHp() < 100)) {
                            int healed = 20;
                            wizard.setHp(wizard.getHp() + healed);
                            System.out.println("You healed " + healed + " Hp !\n");
                            Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                        } else if ((!Execution.wizard.house.equals("Hufflepuff")) && (wizard.getHp() < 100)) {
                            int healed = 25;
                            System.out.println("You healed " + healed + " Hp !\n");
                            wizard.setHp(wizard.getHp() + healed);
                            Wizard.nbr_de_potion = Wizard.nbr_de_potion - 1;

                        } else if (wizard.getHp() >= 100) {
                            System.out.println("You have enough hp\n");
                        }
                    }

                    case 4 -> {
                        System.out.println(wizard.getName() + " leave");
                        System.out.println("You are either very smart or either a little bit coward");
                        game.gameLoop();
                    }
                    default -> System.out.println("Choice not valid");
                }
                if (Math.random() > 0.5) {
                    if (enemy.isAlive()) {
                        int damage = enemy.attack();
                        int reducedDamage = wizard.defend();
                        int totalDamage = reducedDamage * damage;
                        wizard.setHp(wizard.getHp() - totalDamage);
                        String message4 = enemy.getName() + " attack causing " + totalDamage + " damage points. \n";
                        game.slowPrint(message4, 75);
                    }
                } else {
                    if (minion.isAlive()) {
                        int damage = minion.attack();
                        int reducedDamage = wizard.defend();
                        int totalDamage = reducedDamage * damage;
                        wizard.setHp(wizard.getHp() - totalDamage);
                        String message4 = minion.getName() + " attack causing " + totalDamage + " damage points. \n";


                        game.slowPrint(message4, 75);
                    }
                }}

                if (wizard.isAlive()) {
                    String message5 = wizard.getName()  + " defeat " + enemy.getName() + minion.getName() + " !\n";
                    game.slowPrint(message5, 25);
                    story.The_deathly_HallowsOutro();
                } else if (enemy.isAlive()) {
                    String message6 = enemy.getName() + " defeat " + wizard.getName()  + " !\n";
                    game.slowPrint(message6, 25);
                    game.wizardDied();
                    ennemi1_en_vie = false;
                } else if (minion.isAlive()) {
                    String message6 = minion.getName() + " defeat " + wizard.getName()  + " !\n";
                    game.slowPrint(message6, 25);
                    game.wizardDied();
                    ennemi2_en_vie = false;
                }
            }
}}




