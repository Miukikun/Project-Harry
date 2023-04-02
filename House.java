public class House {
    Game game= new Game();
    static String[] house ={"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"};
    public static int confidence = 0, smart = 0, strength = 0, ambitious = 0;

    public  void poserQuestions() {
        int response = game.readInt("->",4);
        if (response == 1) {
            confidence++;
        } else if (response == 2) {
            smart++;
        } else if (response == 3) {
        	strength++;
        } else if (response == 4) {
        	ambitious++;
        } else {
            System.out.println("Your messing with me ! Let's be serious please");
        }
    }
    public  void questions() {
        System.out.println("Little boy, little boy... Let see... hmm I never saw a child like you answer those questions.");
        System.out.println("What super power did you attempt to get by yourself during your childhood  ? \n1 - Read minds\n2 - Extreme intelligence \n3 - Extraordinary strength\n4 - Fly" );
        poserQuestions();

        System.out.println("Why would you be the best ? \n1 :Im Confident \n2 :Im Smart\n3 :Im a Worker\n4 :I am the most Brave");
        poserQuestions();

        System.out.println("What class do you prefer ? \n1 : Sort \n2 : Potions \n3 : Herbology\n4 : Defense against the force of evil");
        poserQuestions();

        System.out.println("What poster do you have in your room? \n1 : A fat lady  \n2 : A knight  \n3 : A unicorn  \n4 : A snake");
        poserQuestions();

        System.out.println("What are your favorite sweets ?\n1 : Chocolate\n2 : Peanut\n3 : Licorice\n4 : Pepper");
        poserQuestions();
    }

    public String your_house(){
        questions();
        int max = confidence;
        String test1 = null;
        if (smart > max) {
            System.out.println("""
                    Your house is Ravenclaw,
                    Intensely intelligent, Ravenclaws are also unique and think outside the box.
                    his is usually a good thing, unless by 'thinking outside the box' you mean stealing other wizards' stories and erasing their memories, like a certain Ravenclaw called Gilder Lockhart.""");
             test1=house[2];
            return test1;
        }

        if (strength > max) {
            max = strength;test1=house[1];
            System.out.println("""
                    Your house is Hufflepuff,
                    Hufflepuff characteristics include a strong sense of justice, loyalty, patience, and a propensity for hard work.
                    Hufflepuff are also seen as nice, almost to a fault. Hogwarts houses have moved beyond the realm of fiction and into the real worlds""");

        }

        if (ambitious > max) {
            max = ambitious;
            test1=house[0];
            System.out.println("""
                    Your house is Gryffindor,
                    Courage and chivalry are two of the most recognisable qualities when it comes to this house\s
                    but that doesn't mean that every Gryffindor is always supremely confident and self-assured.
                    Some can be nervous or unsure of themselves and still belong there. Courage doesn't have to involve flashy or daring gestures.""");

        }
        if(max == confidence){
            test1=house[3];
        System.out.println("""
                Your house is Slytherin, Slytherin are known for being ambitious, cunning, and resourceful.s
                Slytherins are also sometimes regarded as being evil thanks to the fact that many of the most sinister witches and wizards
                have been associated with this house.""");


           }
        return test1;
    }}
