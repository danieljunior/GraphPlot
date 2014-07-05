/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.strategy;

import edu.uci.ics.jung.algorithms.shortestpath.PrimMinimumSpanningTree;
import trabalhotpa.teste.fabricas.FabricaGrafo;
import trabalhotpa.teste.fabricas.TransformadorAresta;
import trabalhotpa.teste.modelos.Aresta;
import trabalhotpa.teste.modelos.Grafo;
import trabalhotpa.teste.modelos.Vertice;

/**
 *
 * @author danieljr
 */
public class GeradorMinimo implements Algoritmo {

    PrimMinimumSpanningTree<Vertice, Aresta> prim;

    public GeradorMinimo() {
        prim = new PrimMinimumSpanningTree<>(new FabricaGrafo(), new TransformadorAresta());
    }

    @Override
    public String executarAlgoritmo(Grafo g) {
        Grafo grafo = (Grafo) prim.transform(g);
        return grafo.toString();
    }

    @Override
    public String descricao() {
        return "Gerador Mínimo";
    }
}
