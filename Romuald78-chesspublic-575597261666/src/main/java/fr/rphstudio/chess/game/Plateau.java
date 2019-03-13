/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;

/**
 *
 * @author vlad
 */
public class Plateau {
    
    private Piece[][] tableau;
    
    public Plateau()
    {
        this.tableau = new Piece[IChess.BOARD_HEIGHT][IChess.BOARD_WIDTH];
        this.init();
    }
    
    private void init()
    {
        IMove move;
        
        for (int y = 0; y < IChess.BOARD_HEIGHT; y++){
            for (int x = 0; x < IChess.BOARD_WIDTH; x++){
               IChess.ChessColor col;
               move = new Knight();
               
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
               
               if ((y + 1) == IChess.BOARD_POS_Y_BLACK_PAWNS || (y - 1) == IChess.BOARD_POS_Y_WHITE_PAWNS){
                switch (x){
                   
                   case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                   case IChess.BOARD_POS_X_QUEENSIDE_ROOK:
                       typ = IChess.ChessType.TYP_ROOK;
                       break;
                       
                   case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                   case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:
                       typ = IChess.ChessType.TYP_BISHOP;
                       break;
                       
                   case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                   case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
                       typ = IChess.ChessType.TYP_KNIGHT;
                       break;
                       
                   case IChess.BOARD_POS_X_KING:
                       typ = IChess.ChessType.TYP_KING;
                       break;
                       
                   case IChess.BOARD_POS_X_QUEEN:
                       typ = IChess.ChessType.TYP_QUEEN;
                       break;
                  
               }
               }
               
               this.tableau[y][x] = new Piece(col, typ, move);
               
            }
        }
    }
    
    public Piece getElement(IChess.ChessPosition p){
        return this.tableau[p.y][p.x];
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
}