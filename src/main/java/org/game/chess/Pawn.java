package org.game.chess;

import java.util.List;
import java.util.function.IntUnaryOperator;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import org.game.chess.enums.PieceColorEnum;
// -------------------------------------------------------------------------
/**
 * Represents a game.Pawn game piece. Unique in that it can move two locations on its
 * first turn and therefore requires a new 'notMoved' variable to keep track of
 * its turns.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Pawn
    extends ChessGamePiece{
    private boolean notMoved;
    // ----------------------------------------------------------
    /**
     * Create a new game.Pawn object.
     *
     * @param board
     *            the board to create the pawn on
     * @param row
     *            row of the pawn
     * @param col
     *            column of the pawn
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Pawn(ChessGameBoard board, int row, int col, PieceColorEnum color ){
        super( board, row, col, color, true );
        notMoved = true;
        possibleMoves = calculatePossibleMoves( board );
    }
    /**
     * Moves this pawn to a row and col
     *
     * @param board
     *            the board to move on
     * @param row
     *            the row to move to
     * @param col
     *            the col to move to
     * @return boolean true if the move was successful, false otherwise
     */
    @Override
    public boolean move( ChessGameBoard board, int row, int col ){
        if ( super.move( board, row, col ) ){
            notMoved = false;
            possibleMoves = calculatePossibleMoves( board );
            if ( ( getColorOfPiece() == PieceColorEnum.BLACK && row == 7 )
                || ( getColorOfPiece() == PieceColorEnum.WHITE && row == 0 ) ){ // pawn has reached the end of the board, promote it to queen
                board.getCell( row, col ).setPieceOnSquare( new Queen(
                    board,
                    row,
                    col,
                    getColorOfPiece() ) );
            }
            return true;
        }
        return false;
    }
    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board
     *            the game board to calculate moves on
     * @return List<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        IntUnaryOperator navOp = PieceColorEnum.WHITE == this.getColorOfPiece() ?
            x -> x -1 : x -> x+1;

        ArrayList<String> moves = new ArrayList<>();
        if ( isPieceOnScreen() ){
            int currRow = navOp.applyAsInt(pieceRow);
            int count = 1;
            int maxIter =  Boolean.compare(notMoved, true) + 2;
            // check for normal moves
            while ( count <= maxIter ){ // only loop while we have open slots and have not passed our
                // limit
                if ( isOnScreen( currRow, pieceColumn ) && board.getCell( currRow, pieceColumn ).getPieceOnSquare() == null ){
                    moves.add( currRow + "," + pieceColumn );
                }
                else
                {
                    break;
                }
                currRow = navOp.applyAsInt(currRow);
                count++;
            }

            if ( isEnemy( board, navOp.applyAsInt(pieceRow), pieceColumn - 1 ) ){
                moves.add( ( navOp.applyAsInt(pieceRow) ) + "," + ( pieceColumn - 1 ) );
            }
            if ( isEnemy( board, navOp.applyAsInt(pieceRow), pieceColumn + 1 ) ){
                moves.add( ( navOp.applyAsInt(pieceRow) ) + "," + ( pieceColumn + 1 ) );
            }
        }
        return moves;
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
                getClass().getResource("/chessImages/WhitePawn.gif")
            );            
        }
        else if ( getColorOfPiece() == PieceColorEnum.BLACK ){
            return new ImageIcon(
                getClass().getResource("/chessImages/BlackPawn.gif")
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
