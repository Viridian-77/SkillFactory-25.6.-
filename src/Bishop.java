public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canMove = false;
        if (chessBoard.board[line][column] == null) {
            return canMove; //don't move if there is no chess piece at stars
        }
        if (line < 0 || line > 7
                ||column < 0 || column > 7
                || toLine < 0 || toLine > 7
                || toColumn < 0 || toColumn > 7) {
            return canMove; //don't move beyond the board
        }
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].color.equals(chessBoard.board[line][column].color)) {
            return canMove; //don't move if there's your chess piece in the destination
        }
        if (line == toLine && column == toColumn) {
            return canMove; //don't move if starting point equals destination
        }
        if (Math.abs(column - toColumn) != Math.abs(line - toLine)) {
            return canMove; //move only diagonally
        }
        if (!noFiguresInTheWayDiagonally(chessBoard, line, column, toLine, toColumn)) {
            return canMove;
        }

        canMove = true;
        return canMove;
    }

    private boolean noFiguresInTheWayDiagonally(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int min1, max1, end1, end2;
        if (line > toLine) {
            min1 = toLine;
            max1 = line;
            end1 = toColumn;
            end2 = column;
        } else {
            min1 = line;
            max1 = toLine;
            end1 = column;
            end2 = toColumn;
        }
        boolean ascending = end1 < end2;

        for (int i = min1+1; i < max1; i++) {
            for (int j = ascending ? end1+1 : end1-1; ascending ? j < end2 : j > end2;) {
                if (chessBoard.board[i][j] != null) {
                    return false; //can't move if the path is blocked
                }
                if (ascending) {
                    j++;
                } else {
                    j--;
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
