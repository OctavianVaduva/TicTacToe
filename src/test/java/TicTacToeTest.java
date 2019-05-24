import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class TicTacToeTest {

    private Symbol[][] testBoard;

    @Test
    public void isLineTest() {

        testBoard = new Symbol[][]{
                {Symbol.SYMBOL_X, Symbol.SYMBOL_X, Symbol.SYMBOL_X},
                {Symbol.SYMBOL_0, Symbol.SYMBOL_EMPTY, Symbol.SYMBOL_EMPTY},
                {Symbol.SYMBOL_EMPTY, Symbol.SYMBOL_0, Symbol.SYMBOL_EMPTY}};

        Playboard board = new Playboard(testBoard);
        assert board.isLine();
    }

    @Test
    public void stopAfterPlayingWithTwoBots() {
        Referee r = new Referee(new Playboard(),
                new BotPlayer("Gandalf"),
                new BotPlayer("Dumbeldore"));
        r.start();
        assertTrue(true);
    }

    @Test
    public void winX(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("D:\\Proiecte\\Cursul.26_TicTacToe\\src\\test\\java\\testWinX.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Referee r = new Referee(new Playboard(),
                new HumanPlayer("Gandalf", sc),
                new HumanPlayer("Dumbeldore", sc));

        r.start();
        //assertEquals(Symbol.SYMBOL_X, r.start()); todo de corectat egalitatea mesajului de sfarsit
    }



}
