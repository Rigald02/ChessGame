package fr.rphstudio.chess.game;

import java.util.ArrayList;
import java.util.List;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;

public class Bishop implements IMove{
	
	public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Plateau plat) {
		
		ArrayList<ChessPosition> possibleMoves = new ArrayList<ChessPosition>();
		
		ChessColor temp = plat.getElement(p).get_color();
		
		ChessPosition tmpPos;
		
		//bas
		for(int i=1;i<IChess.BOARD_HEIGHT;i++)
		{
			tmpPos = new ChessPosition(p.x-i, p.y-i);
			if(tmpPos.x >= 0 && tmpPos.y >= 0)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess == null)
				{
					possibleMoves.add(tmpPos);
					continue;
				}
				else if (chess.get_color() == temp)
				{
					break;
				}
				else
				{
					possibleMoves.add(tmpPos);
					break;
				}
			}
			else
			{
				break;
			}
		}
	
		for(int i=1;i<IChess.BOARD_HEIGHT;i++)
		{
			tmpPos = new ChessPosition(p.x+i, p.y-i);
			if(tmpPos.x < IChess.BOARD_WIDTH &&  tmpPos.y >= 0)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess == null)
				{
					possibleMoves.add(tmpPos);
					continue;
				}
				else if (chess.get_color() == temp)
				{
					break;
				}
				else
				{
					possibleMoves.add(tmpPos);
					break;
				}
			}
			else
			{
				break;
			}
		}
		//haut
		for(int i=1;i<IChess.BOARD_HEIGHT;i++)
		{
			tmpPos = new ChessPosition(p.x+i, p.y+i);
			if(tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess == null)
				{
					possibleMoves.add(tmpPos);
					continue;
				}
				else if (chess.get_color() == temp)
				{
					break;
				}
				else
				{
					possibleMoves.add(tmpPos);
					break;
				}
			}
			else
			{
				break;
			}
		}
		for(int i=1;i<IChess.BOARD_HEIGHT;i++)
		{
			tmpPos = new ChessPosition(p.x-i, p.y+i);
			if(tmpPos.x >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess == null)
				{
					possibleMoves.add(tmpPos);
					continue;
				}
				else if (chess.get_color() == temp)
				{
					break;
				}
				else
				{
					possibleMoves.add(tmpPos);
					break;
				}
			}
			else
			{
				break;
			}
		}
		
	 
	 return possibleMoves;
	 
	}
}
