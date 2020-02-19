public class Playboard {

    private Symbol[][] matrix; // dimensiune mare pentru int sau byte, asa ca folosim enum si creem o noua clasa

    Playboard() { // Constructor initializare matrice tabla de joc - toate SYMBOL_EMPTY
        matrix = new Symbol[3][3];
        for (int row=0; row < 3; row++) {
            for (int col=0; col<3; col++) {
                matrix[row][col] = Symbol.SYMBOL_EMPTY;
            }
        }
    }

    Playboard(Symbol[][] testBoard) { // Constructor pentru facilitare testare
        this.matrix = testBoard;
    }

    public boolean isValid(int[] coord) {
        int row = coord[0];
        int col = coord[1];
        return (((row < 0) || (row > 2)) || ((col < 0) || (col > 2)));
    }

    public boolean isEmpty(int[] coord) { // verificare daca casuta solicitata este goala
        int row = coord[0];
        int col = coord[1];
        return (matrix[row][col] == Symbol.SYMBOL_EMPTY);
    }

    public void fill(int[] coord, Symbol symbol) { // completare casuta
        int row = coord[0];
        int col = coord[1];
        matrix[row][col] = symbol;
    }

    @Override
    public String toString() {
        String txt = "";
        String txt1 = "    4   5   6\n";
        String txt2 = "  +---+---+---+\n";
        //txt += txt1;
        for (int row=0; row < 3; row++) {
            txt += txt2;
            for (int col=0; col<3; col++) {
                if(col == 0) {
                    txt = txt + (row+1) + " | ";
                }
                if(col<2) {
                    txt = txt + matrix[row][col] + " | ";
                } else {
                    txt = txt + matrix[row][col] + " | \n";
                }
            }
        }
        txt = txt + txt2 +txt1;
        return txt;
    }

    public boolean isLine() {
        boolean isLine = false;
        for (int i = 0; i < 3; i++) {
            if(((matrix[i][0] == matrix[i][1]) && (matrix[i][0] == matrix[i][2]) && (matrix[i][0] != Symbol.SYMBOL_EMPTY)) ||
                    ((matrix[0][i] == matrix[1][i]) && (matrix[0][i] == matrix[2][i]) && (matrix[0][i] != Symbol.SYMBOL_EMPTY))) {
                isLine = true;
                }
        }
        if(((matrix[1][1] != Symbol.SYMBOL_EMPTY) && (matrix[1][1] == matrix[0][0]) && (matrix[1][1] == matrix[2][2])) ||
                ((matrix[1][1] != Symbol.SYMBOL_EMPTY) && (matrix[1][1] == matrix[0][2]) && (matrix[1][1] == matrix[2][0]))) {
            isLine = true;
        }
        return isLine;
    }
}
