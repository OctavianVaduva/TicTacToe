import java.util.Random;

public class BotPlayer implements Playable{

    private String name;
    Symbol symbol; //simbol pe timpul jocului

    public BotPlayer(String name) { //Constructor jucator robot
        this.name = name;

    }

    public int[] getCoord() { // Propunere coordonate
        Random nr =  new Random();
        int row = nr.nextInt(3); // Generare nr. aleatoriu [0,3)
        int col = nr.nextInt(3); // Generare nr. aleatoriu [0,3)

        return new int[]{row,col}; // Coordonate mutare
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "BotPlayer " +
                 name + ", care a jucat cu \"" + symbol + "\", ";
    }
}
