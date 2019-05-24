import java.util.Random;

public class Referee {
    private Playable playWith_X; //jucatorul cu semnul X
    private Playable playWith_0; //jucatorul cu semnul 0
    private Playboard playBoard; //tabla de joc

    public Referee (Playboard board, Playable PlayerA, Playable PlayerB) { //Constructor arbitru (joc)
        this.playBoard = board;
        Random r = new Random(); //Stabilire aleatoare a simbolului jucatorului
        if(r.nextBoolean()) { //Returns the next pseudorandom, uniformly distributed
            this.playWith_X = PlayerA;
            PlayerA.setSymbol(Symbol.SYMBOL_X);
            this.playWith_0 = PlayerB;
            PlayerB.setSymbol(Symbol.SYMBOL_0);
        }else {
            this.playWith_X = PlayerB;
            PlayerB.setSymbol(Symbol.SYMBOL_X);
            this.playWith_0 = PlayerA;
            PlayerA.setSymbol(Symbol.SYMBOL_0);
        }
    }

    public void start() {
        Playable currentPlayer; // variabila jucator curent, de tip Playable
        String result = "Nu exista castigator!";

        for (int i = 1; i <=9; i++) {
            if(i%2 == 1) {
                currentPlayer = playWith_X;
            } else {
                currentPlayer = playWith_0;
            }

            System.out.println(playBoard); // afisam tabla
            System.out.println(currentPlayer + " este la mutare!");
            int[] coord = currentPlayer.getCoord();
            // Arbitrul valideaza mutarea cu respect fata de incapsulare, adica in loc sa se uite abuziv in matrice,
            // acesta intreaba matricea daca este libera casuta

            while(!playBoard.isEmpty(coord)) { // verificare daca este goala casuta
                System.out.println("Mutare neacceptata - casuta ocupata. Introduceti alte coordonate!");
                coord = currentPlayer.getCoord();
                playBoard.isEmpty(coord);
            }
            playBoard.fill(coord, currentPlayer.getSymbol());

            if(i>=5 && playBoard.isLine()) {
                result = "Jucatorul " + currentPlayer + " a castigat!";
                break;
            }
            System.out.println("\n");
        }
        System.out.println("\n===========================================================\n");
        System.out.println(playBoard); // afisam tabla la sfarsitul jocului
        System.out.println("===========================================================");
        System.out.println(result);
    }
}
