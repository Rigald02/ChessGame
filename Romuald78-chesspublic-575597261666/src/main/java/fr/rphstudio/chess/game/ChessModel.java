/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vlad
 */
public class ChessModel implements IChess {
	private static ChessModel instance;
	private Plateau plateau;


	public Plateau getPlateau()
	{
		return this.plateau;
	}

	private ChessModel ()
	{
		this.reinit();
	}




	static public ChessModel getInstance()
	{
		if(ChessModel.instance == null)
		{
			ChessModel.instance = new ChessModel();
		}
		return ChessModel.instance;
	}

	public long getPlayerDuration(ChessColor color, boolean isPlaying)
	{
		return 0;
	}
	@Override
	public void reinit() {
		this.plateau = new Plateau();
	}
	@Override
	public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {

		Piece temp = this.plateau.getElement(p);
		if (temp == null){
			throw new EmptyCellException();

		}
		return temp.get_type();
	}
	@Override
	public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
		Piece temp = this.plateau.getElement(p);
		if (temp == null){
			throw new EmptyCellException();
		}
		return temp.get_color();
	}
	@Override
	public int getNbRemainingPieces(ChessColor color) {
		return this.plateau.getRemainingElements(color);
	}
	@Override
	public List<ChessPosition> getPieceMoves(ChessPosition p) {

		Piece temp = plateau.getElement(p);

		if (temp == null){
			return new ArrayList<ChessPosition>();
		}
		return temp.getMoves(p, plateau);

	}
	@Override
	public void movePiece(ChessPosition p0, ChessPosition p1) {
		plateau.setNewPosition(p0, p1);
		List<Piece[][]> tab = this.getPlateau().get_all_tableau();
		Piece[][] bob = this.getPlateau().get_tableau();
		tab.add(bob);
	}
	@Override
	public ChessKingState getKingState(ChessColor color) {
		if(plateau.checkKingState(color, this.getPlateau()) == true)
		{
			return ChessKingState.KING_THREATEN;
		}
		else
		{
			return ChessKingState.KING_SAFE;
		}
	}
	@Override
	public List<ChessType> getRemovedPieces(ChessColor color) {
		return new ArrayList<ChessType>();
	}
	@Override
	public boolean undoLastMove() {
		List<Piece[][]> temp = this.getPlateau().get_all_tableau();
		if (temp.size() > 1) {
			this.getPlateau().set_tableau(temp.get(temp.size() - 2));
			return true;
		}
		return false;
	}

}