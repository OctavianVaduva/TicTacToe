import java.util.Scanner;

public class HumanPlayer implements Playable {
    private String name; // nume jucator (prestabilit)
    private Scanner sc; // butoane apasate
    private Symbol symbol; //simbol pe timpul jocului

    public HumanPlayer(String name, Scanner sc) { // Constructor jucator uman
        this.name = name;
        this.sc = sc;
        this.symbol = null;
    }

    public int[] getCoord() {
        int row;
        int col;
        byte count = 0;
        do {
            if(count > 0){ //Verificare reintroducere coordonate
                System.out.println("\nCoordonatele introduse sunt in afara tablei!" +
                        "\nReintroduceti alta pereche de coordonate!");
            }
            count+=1;
            System.out.print("Introduceti numarul liniei [1-3] ");
            row = sc.nextInt() - 1; //Conversia coordonatelor munerice 1-3 in coordonate array 0-2
            System.out.print("Introduceti numarul coloanei [1-3] ");
            col = sc.nextInt() - 1; //Conversia coordonatelor munerice 1-3 in coordonate array 0-2

        } while (((row < 0) || (row > 2)) || ((col < 0) || (col > 2))); // se verifica incadrarea in dimensiunile tablei

        return new int[]{row,col};
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "HumanPlayer: " + name + ", care joaca cu \"" + symbol + "\", ";
    }
}
