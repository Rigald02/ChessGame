/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author vlad
 */

public class Piece {

    private ChessColor color;
    private ChessType type;
    
    public Piece(ChessColor col, ChessType typ)
    {
        this.color = col;
        this.type = typ;
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
}
