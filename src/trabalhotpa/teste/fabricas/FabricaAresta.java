/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.fabricas;

import trabalhotpa.teste.modelos.Aresta;
import javax.swing.JOptionPane;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Daniel Junior
 */
public class FabricaAresta implements Factory<Aresta> {

    @Override
    public Aresta create() {
        String msg = JOptionPane.showInputDialog("Qual o valor da aresta?");
        msg = msg.replace(",", ".");
        double valor;
        if (msg == null) {
            valor = 0;
        } else {
            valor = Double.parseDouble(msg);
        }
        return new Aresta(valor);
    }
}
