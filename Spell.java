import java.lang.String;
import java.util.Scanner;


public class Spell extends AbstractSpeel{
    public static String[] spells={"Wingardium Leviosa","Accio","Expecto Patronum","Sectumsempra"} ;
    static Scanner scanner = new Scanner(System.in);
    public Spell(int level, int damage) {
        super(level, damage);
    }

}
