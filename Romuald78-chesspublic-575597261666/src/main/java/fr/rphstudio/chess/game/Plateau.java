/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import java.util.ArrayList;
import java.util.List;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author vlad
 */
public class Plateau {
    
    private Piece[][] tableau;
    private List<Piece[][]> all_tableau;
    
    
    public Plateau()
    {
        this.tableau = new Piece[IChess.BOARD_HEIGHT][IChess.BOARD_WIDTH];
        this.init();
        this.all_tableau = new ArrayList();
    }
    
    public List<Piece[][]> get_all_tableau(){
    	return this.all_tableau;
    }
    
    public void set_tableau(Piece[][] tab) {
    	this.tableau = tab;
    }
    
    private void init()
    {
        
        for (int y = 0; y < IChess.BOARD_HEIGHT; y++){
            for (int x = 0; x < IChess.BOARD_WIDTH; x++){
               IChess.ChessColor col;
               
              
               
               if (y <= IChess.BOARD_POS_Y_BLACK_PAWNS){
                   col = IChess.ChessColor.CLR_BLACK;
               }
               else if (y >= IChess.BOARD_POS_Y_WHITE_PAWNS){
                    col = IChess.ChessColor.CLR_WHITE;
               }
               else {
                   continue;
               }
               
               IChess.ChessType typ = IChess.ChessType.TYP_PAWN;     
               IMove move = new Pawn();
               
               if ((y + 1) == IChess.BOARD_POS_Y_BLACK_PAWNS || (y - 1) == IChess.BOARD_POS_Y_WHITE_PAWNS){
                switch (x){
                   
                   case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                   case IChess.BOARD_POS_X_QUEENSIDE_ROOK:
                       typ = IChess.ChessType.TYP_ROOK;
                       move = new Rook();
                       break;
                       
                   case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                   case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:
                       typ = IChess.ChessType.TYP_BISHOP;
                       move = new Bishop();
                       break;
                       
                   case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                   case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
                       typ = IChess.ChessType.TYP_KNIGHT;
                       move = new Knight();
                       break;
                       
                   case IChess.BOARD_POS_X_KING:
                       typ = IChess.ChessType.TYP_KING;
                       move = new King();
                       break;
                       
                   case IChess.BOARD_POS_X_QUEEN:
                	   typ = IChess.ChessType.TYP_QUEEN;
                	   move = new Queen();
                       break;
                  
               }
               }
               
               this.tableau[y][x] = new Piece(col, typ, move);
               
            }
        }
    }
    
    public Piece[][] get_tableau(){
    	return this.tableau;
    }
    
    public Piece getElement(IChess.ChessPosition p){
    	if (p.x < IChess.BOARD_WIDTH && p.y < IChess.BOARD_HEIGHT)
    		return this.tableau[p.y][p.x];
    	return null;
    }
    
    public int getRemainingElements(IChess.ChessColor col) {
        int result = 0;
        for (int y = 0; y < ChessModel.BOARD_HEIGHT; y++){
            for (int x = 0; x < ChessModel.BOARD_WIDTH; x++){
                Piece temp = this.tableau[y][x];
                if (temp == null){
                    continue;
                }
            
                if (temp.get_color() == col){
                    result++;
                }
            }
        }
        return result;
    }

	public void setNewPosition(ChessPosition p0, ChessPosition p1) {
		// TODO Auto-generated method stub
		if (this.getElement(p0) == null)
			return;
		this.get_tableau()[p1.y][p1.x] = this.get_tableau()[p0.y][p0.x];
		this.get_tableau()[p0.y][p0.x] = null;
	}

	public boolean checkKingState(ChessColor color, Plateau plat) {
		// TODO Auto-generated method stub
		for(int y = 0; y<IChess.BOARD_HEIGHT; y++)
		{
			for (int x = 0; x<IChess.BOARD_WIDTH; x++)
			{
				Piece temp = this.getElement(new ChessPosition(x, y));
				if(temp == null || temp.get_color()== color)
				{
					continue;
				}
				else
				{
					ChessPosition kingPos = this.getkingPos();
					List<ChessPosition> possibleMoves = temp.getMoves(new ChessPosition(x,y), plat);
					for(int i=0; i<possibleMoves.size(); i++)
					{
						if(kingPos.x == possibleMoves.get(i).x && kingPos.y == possibleMoves.get(i).y  )
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private ChessPosition getkingPos() {
		// TODO Auto-generated method stub
		for(int y = 0; y<IChess.BOARD_HEIGHT; y++)
		{
			for (int x = 0; x<IChess.BOARD_WIDTH; x++)
			{
				Piece temp = this.getElement(new ChessPosition(x, y));
				if(temp == null || temp.get_type() != IChess.ChessType.TYP_KING)
				{
					continue;
				}
				else
				{
					return new ChessPosition(x, y);
				}
			}
		}
		return null;
	}
}