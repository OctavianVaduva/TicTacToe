import org.junit.Test;

public class TicTacToeTest {


    private Symbol[][] matrix;
    Referee r ;

    @Test
    public void isLineTest() {
        r = new Referee(new Playboard(), new BotPlayer("Bot1"),
                new BotPlayer("Bot2"));

        matrix = new Symbol[][]{
                {Symbol.SYMBOL_X, Symbol.SYMBOL_X, Symbol.SYMBOL_X},
                {Symbol.SYMBOL_0, Symbol.SYMBOL_EMPTY, Symbol.SYMBOL_EMPTY},
                {Symbol.SYMBOL_EMPTY, Symbol.SYMBOL_0, Symbol.SYMBOL_EMPTY}};

        assert Playboard.isLine();


    }
}
