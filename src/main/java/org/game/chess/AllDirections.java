package org.game.chess;

import java.util.ArrayList;
import java.util.List;
import org.game.chess.enums.PieceColorEnum;

public abstract class AllDirections extends ChessGamePiece{

    protected AllDirections(ChessGameBoard board, int row, int col, PieceColorEnum pieceColor) {
        super(board, row, col, pieceColor);
    }

    public AllDirections(ChessGameBoard board, int row, int col, PieceColorEnum pieceColor,
                         boolean skipMoveGeneration) {
        super(board, row, col, pieceColor, skipMoveGeneration);
    }

    protected List<String> calculatePossibleMoves(ChessGameBoard board, int numMoves){
        List<String> northEastMoves = calculateNorthEastMoves( board, numMoves );
        List<String> northWestMoves = calculateNorthWestMoves( board, numMoves );
        List<String> southEastMoves = calculateSouthEastMoves( board, numMoves );
        List<String> southWestMoves = calculateSouthWestMoves( board, numMoves );
        List<String> northMoves = calculateNorthMoves( board, numMoves );
        List<String> southMoves = calculateSouthMoves( board, numMoves );
        List<String> eastMoves = calculateEastMoves( board, numMoves );
        List<String> westMoves = calculateWestMoves( board, numMoves );
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
}
