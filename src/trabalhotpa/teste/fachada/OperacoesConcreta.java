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
import trabalhotpa.teste.controlador.ControladorGrafo;
import trabalhotpa.teste.gui.Janela;
import trabalhotpa.teste.mediador.Mediador;
import trabalhotpa.teste.mediador.MediadorAresta;
import trabalhotpa.teste.modelos.Grafo;
import trabalhotpa.teste.observador.Observador;

/**
 *
 * @author Daniel Junior
 */
public class OperacoesConcreta implements Operacoes {

    private ControladorGrafo controladorGrafo;
    private Mediador mediador;

    public OperacoesConcreta() {
        controladorGrafo = new ControladorGrafo();
    }

    @Override
    public Grafo getGrafo() {
        return controladorGrafo.getG();
    }

    @Override
    public void executarAlgoritmo(Comando comando) {
        comando.executar(controladorGrafo.getG());
    }

    @Override
    public Object[] vertices() {
        return controladorGrafo.getG().getVertices().toArray();
    }

    @Override
    public void addObservador(Observador observador) {
        controladorGrafo.getG().addObservador(observador);
    }

    @Override
    public Factory getFabricaVertices() {
        return controladorGrafo.getVertexFactory();
    }

    @Override
    public Factory getFabricaArestas() {
        return controladorGrafo.getEdgeFactory();
    }

    @Override
    public void addColaboradores(JList<String> listaVertices, Vector<String> itensVertices) {
        mediador = new MediadorAresta(listaVertices, itensVertices, controladorGrafo.getG());
        controladorGrafo.getG().setMediador(mediador);
    }

    @Override
    public void excluirAresta(Janela janela) {
        mediador.excluiAresta(janela);
    }
}
