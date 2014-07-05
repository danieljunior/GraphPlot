/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.strategy;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import java.util.List;
import trabalhotpa.teste.fabricas.TransformadorAresta;
import trabalhotpa.teste.modelos.Aresta;
import trabalhotpa.teste.modelos.Grafo;
import trabalhotpa.teste.modelos.Vertice;

/**
 *
 * @author Daniel Junior
 */
public class CaminhoMinimo implements Algoritmo {

    @Override
    public String executarAlgoritmo(Grafo g) {
        String resp = "";
        Vertice v1 = g.getV1();
        Vertice v2 = g.getVn();
        TransformadorAresta tranformador = new TransformadorAresta();
        try {
            DijkstraShortestPath<Vertice, Aresta> caminhoMinimo = new DijkstraShortestPath(g,
                    tranformador);
            List<Aresta> arestas = caminhoMinimo.getPath(v1, v2);
            Number distancia = caminhoMinimo.getDistance(v1, v2);
            resp = "O caminho mínimo entre " + v1 + " e " + v2 + " é: " + arestas.toString() + "\nDistância: " + distancia;
        } catch (Exception e) {
            resp = "Impossível";
        } finally {
            return resp;
        }
    }

    @Override
    public String descricao() {
        return "Caminho Mínimo";
    }
}
