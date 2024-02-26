public class Pawn extends ChessPiece {
    public Pawn(String color) {
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
            return canMove;
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
        if (Math.abs(column - toColumn) > 1) {
            return canMove;
        }
        if (color.equals("White")) {
            if (line != 1 && toLine - line != 1) {
                return canMove; //when not on the starting line, move only 1 square
            } else if (line == 1 && toLine - line != 1 && toLine - line != 2) {
                return canMove; //when on the starting line, move 1 or 2 square
            } else if (toLine - line == 1 && Math.abs(toColumn - column) == 1 && chessBoard.board[toLine][toColumn] == null) {
                return canMove; //can move diagonally only when eating other player's pieces
            } else if (toLine - line == 1 && Math.abs(toColumn - column) == 0 && chessBoard.board[toLine][toColumn] != null) {
                return canMove; //cannot move in a straight line if the path is blocked
            }
        } else if (color.equals("Black")) {
            if (line != 6 && toLine - line != -1) {
                return canMove;
            } else if (line == 6 && toLine - line != -1 && toLine - line != -2) {
                return canMove;
            } else if (toLine - line == -1 && Math.abs(toColumn - column) == 1 && chessBoard.board[toLine][toColumn] == null) {
                return canMove;
            } else if (toLine - line == -1 && Math.abs(toColumn - column) == 0 && chessBoard.board[toLine][toColumn] != null) {
                return canMove;
            }
        }
        canMove = true;
        return canMove;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
