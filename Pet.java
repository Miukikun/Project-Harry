public enum  Pet {
    Owl,Rat,Cat,Toad;

    public static Pet choosePet() {
        Story story = new Story();
        story.printIntro();
        Game game = new Game();
        game.clearconsole();
        game.Header("Please, choose your companion for the adventures");
        System.out.println("(1) Owl");
        System.out.println("(2) Rat");
        System.out.println("(3) Cat");
        System.out.println("(4) Toad");
        int input = game.readInt("->", 4);
        if (input == 1) {
            System.out.println("Nice you have a new Owl, she's beautiful");
            return Pet.Owl;
        }
        if (input == 2) {
            System.out.println("Nice you have a new Rat, he's beautiful");
            return Pet.Rat;
        }
        if (input == 3) {
            System.out.println("Nice you have a new Cat, she's/he's beautiful");
            return Pet.Cat;
        }
        else {
            System.out.println("Nice you have a new Toad, she's/he's beautiful");
            return Pet.Toad;
        }
    }
}
