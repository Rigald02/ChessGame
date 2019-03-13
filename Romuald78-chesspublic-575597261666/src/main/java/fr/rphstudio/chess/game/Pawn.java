package fr.rphstudio.chess.game;

import java.util.ArrayList;
import java.util.List;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;

public class Pawn implements IMove{
	public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Plateau plat){
		
	ArrayList<ChessPosition> possibleMoves = new ArrayList<ChessPosition>();

	ChessPosition tmpPos;

	tmpPos = new ChessPosition(p.x, p.y+1);
    if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
    {
    	possibleMoves.add(tmpPos);
    }

	return possibleMoves;
	}
}
