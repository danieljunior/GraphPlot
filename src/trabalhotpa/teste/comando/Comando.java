/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.comando;

import trabalhotpa.teste.gui.VisualizadorAlgoritmo;
import trabalhotpa.teste.modelos.Grafo;
import trabalhotpa.teste.strategy.Algoritmo;

/**
 *
 * @author Daniel Junior
 */
public abstract class Comando {

    private Algoritmo algoritmo;
    private VisualizadorAlgoritmo visualizador;

    public void executar(Grafo g) {
        algoritmo = setAlgoritmo();
        String resp = algoritmo.executarAlgoritmo(g);
        visualizador = VisualizadorAlgoritmo.getInstance(algoritmo.descricao(), resp);
        visualizador.setVisible(true);
    }

    public abstract Algoritmo setAlgoritmo();
}
