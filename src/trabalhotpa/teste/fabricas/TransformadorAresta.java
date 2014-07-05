/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.fabricas;

import org.apache.commons.collections15.Transformer;
import trabalhotpa.teste.modelos.Aresta;

/**
 *
 * @author danieljr
 */
public class TransformadorAresta implements Transformer<Aresta, Double> {

    @Override
    public Double transform(Aresta i) {
        return i.getPeso();
    }
}
