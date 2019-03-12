/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

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
        
    }
}
