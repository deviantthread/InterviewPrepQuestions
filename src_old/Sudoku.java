import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

    private final List<Set<Integer>> rowSets = new ArrayList<Set<Integer>>();
    private final List<Set<Integer>> colSets = new ArrayList<Set<Integer>>();
    private final List<List<Set<Integer>>> boxSets = new ArrayList<List<Set<Integer>>>();

    public Sudoku() {
        for (int i = 0; i <= 8; i++) {
            rowSets.add(new HashSet<Integer>());
            colSets.add(new HashSet<Integer>());
        }

        for (int boxX = 0; boxX <= 2; boxX++) {
            boxSets.add(new ArrayList<Set<Integer>>());
            for (int boxY = 0; boxY <= 2; boxY++) {
                boxSets.get(boxX).add(new HashSet<Integer>());
            }
        }
    }

    public void solve(int[][] board) {
        solveAt(board, 0, 0);
    }

    private boolean solveAt(int[][] board, int row, int col) {
        if (isEntireBoardFilled(board)) {
            return true;
        }

        boolean squareAlreadyFilled = board[row][col] != 0;
        if (squareAlreadyFilled) {
            Square square = findNextSquare(row, col);
            return solveAt(board, square.row, square.col);
        }

        for (int num = 1; num <= 9; num++) {
            boolean isValid = isValid(board, row, col, num);

            if (isValid) {
                board[row][col] = num;
                addNumberToSets(num, row, col);
                Square square = findNextSquare(row, col);
                boolean solved = solveAt(board, square.row, square.col);
                if (solved) {
                    return true;
                }
                removeNumberFromSets(num, row, col);
            }
        }

        // we failed to find a valid number, erase this spot and back track
        board[row][col] = 0;
        return false;
    }

    private void addNumberToSets(int num, int row, int col) {
        rowSets.get(row).add(num);
        colSets.get(col).add(num);
        int boxX = row / 3;
        int boxY = col / 3;
        boxSets.get(boxX).get(boxY).add(num);
    }

    private void removeNumberFromSets(int num, int row, int col) {
        rowSets.get(row).remove(num);
        colSets.get(col).remove(num);
        int boxX = row / 3;
        int boxY = col / 3;
        boxSets.get(boxX).get(boxY).remove(num);

    }

    private boolean isEntireBoardFilled(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private Square findNextSquare(int row, int col) {
        col++;
        if (col > 8) {
            col = 0;
            row++;
        }
        return new Square(row, col);
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        return isValidInRow(board, row, col, num)
                && isValidInCol(board, row, col, num)
                && isValidInBox(board, row, col, num);
        // return isValidInRow(row, num)
        // && isValidInCol(col, num)
        // && isValidInBox(row, col, num);
    }

    private boolean isValidInRow_fast(int row, int num) {
        return !rowSets.get(row).contains(num);
    }

    private boolean isValidInCol_fast(int col, int num) {
        return !colSets.get(col).contains(num);
    }

    private boolean isValidInBox_fast(int row, int col, int num) {
        int boxX = row / 3;
        int boxY = col / 3;
        return !boxSets.get(boxX).get(boxY).contains(num);
    }

    private boolean isValidInRow(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board[row].length; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInCol(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInBox(int[][] board, int row, int col, int num) {
        int boxX = row / 3;
        int boxY = col / 3;

        for (int i = 3 * boxX; i < 3; i++) {
            for (int j = 3 * boxY; j < 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Square {
        public int row;
        public int col;

        public Square(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        // int[][] board = convertFile("/home/local/ANT/borriesj/tmp/board.txt");
        // System.out.println("pre-solved:");
        // printBoard(board);
        // System.out.println("solved:");
        // new Sudoku().solve(board);
        // printBoard(board);
    }

    private static int[][] convertFile(String filePath) {
        int[][] board = new int[9][];
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            for (int row = 0; row <= 8; row++) {
                board[row] = new int[9];
                char[] chars = br.readLine().toCharArray();

                for (int col = 0; col <= 8; col++) {
                    int digit = 0;
                    if (Character.isDigit(chars[col])) {
                        digit = Character.getNumericValue(chars[col]);
                    }
                    board[row][col] = digit;
                }
            }

            br.close();
            return board;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (row % 3 == 0) {
                System.out.println("------------------------");
            }
            for (int col = 0; col < board[row].length; col++) {
                if (col % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
