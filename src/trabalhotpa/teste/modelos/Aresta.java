/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.modelos;

/**
 *
 * @author Daniel Junior
 */
public class Aresta {

    private double peso;
    int id;
    private static int cont = 1;

    public Aresta(double peso) {
        this.id = cont++;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "" + peso;
    }

    public double getPeso() {
        return peso;
    }
}
