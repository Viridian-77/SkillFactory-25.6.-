public class Rook extends ChessPiece {
    public Rook(String color) {
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
        if (line != toLine && column != toColumn) {
            return canMove; //move only in a straight line
        }
        if (!noFiguresInTheWayInAStraightLine(chessBoard, line, column, toLine, toColumn)) {
            return canMove;
        }

        canMove = true;
        return canMove;
    }

    private boolean noFiguresInTheWayInAStraightLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column != toColumn) {
            if (column < toColumn) {
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }
        } else if (column == toColumn && line != toLine) {
            if (line < toLine) {
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = line - 1; i > toLine; i--) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
