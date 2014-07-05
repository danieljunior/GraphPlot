/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhotpa.teste.fabricas;

import trabalhotpa.teste.modelos.Vertice;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Daniel Junior
 */
public class FabricaVertice implements Factory<Vertice> {

    @Override
    public Vertice create() {
        return new Vertice();
    }
    
}
