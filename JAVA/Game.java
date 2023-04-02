import java.util.Scanner;
import java.lang.System;
import java.lang.String;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    public boolean isRunning;
    public void seperator(int n){
        for(int i=0;i<n;i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void Header(String title){
        seperator(30);
        System.out.println(title);
        seperator(30);}
    public void anythingtocontinue(){
        System.out.println("\nEnter something to continue...");
        scanner.next();}
    public void clearconsole(){
        for(int i=0; i<5;i++)
            System.out.println();
    }
    public  int readInt(String prompt, int Userchoice) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e){
                input = -1;
                System.out.println("enter a number !");
            }
        } while (input < 1 || input > Userchoice);
        return input;
    }

    public void slowPrint(String message, int delay) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public void characterInfo(){
        clearconsole();
        Header("Character info");
        System.out.println(Exec.wizard.getName() + "Your Pet : " + Exec.wizard.pet + "\nThe size of your wand : " +Exec.wizard.wand + "\nYour house is :" + Exec.wizard.house);
        seperator(5);
    }
    
    public void wizardDied(){
        clearconsole();
        Header("You died...");
        Header("You earned " + Exec.wizard.xp + " XP on your journey.Try to earn more next time!");
        isRunning=false;
    }

    public  void gameLoop(){
    	Exec exc =new Exec();
        while(isRunning){
            Menu();
            int input = readInt("->",3);
            if(input==1){
                clearconsole();
                exc.continueJourney();}
            else if(input==2)
                characterInfo();
            else
                isRunning=false;
        }
    }
    
    public void Menu(){
        clearconsole();
        Header(Exec.places[Exec.place]);
        System.out.println("choose an action:");
        seperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character info");
        System.out.println("(3) Exit game");

    }
    
    public  int Choose_spell(){
        int damage = 0;
        System.out.println("Choose a spell");

        int spellCount = Exec.Getlevel();  // number of available spells
        if((Exec.level==1)){
            for (int i = 0; i < spellCount; i++) {

                System.out.println((i + 1) + " : " + Spell.spells[i]);
            }
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else{ System.out.println("Please enter a valide value");
                Choose_spell();}
        }
        else if((Exec.level==2)&& (Exec.wizard.house.equals("Gryffindor")))
        {
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            spellCount=spellCount+1;
            System.out.println("3 : Use the legend sword of Godric Gryffindor  ");
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }else if (input == 3) {
                damage = 45;
            }
        }
        else if(Exec.level == 2) {
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }
        }
       else if((Exec.level==3)){
            System.out.println(" Use Expecto Patronum a "+ Exec.patronus);
            switch (Exec.patronus) {
                case "Deer" -> damage = 28;
                case "Eagle" -> damage = 30;
                case "Horse" -> damage = 32;
                default -> {
                    System.out.println("Please enter a valide value");
                    Choose_spell();
                }
            }}
        else if(Exec.level==4){
            spellCount=2;
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
            	Exec.nbr_accio= 1 +Exec.Getnbr_accio();
                damage = 20;
            }
        }
        else if(Exec.level==6){
            spellCount=4;
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 10;
            } else if (input == 2) {
                damage = 20;
            }else if (input == 3) {
                damage = 30;
            }else if (input == 4) {
                damage = 40;
            }
        }
        else if(Exec.level==7 && Exec.result==1){
            spellCount=4;
            for (int i = 0; i < spellCount; i++) {
                System.out.println((i + 1) + " : " + Spell.spells[i]);}
            int input = readInt("->", spellCount);
            if (input == 1) {
                damage = 20;
            } else if (input == 2) {
                damage = 40;
            }else if (input == 3) {
                damage = 30;
            }else if (input == 4) {
                damage = 40;
            }
        }
        return damage;      }


}
