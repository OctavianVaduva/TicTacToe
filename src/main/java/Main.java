import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Referee r;

        // stabilire mod de joc
        System.out.println("Alegeti varianta de joc: \n" +
                            "      1 = 2 jucatori umani\n" +
                            "      0 = 2 roboti\n" +
                            "      orice alta tasta = 1 jucator uman si 1 robot");
        Scanner in = new Scanner(System.in);
        char joc = in.next().charAt(0);
        if(joc == '1') {
            Scanner sc = new Scanner(System.in);
            r = new Referee(new Playboard(), new HumanPlayer("Gandalf", sc),
                    new HumanPlayer("Dumbeldorf", sc));
        } if(joc == '0') {
            Scanner sc = new Scanner(System.in);
            r = new Referee(new Playboard(), new BotPlayer("Bot1"),
                    new BotPlayer("Bot2"));
        } else {
            Scanner sc = new Scanner(System.in);
            r = new Referee(new Playboard(), new HumanPlayer("Gandalf", sc),
                    new BotPlayer("Bot"));
        }
        r.start();

    }
}
