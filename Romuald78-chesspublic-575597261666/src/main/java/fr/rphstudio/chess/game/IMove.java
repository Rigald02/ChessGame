/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
/**
 *
 * @author vlad
 */
public interface IMove {
    
    ArrayList<ChessPosition> getPossibleMoves(ChessPosition p);
    
}