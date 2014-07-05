/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.fachada;

import java.util.Vector;
import javax.swing.JList;
import org.apache.commons.collections15.Factory;
import trabalhotpa.teste.comando.Comando;
import trabalhotpa.teste.gui.Janela;
import trabalhotpa.teste.modelos.Grafo;
import trabalhotpa.teste.observador.Observador;

/**
 *
 * @author Daniel Junior
 */
public interface Operacoes {

    public Grafo getGrafo();

    public void executarAlgoritmo(Comando comando);

    public Object[] vertices();

    public void addObservador(Observador obsservador);

    public Factory getFabricaVertices();

    public Factory getFabricaArestas();

    public void addColaboradores (JList<String> listaVertices, Vector<String> itensVertices);

   public void excluirAresta(Janela janela);
}
