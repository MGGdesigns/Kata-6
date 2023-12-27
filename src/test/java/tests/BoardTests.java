package tests;

import org.junit.Test;

import software.ulpgc.kata6.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTests {
    @Test
    public void given_an_empty_board_should_return_an_empty_board() {
        Board board = new Board(Cases.emptyBoard).next();
        assertThat(board.state()).isEqualTo(Cases.emptyBoard);
    }

    @Test
    public void given_one_dead_cell_should_return_one_dead_cell() {
        Board board = new Board(Cases.oneDeadCell).next();
        assertThat(board.state()).isEqualTo(Cases.oneDeadCell);
    }

    @Test
    public void given_one_alive_cell_should_return_one_dead_cell() {
        Board board = new Board(Cases.oneAliveCell).next();
        assertThat(board.state()).isEqualTo(Cases.oneDeadCell);
    }

    @Test
    public void given_a_2x2_board_with_all_alive_cells_should_return_2x2_board_with_all_dead_cells() {
        Board board = new Board(Cases.allDead2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allDead2x2);
    }

    @Test
    public void given_a_2x2_board_with_all_alive_cells_should_return_2x2_board_with_all_alive_cells() {
        Board board = new Board(Cases.allAlive2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAlive2x2);
    }

    @Test
    public void name() {
        Board board = new Board(Cases.triangleAlive2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAlive2x2);
    }

    private class Cases {
        public static String[][] emptyBoard = {{}};
        public static String[][] oneDeadCell = {{"."}};
        public static String[][] oneAliveCell = {{"X"}};
        public static String[][] allDead2x2 = {{".", "."},
                                               {".", "."}};
        public static String[][] allAlive2x2 = {{"X", "X"},
                                                {"X", "X"}};
        public static String[][] triangleAlive2x2 = {{".", "X"},
                                                     {"X", "X"}};;
    }
}
