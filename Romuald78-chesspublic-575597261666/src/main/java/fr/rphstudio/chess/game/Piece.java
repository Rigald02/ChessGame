/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vlad
 */
public class Piece {
	private ChessColor color;
	private ChessType type;
	private IMove imove;

	public Piece(ChessColor col, ChessType typ, IMove move)
	{
		this.color = col;
		this.type = typ;
		this.imove = move;
	}

	void set_color(ChessColor color)
	{
		this.color = color;
	}

	public ChessColor get_color()
	{
		return this.color;
	}

	public void set_type(ChessType type)
	{
		this.type = type;
	}

	public ChessType get_type()
	{
		return this.type;
	}

	public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Plateau tab){
		return this.imove.getPossibleMoves(p, tab);
	}
}