import java.util.Scanner;

public class HumanPlayer implements Playable {
    private String name;
    private Scanner sc; // butoane apasate
    private Symbol s;

    public HumanPlayer(String name, Scanner sc) {
        this.name = name;
        this.sc = sc;
        this.s = null;
    }

    public int[] getCoord() {
        int row;
        int col;
        do {
            //Scanner sc = new Scanner(System.in);
            System.out.print("Introduceti numarul liniei [1-3] ");
            row = sc.nextInt() - 1;
            System.out.print("Introduceti numarul coloanei [1-3] ");
            col = sc.nextInt() - 1;
        } while (((row < 0) || (row > 2)) || ((col < 0) || (col > 2)));

        return new int[]{row,col};
    }

    public Symbol getSymbol(){
        return s;
    }

    public void setSymbol(Symbol s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "HumanPlayer: " + name + ", care a jucat cu \"" + s + "\", ";
    }
}
