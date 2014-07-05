/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.fabricas;

import org.apache.commons.collections15.Factory;
import trabalhotpa.teste.modelos.Grafo;

/**
 *
 * @author danieljr
 */
public class FabricaGrafo implements Factory<Grafo> {

    @Override
    public Grafo create() {
        return new Grafo();
    }
}
