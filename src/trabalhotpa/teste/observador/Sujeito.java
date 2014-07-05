/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhotpa.teste.observador;

/**
 *
 * @author Daniel Junior
 */
public interface Sujeito {
    
public void addObservador(Observador o);
public void removeObservador(Observador o);
public void notificar();
    
}
