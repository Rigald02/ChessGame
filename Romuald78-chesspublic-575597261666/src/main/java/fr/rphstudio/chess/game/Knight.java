/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vlad
 */
public class Knight implements IMove{

	public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition p, Plateau plat){

		ArrayList<ChessPosition> possibleMoves = new ArrayList<ChessPosition>();

		ChessColor temp = plat.getElement(p).get_color();

		ChessPosition tmpPos;

		// Top
		tmpPos = new ChessPosition(p.x-1, p.y-2);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);
			}
		}
		tmpPos = new ChessPosition(p.x+1, p.y-2);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);
			}
		}
		tmpPos = new ChessPosition(p.x-1, p.y+2);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);
			}
		}
		tmpPos = new ChessPosition(p.x+1, p.y+2);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);
			}
		}
		// Right
		tmpPos = new ChessPosition(p.x+2, p.y-1);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);
			}
		}     
		tmpPos = new ChessPosition(p.x+2, p.y+1);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);	
			}
		}
		tmpPos = new ChessPosition(p.x-2, p.y-1);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);		
			}
		}       
		tmpPos = new ChessPosition(p.x-2, p.y+1);
		if(tmpPos.x >= 0 && tmpPos.x < IChess.BOARD_WIDTH && tmpPos.y >= 0 && tmpPos.y < IChess.BOARD_HEIGHT)
		{
			Piece chess = plat.getElement(tmpPos);
			if(chess == null)
			{
				possibleMoves.add(tmpPos);
			}
			else if (chess.get_color() != temp)
			{
				possibleMoves.add(tmpPos);
			}
		}


		return possibleMoves;
	}

}
