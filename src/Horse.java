// write your code here
public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canMove = false;
        if (chessBoard.board[line][column] == null) {
            return canMove;
        }
        if (line < 0 || line > 7
                || column < 0 || column > 7
                || toLine < 0 || toLine > 7
                || toColumn < 0 || toColumn > 7) {
            return canMove;
        }
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].color.equals(chessBoard.board[line][column].color)) {
            return canMove;
        }
        if (line == toLine && column == toColumn) {
            return canMove;
        }
        if (!((line - 1 == toLine && column - 2 == toColumn)
                || (line - 2 == toLine && column - 1 == toColumn)
                || (line - 2 == toLine && column + 1 == toColumn)
                || (line - 1 == toLine && column + 2 == toColumn)
                || (line + 1 == toLine && column + 2 == toColumn)
                || (line + 2 == toLine && column + 1 == toColumn)
                || (line + 2 == toLine && column - 1 == toColumn)
                || (line + 1 == toLine && column - 2 == toColumn))
        ) {
            return canMove;
        }
        canMove = true;
        return canMove;
    }

    public String getSymbol() {
        return "H";
    }
}