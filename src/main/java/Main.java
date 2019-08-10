import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Referee r;

        // stabilire mod de joc
        System.out.println("Alegeti varianta de joc: \n" +
                            "      1 = 1 jucator uman si 1 robot \n" +
                            "      2 = 2 umani\n" +
                            "      orice alta tasta NUMERICA = 2 jucatori roboti");

        Scanner in = new Scanner(System.in);
        int joc  = in.nextInt();
        switch(joc) {
            case 1: {
                System.out.println("Jucatori: 1 jucator uman si 1 robot\n");
                Scanner sc = new Scanner(System.in);
                r = new Referee(new Playboard(), new BotPlayer("Bot"), new HumanPlayer("Gandalf", sc));
                break;
            }
            case 2: {
                System.out.println("2 jucatori umani\n");
                Scanner sc = new Scanner(System.in);
                r = new Referee(new Playboard(), new HumanPlayer("Gandalf", sc), new HumanPlayer("Dumbeldorf", sc));

                break;
            }
            default: {
                System.out.println("Jucatori: 2 roboti\n");
                Scanner sc = new Scanner(System.in);
                r = new Referee(new Playboard(), new BotPlayer("Bot1"), new BotPlayer("Bot2"));
            }

        }

//        if(joc == '1') {
//            Scanner sc = new Scanner(System.in);
//            r = new Referee(new Playboard(), new HumanPlayer("Gandalf", sc), new HumanPlayer("Dumbeldorf", sc));
//        } if(joc == '0') {
//            Scanner sc = new Scanner(System.in);
//            r = new Referee(new Playboard(), new BotPlayer("Bot1"), new BotPlayer("Bot2"));
//        } else {
//            Scanner sc = new Scanner(System.in);
//            r = new Referee(new Playboard(), new HumanPlayer("Gandalf", sc), new BotPlayer("Bot"));
//        }

        r.start();//derularea jocului

    }
}
