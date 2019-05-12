import java.util.Random;

public class Referee {
    private Playable pX;
    private Playable p0;
    private Playboard board;

    public Referee (Playboard board, Playable a, Playable b) {
        this.board = board;
        Random r =  new Random();
        if(r.nextBoolean()) {
            this.pX = a;
            a.setSymbol(Symbol.SYMBOL_X);
            this.p0 = b;
            b.setSymbol(Symbol.SYMBOL_0);
        }else {
            this.pX = b;
            b.setSymbol(Symbol.SYMBOL_X);
            this.p0 = a;
            a.setSymbol(Symbol.SYMBOL_0);
        }
    }

    public void start() {
        Playable currentPlayer;
        String result = "Nu exista castigator!";

        for (int i = 1; i <=9; i++) {
            if(i%2 == 1) {
                currentPlayer = pX;
            } else {
                currentPlayer = p0;
            }

            System.out.println(board); // afisam tabla
            System.out.println(currentPlayer + " este la mutare!");
            int[] coord = currentPlayer.getCoord();
            // Arbitrul valideaza mutarea cu respect fata de incapsulare, adica in loc sa se uite abuziv in matrice,
            // acesta intreaba matricea daca este libera casuta

            boolean validCoord = false;
            while (!validCoord) {
                if (board.isEmpty(coord)) {
                    board.fill(coord, currentPlayer.getSymbol());
                    validCoord = true;

                } else {
                    System.out.println("Mutare neacceptata - casuta ocupata. Introduceti alte coordonate!");
                    coord = currentPlayer.getCoord();
                }
            }
            if(i>=5 && board.isLine()) {
                result = "Jucatorul " + currentPlayer + " a castigat!";
                break;
            }
            System.out.println("\n\n");
        }
        System.out.println("===========================================================\n");
        System.out.println(board); // afisam tabla la sfarsitul jocului
        System.out.println("===========================================================");
        System.out.println(result);
    }
}
