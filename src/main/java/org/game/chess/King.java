package org.game.chess;

import java.util.List;
import javax.swing.ImageIcon;
import org.game.chess.enums.PieceColorEnum;
// -------------------------------------------------------------------------
/**
 * Represents a game.King game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class King
    extends AllDirections {
    // ----------------------------------------------------------
    /**
     * Create a new game.King object.
     *
     * @param board
     *            the board to create the king on
     * @param row
     *            the row to create the king on
     * @param col
     *            the column to create the king on
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King(ChessGameBoard board, int row, int col, PieceColorEnum color ){
        super( board, row, col, color, false );
    }
    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board
     *            the game board to calculate moves on
     * @return List<String> the moves
     */
    protected List<String> calculatePossibleMoves( ChessGameBoard board ){
        return super.calculatePossibleMoves(board, 1);
    }
    /**
     * Determines if this game.King is checked.
     *
     * @param board
     *            the board to check on
     * @return true if checked, false if not checked
     */
    public boolean isChecked( ChessGameBoard board ){
        return getCurrentAttackers( board ).size() > 0;
    }
    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece() == PieceColorEnum.WHITE ){
            return new ImageIcon(
                getClass().getResource("/chessImages/WhiteKing.gif")
            );            
        }
        else if ( getColorOfPiece() == PieceColorEnum.BLACK ){
            return new ImageIcon(
                getClass().getResource("/chessImages/BlackKing.gif" )
            );            
        }
        else
        {
            return new ImageIcon(
                getClass().getResource("/chessImages/default-Unassigned.gif" )
            );            
        }
    }
}
