package org.game.chess;

import java.util.List;
import javax.swing.ImageIcon;
import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 * Represents a game.Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen
    extends AllDirections {
    // ----------------------------------------------------------
    /**
     * Create a new game.Queen object.
     *
     * @param board
     *            the board the queen is on
     * @param row
     *            the row location of the queen
     * @param col
     *            the column location of the queen
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color );
    }
    /**
     * Calculates the possible moves for this game.Queen.
     * @param board the board to check on
     * @return List<String> the list of moves
     */
    @Override
    protected List<String> calculatePossibleMoves( ChessGameBoard board ){
        return super.calculatePossibleMoves(board, 8);
    }
    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                getClass().getResource("/chessImages/WhiteQueen.gif")
            );            
        }
        else if ( getColorOfPiece() == ChessGamePiece.BLACK ){
            return new ImageIcon(
                getClass().getResource("/chessImages/BlackQueen.gif")
            );            
        }
        else
        {
            return new ImageIcon(
                getClass().getResource("/chessImages/default-Unassigned.gif")
            ); 
        }
    }
}
