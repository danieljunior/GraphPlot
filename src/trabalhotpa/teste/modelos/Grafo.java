/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.modelos;

import trabalhotpa.teste.observador.Sujeito;
import trabalhotpa.teste.observador.Observador;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.ArrayList;
import java.util.List;
import trabalhotpa.teste.mediador.Mediador;

/**
 *
 * @author Daniel Junior
 */
public class Grafo extends UndirectedSparseGraph<Vertice, Aresta> implements Sujeito {

    private List<Observador> observadores;
    private Vertice v1 = null, vn = null;
    private Mediador mediador;

    public Grafo() {
        super();
        observadores = new ArrayList<>();
    }

    @Override
    public boolean addVertex(Vertice vertex) {
        boolean resp = super.addVertex(vertex);
        if (v1 == null) {
            v1 = vertex;
        }
        vn = vertex;
        notificar();
        return resp; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addEdge(Aresta e, Vertice v1, Vertice v2, EdgeType edge_type) {
        try {
            mediador.addAresta(e, "(" + v1 + " -> " + v2 + ")");
        } catch (Exception ex) {
            System.out.println("Execução de algoritmo");
        }
        return super.addEdge(e, v1, v2, edge_type); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeEdge(Aresta edge) {
        return super.removeEdge(edge);
    }

    public Vertice getV1() {
        return v1;
    }

    public Vertice getVn() {
        return vn;
    }

    @Override
    public void addObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removeObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar() {
        for (Observador o : observadores) {
            o.atualizar();
        }
    }

    public void setMediador(Mediador m) {
        mediador = m;
    }
}
