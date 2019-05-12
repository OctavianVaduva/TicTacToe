import java.util.Random;

public class BotPlayer implements Playable{

    private String name;
    Symbol s;

    public BotPlayer(String name) {
        this.name = name;
    }

    public int[] getCoord() {
        Random nr =  new Random();
        int row = nr.nextInt(3);
        int col = nr.nextInt(3);

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
        return "BotPlayer " +
                 name + ", care a jucat cu \"" + s + "\", ";
    }
}
