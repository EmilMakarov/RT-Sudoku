import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    public static void main(String[] args) {

        int[][] board = {
                {8, 7, 6, 4, 9, 3, 2, 5, 1},
                {3, 4, 5, 7, 1, 2, 9, 6, 8},
                {2, 9, 1, 5, 6, 8, 4, 7, 3},
                {9, 8, 2, 1, 3, 5, 7, 4, 6},
                {7, 5, 4, 8, 2, 6, 3, 1, 9},
                {1, 6, 3, 9, 4, 7, 8, 2, 5},
                {4, 1, 7, 3, 5, 9, 6, 8, 2},
                {6, 3, 8, 2, 7, 1, 5, 9, 4},
                {5, 2, 9, 6, 8, 4, 1, 3, 7}
        };
        System.out.println(isValid(board));
    }

    //заполняем сет, построчно сравниваем с длиной массива.равен->чистим, ищем дальше, пока не найдём сет меньшей длины или наличие нуля
    public static boolean isValidOnRow(int board[][]) {
        Set<Integer> rowSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                rowSet.add(board[i][j]);
            }
            if (rowSet.size() < board.length || rowSet.contains(0)) {
                return false;
            } else {
                rowSet.clear();
            }
        }
        return true;
    }

    //аналогично для столбцов
    public static boolean isValidOnColumn(int board[][]) {
        Set<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                columnSet.add(board[j][i]);
            }
            if (columnSet.size() < board.length || columnSet.contains(0)) {
                return false;
            } else {
                columnSet.clear();

            }
        }
        return true;
    }

    //аналогично для блоков
    public static boolean isValidOnBlock(int board[][]) {
        Set<Integer> blockSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                blockSet.add(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]);
            }
            if (blockSet.size() < board.length || blockSet.contains(0)) {
                return false;
            } else {
                blockSet.clear();
            }
        }
        return true;
    }

    public static boolean isValid(int board[][]) {
        return isValidOnRow(board) && isValidOnColumn(board) && isValidOnBlock(board);
    }

}

        /*{
                {2, 1, 5, 3, 7, 9, 8, 6, 4},
                {9, 8, 6, 1, 2, 4, 3, 5, 7},
                {7, 3, 4, 8, 5, 6, 2, 1, 9},
                {4, 5, 2, 7, 8, 1, 6, 9, 3},
                {8, 6, 9, 5, 4, 3, 1, 7, 2},
                {3, 7, 1, 6, 9, 2, 4, 8, 5},
                {5, 2, 7, 4, 1, 8, 9, 3, 6},
                {6, 4, 8, 9, 3, 7, 5, 2, 1},
                {1, 9, 3, 2, 6, 5, 7, 4, 8}
        };*/

      /* {
                {8, 7, 6, 4, 9, 3, 2, 5, 1},
                {3, 4, 5, 7, 1, 2, 9, 6, 8},
                {2, 9, 1, 5, 6, 8, 4, 7, 3},
                {9, 8, 2, 1, 3, 5, 7, 4, 6},
                {7, 5, 4, 8, 2, 6, 3, 1, 9},
                {1, 6, 3, 9, 4, 7, 8, 2, 5},
                {4, 1, 7, 3, 5, 9, 6, 8, 2},
                {6, 3, 8, 2, 7, 1, 5, 9, 4},
                {5, 2, 9, 6, 8, 4, 1, 3, 7}
        };*/

