/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.controlador;

import trabalhotpa.teste.fabricas.FabricaAresta;
import trabalhotpa.teste.fabricas.FabricaVertice;
import trabalhotpa.teste.modelos.Grafo;

/**
 *
 * @author Daniel Junior
 */
public class ControladorGrafo {

    private final Grafo grafo;
    private final FabricaVertice fabricaVertices;
    private final FabricaAresta fabricaAresta;

   public ControladorGrafo() {
        // Graph<V, E> where V is the type of the vertices and E is the type of the edges
        grafo = new Grafo();
        fabricaVertices = new FabricaVertice();
        fabricaAresta = new FabricaAresta();
    }

    public int getContadorVertice() {
        return grafo.getVertexCount();
    }

    public int getContadorAresta() {
        return grafo.getEdgeCount();
    }

    public FabricaAresta getEdgeFactory() {
        return fabricaAresta;
    }

    public Grafo getG() {
        return grafo;
    }

    public FabricaVertice getVertexFactory() {
        return fabricaVertices;
    }

}
