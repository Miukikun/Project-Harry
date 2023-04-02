import java.lang.System;
import java.util.Scanner;

public class Wand {
    static Scanner scanner = new Scanner(System.in);
    public static int choose_wand() {
        Game game = new Game();
        int size;
        Core.choose_Core();
        game.clearconsole();
        System.out.println("Now you have to choose your wand, this one would choose you but" +
                " what size would you like ? It has to be between 9 and 40 inches");
        size = scanner.nextInt();
        do {
            if (size > 40) {
                System.out.println("Your wand is too long, please choose a shorter one");
                size = scanner.nextInt();
            } else if (size < 9) {
                System.out.println("Your wand is too short, please choose a longer one");
                size = scanner.nextInt();
            }

        } while ((size > 40) || (size < 9));
        System.out.println("Perfect your wand is " + size + " inches");
        return size;
        }
    }
