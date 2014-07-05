/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.comando;

import trabalhotpa.teste.strategy.Algoritmo;
import trabalhotpa.teste.strategy.GeradorMinimo;

/**
 *
 * @author Daniel Junior
 */
public class ComandoGeradoraMinima extends Comando {

    @Override
    public Algoritmo setAlgoritmo() {
        return new GeradorMinimo();
    }

}
