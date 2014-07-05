/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.mediador;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JList;
import trabalhotpa.teste.gui.Janela;
import trabalhotpa.teste.modelos.Aresta;
import trabalhotpa.teste.modelos.Grafo;

/**
 *
 * @author danieljr
 */
public class MediadorAresta implements Mediador {

    JList<String> listaAresta;
    Vector<String> itensAresta;
    Grafo grafo;
    Map<String, Aresta> mapa;

    public MediadorAresta(JList<String> listaAresta, Vector<String> itensAresta, Grafo grafo) {
        this.listaAresta = listaAresta;
        this.itensAresta = itensAresta;
        this.grafo = grafo;
        mapa = new HashMap<String, Aresta>();
    }

    @Override
    public void addAresta(Aresta aresta, String vertices) {
        String chave = vertices + " = " + aresta.toString();
        itensAresta.add(chave);
        listaAresta.setListData(itensAresta);
        mapa.put(chave, aresta);
    }

    @Override
    public void excluiAresta(Janela janela) {
        String chave = listaAresta.getSelectedValue();
        Aresta a = mapa.remove(chave);
        grafo.removeEdge(a);
        itensAresta.remove(
                listaAresta.getSelectedIndex());
        listaAresta.repaint();
        janela.repaint();
    }
}
