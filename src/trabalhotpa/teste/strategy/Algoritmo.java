/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhotpa.teste.strategy;

import trabalhotpa.teste.modelos.Grafo;

/**
 *
 * @author danieljr
 */
public interface Algoritmo {

    public String executarAlgoritmo(Grafo g);
    public String descricao();

}
