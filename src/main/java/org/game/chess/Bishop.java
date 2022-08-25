package org.game.chess;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.game.chess.enums.PieceColorEnum;
// -------------------------------------------------------------------------
/**
 * Class to represent the game.Bishop piece.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece{
	/**
	 * Creates a new game.Bishop object.
	 * 
	 * @param board
	 *			board the board to create the bishop on
	 * @param row
	 *			row location of the game.Bishop
	 * @param col
	 *			col location of the game.Bishop
	 * @param color
	 *			either GamePiece.WHITE, BLACK, or UNASSIGNED
	 */
	public Bishop(ChessGameBoard board, int row, int col, PieceColorEnum color ){
		super( board, row, col, color );
	}
	/**
	 * Calculates the possible moves for this piece. These are ALL the possible
	 * moves, including illegal (but at the same time valid) moves.
	 * 
	 * @param board
	 *			the game board to calculate moves on
	 * @return List<String> the moves
	 */
	@Override
	protected List<String> calculatePossibleMoves(ChessGameBoard board ){
		List<String> northEastMoves = calculateNorthEastMoves( board, 8 );
		List<String> northWestMoves = calculateNorthWestMoves( board, 8 );
		List<String> southEastMoves = calculateSouthEastMoves( board, 8 );
		List<String> southWestMoves = calculateSouthWestMoves( board, 8 );
		List<String> allMoves = new ArrayList<>();
		allMoves.addAll( northEastMoves );
		allMoves.addAll( northWestMoves );
		allMoves.addAll( southEastMoves );
		allMoves.addAll( southWestMoves );
		return allMoves;
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
				getClass().getResource("/chessImages/WhiteBishop.gif")
			);			
		}
		else if ( getColorOfPiece() == PieceColorEnum.BLACK ){
			return new ImageIcon(
				getClass().getResource("/chessImages/BlackBishop.gif")
			);
		}
		else{
			return new ImageIcon(
				getClass().getResource("/chessImages/BlackBishop.gif")
			);
		}
	}
}