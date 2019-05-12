public class Playboard {

    private Symbol[][] matrix; // dimensiune mare pentru int sau byte, asa ca folosim enum si creem o noua clasa

    public Playboard() { // Constructor
        matrix = new Symbol[3][3];
        for (int row=0; row < 3; row++) {
            for (int col=0; col<3; col++) {
                matrix[row][col] = Symbol.SYMBOL_EMPTY;
            }
        }
    }

    public boolean isEmpty(int [] coord) { // verificare daca casuta solicitata este goala
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
        for (int row=0; row < 3; row++) {
            for (int col=0; col<3; col++) {
                txt = txt + matrix[row][col] + "   ";
            }
            txt = txt + "\n";
        }
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
