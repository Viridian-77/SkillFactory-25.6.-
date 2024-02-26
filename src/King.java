public class King extends ChessPiece {
    public King(String color) {
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
        if (Math.abs(column - toColumn) > 1 || Math.abs(line - toLine) > 1) {
            return canMove; //move only diagonally or vertically for 1 square
        }
        canMove = true;
        return canMove;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int i, int i1) {
        boolean isUnderAttack = false;
        for (int j = 0; j < chessBoard.board.length; j++) {
            for (int k = 0; k < chessBoard.board[j].length; k++) {
                if (chessBoard.board[j][k] != null
                        && !chessBoard.board[j][k].color.equals(this.color)
                        && chessBoard.board[j][k].canMoveToPosition(chessBoard, j, k, i, i1)) {
                    isUnderAttack = true;
                }
            }
        }
        return isUnderAttack;
    }
}
