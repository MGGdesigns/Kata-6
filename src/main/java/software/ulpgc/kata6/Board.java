package software.ulpgc.kata6;

public class Board {
    private final String[][] state;

    public Board(String[][] state) {
        this.state = state;
    }

    public Board next() {
        return new Board(calculateNextState());
    }

    private String[][] calculateNextState() {
        String[][] result = new String[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = validateNextState(i,j);
            }
        }
        return result;
    }

    private String validateNextState(int row, int col) {
        return validateCell(row, col) ? "X" : ".";
    }

    private boolean validateCell(int row, int col) {
        int neighbors = countNeighborsOfCell(row, col);
        return state[row][col].equals("X") && neighbors >= 2 && neighbors <= 3 || neighbors == 3 && state[row][col].equals(".");
    }

    private int countNeighborsOfCell(int row, int col) {
        int count = 0;
        if(validateNeighbor(row-1, col-1)) count++;
        if(validateNeighbor(row-1, col+1)) count++;
        if(validateNeighbor(row-1, col)) count++;
        if(validateNeighbor(row+1, col-1)) count++;
        if(validateNeighbor(row+1, col+1)) count++;
        if(validateNeighbor(row+1, col)) count++;
        if(validateNeighbor(row, col+1)) count++;
        if(validateNeighbor(row, col-1)) count++;
        return count;
    }

    private boolean validateNeighbor(int row, int col) {
        return isBounds(row, col) && state[row][col].equals("X");
    }

    private boolean isBounds(int row, int col) {
        return row >= 0 && row < rows() && col >= 0 && col < cols();
    }

    private int cols() {
        return state[0].length;
    }

    private int rows() {
        return state.length;
    }

    public String[][] state() {
        return state;
    }
}
