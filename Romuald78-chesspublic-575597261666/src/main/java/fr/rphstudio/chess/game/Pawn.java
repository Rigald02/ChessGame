package fr.rphstudio.chess.game;

import java.util.ArrayList;
import java.util.List;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;

public class Pawn implements IMove{


	public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Plateau plat){

		ArrayList<ChessPosition> possibleMoves = new ArrayList<ChessPosition>();

		Piece chesstemp = plat.getElement(p);

		ChessColor temp = chesstemp.get_color();

		ChessPosition tmpPos;

		if(temp == ChessColor.CLR_BLACK)
		{
			tmpPos = new ChessPosition(p.x, p.y+1);
			if(tmpPos.y < IChess.BOARD_HEIGHT)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess == null)
				{
					if (p.y == IChess.BOARD_POS_Y_BLACK_PAWNS)
					{
						possibleMoves.add(tmpPos);
						tmpPos = new ChessPosition(p.x, p.y+2);
						chess = plat.getElement(tmpPos);
						if(chess == null)
						{
							possibleMoves.add(tmpPos);
						}
					}
					else
					{
						possibleMoves.add(tmpPos);
					}
				}					
			}

			tmpPos = new ChessPosition(p.x-1, p.y+1);
			if(tmpPos.x >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess != null && chess.get_color() != temp)
				{
					possibleMoves.add(tmpPos);
				}
			}
			tmpPos = new ChessPosition(p.x+1, p.y+1);
			if(tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y < IChess.BOARD_HEIGHT)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess != null && chess.get_color() != temp)
				{
					possibleMoves.add(tmpPos);
				}
			}
		}

		else
		{
			tmpPos = new ChessPosition(p.x, p.y-1);
			if(tmpPos.y >= 0)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess == null)
				{
					if (p.y == IChess.BOARD_POS_Y_WHITE_PAWNS)
					{
						possibleMoves.add(tmpPos);
						tmpPos = new ChessPosition(p.x, p.y-2);
						chess = plat.getElement(tmpPos);
						if(chess == null)
						{
							possibleMoves.add(tmpPos);
						}
					}
					else
					{
						possibleMoves.add(tmpPos);
					}
				}
			}
			tmpPos = new ChessPosition(p.x-1, p.y-1);
			if(tmpPos.x >= 0 && tmpPos.y >= 0)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess != null && chess.get_color() != temp)
				{
					possibleMoves.add(tmpPos);
				}
			}
			tmpPos = new ChessPosition(p.x+1, p.y-1);
			if(tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0)
			{
				Piece chess = plat.getElement(tmpPos);
				if(chess != null && chess.get_color() != temp)
				{
					possibleMoves.add(tmpPos);
				}
			}
		}

		return possibleMoves;
	}


}

