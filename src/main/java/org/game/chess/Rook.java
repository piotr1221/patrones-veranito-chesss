package org.game.chess;

import java.util.List;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// -------------------------------------------------------------------------
/**
 * Represents a game.Rook game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Rook extends ChessGamePiece{
	protected Map<Integer, String> icons_map;
	// ----------------------------------------------------------
	/**
	 * Create a new game.Rook object.
	 *
	 * @param board
	 *            the board to create the rook on
	 * @param row
	 *            the row to create the rook on
	 * @param col
	 *            the column to create the rook on
	 * @param color
	 *            either GamePiece.WHITE, BLACK, or UNASSIGNED
	 */
	public Rook( ChessGameBoard board, int row, int col, int color ){
		super( board, row, col, color );
	}
	/**
	 * Calculates the possible moves for this game.Rook.
	 * @param board the board to check on
	 * @return List<String> the list of moves
	 */
	@Override
	protected List<String> calculatePossibleMoves( ChessGameBoard board ){
		List<String> northMoves = calculateNorthMoves( board, 8 );
		List<String> southMoves = calculateSouthMoves( board, 8 );
		List<String> westMoves = calculateWestMoves( board, 8 );
		List<String> eastMoves = calculateEastMoves( board, 8 );
		List<String> allMoves = new ArrayList<>();
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
	public ImageIcon createImageByPieceType() {
		icons_map = new HashMap<Integer, String>();

		icons_map.put(-1, "/chessImages/default-Unassigned.gif");
		icons_map.put(ChessGamePiece.BLACK, "/chessImages/BlackRook.gif");
		icons_map.put(ChessGamePiece.WHITE, "/chessImages/WhiteRook.gif");

		return new ImageIcon(getClass().getResource(this.icons_map.get(getColorOfPiece())));
	}
}
