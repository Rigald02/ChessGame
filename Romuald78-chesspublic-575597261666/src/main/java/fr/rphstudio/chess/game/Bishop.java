package fr.rphstudio.chess.game;

import java.util.ArrayList;
import java.util.List;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;

public class Bishop implements IMove{
	
	public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Plateau plat) {
		
		ArrayList<ChessPosition> possibleMoves = new ArrayList<ChessPosition>();
	
		ChessPosition tmpPos;

		//haut
		for(int i=1;i<IChess.BOARD_HEIGHT;i++)
		{
			tmpPos = new ChessPosition(p.x-i, p.y-i);
			if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				possibleMoves.add(tmpPos);
			}
		}
		for(int i=1;i<IChess.BOARD_HEIGHT;i++)
		{
			tmpPos = new ChessPosition(p.x+i, p.y+i);
			if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				possibleMoves.add(tmpPos);
			}
		}
		//bas
		for(int i=1;i<IChess.BOARD_HEIGHT;i--)
		{
			tmpPos = new ChessPosition(p.x-i, p.y-i);
			if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				possibleMoves.add(tmpPos);
			}
		}
		for(int i=1;i<IChess.BOARD_HEIGHT;i--)
		{
			tmpPos = new ChessPosition(p.x+i, p.y+i);
			if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				possibleMoves.add(tmpPos);
			}
		}
		
	 
	 return possibleMoves;
	 
	}
}
