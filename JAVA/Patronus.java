import java.util.Scanner;

public class Patronus {

    static String[] patronus ={"Deer","Eagle","Horse"};
    public static int a = 0, b = 0, c = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void poserQuestions() {
        int response = scanner.nextInt();
        if (response == 1) {
            a++;
        } else if (response == 2) {
            b++;
        } else if (response == 3) {
            c++;
        }  else {
            System.out.println("Your messing with me ! Let's be serious please");
        }
    }
    public static void questions() {
        System.out.println("Now you have to answer this few questions to figure what your patronus is !");
        System.out.println("You choose a magic item… ? \n1 : A music boxe\n2 :A pine cone \n3 : A scary mask\n" );
        poserQuestions();

        System.out.println("You build your school of wizards. She looks like…? \n1 : A theme park \n2 : A magic cabin in the forest\n3 : A haunted castle\n");
        poserQuestions();

        System.out.println("Your dreams are sometimes... ? \n1 : Crazy \n2 : Marvellous \n3 : Scary\n");
        poserQuestions();

        System.out.println("You choose your grimoire…? \n1 : The Great Sorcerer's Blooper \n2 : Magic and wisdom to appease the world \n3 : Evil Spirits and How to Counter Them\n");
        poserQuestions();
        System.out.println("When you meet someone, you are... ? \n1 : Curios \n2 : Listening \n3 : Febrile\n");
        poserQuestions();
    }

    public static String your_patronus(){
        questions();
        int max = a;
        String test1 = null;
        if (b > max) {
            test1=patronus[0];
            System.out.println(" Your patronus is a Deer !");

        }

       else if (c > max) {
            test1=patronus[1];
            System.out.println("Your patronus is a eagle !");

        }

       else if(max == a){
            test1=patronus[2];
            System.out.println("Your patronus is a horse !");

        }
        return test1;
    }
}
