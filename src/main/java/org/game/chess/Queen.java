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
    extends ChessGamePiece{
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
        List<String> northEastMoves = calculateNorthEastMoves( board, 8 );
        List<String> northWestMoves = calculateNorthWestMoves( board, 8 );
        List<String> southEastMoves = calculateSouthEastMoves( board, 8 );
        List<String> southWestMoves = calculateSouthWestMoves( board, 8 );
        List<String> northMoves = calculateNorthMoves( board, 8 );
        List<String> southMoves = calculateSouthMoves( board, 8 );
        List<String> eastMoves = calculateEastMoves( board, 8 );
        List<String> westMoves = calculateWestMoves( board, 8 );
        List<String> allMoves = new ArrayList<>();
        allMoves.addAll( northEastMoves );
        allMoves.addAll( northWestMoves );
        allMoves.addAll( southWestMoves );
        allMoves.addAll( southEastMoves );
        allMoves.addAll( northMoves );
        allMoves.addAll( southMoves );
        allMoves.addAll( westMoves );
        allMoves.addAll( eastMoves );
        return allMoves;
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
