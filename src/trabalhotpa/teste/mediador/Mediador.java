/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.mediador;

import trabalhotpa.teste.gui.Janela;
import trabalhotpa.teste.modelos.Aresta;

/**
 *
 * @author danieljr
 */
public interface Mediador {

    public void excluiAresta(Janela janela);

    public void addAresta(Aresta aresta, String vertices);
}
