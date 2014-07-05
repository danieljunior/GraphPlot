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
public class Vertice implements Comparable<Vertice> {

    public int getId() {
        return id;
    }
    private int id;
    private static int cont = 1;

    public Vertice() {
        this.id = cont++;
    }

    @Override
    public String toString() {
        return "V" + id;
    }

    @Override
    public int compareTo(Vertice o) {
        return this.id - o.getId();
    }
}
