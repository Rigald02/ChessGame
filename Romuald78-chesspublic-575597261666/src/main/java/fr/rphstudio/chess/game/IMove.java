/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.List;
/**
 *
 * @author vlad
 */
public interface IMove {
    
    List<ChessPosition> getPossibleMoves(ChessPosition p, Plateau plat);
       
}