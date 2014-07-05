/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author danieljr
 */
public class VisualizadorAlgoritmo extends JFrame {
    
    private static VisualizadorAlgoritmo instance = null;
    private JScrollPane scroll;
    private JTextArea area;
    
    private VisualizadorAlgoritmo(String nome, String resposta) {
        super("Console - " + nome);
        initGUI(resposta);
    }
    
    public static VisualizadorAlgoritmo getInstance(String nome, String resposta) {
        if (instance == null) {
            instance = new VisualizadorAlgoritmo(nome, resposta);
        }
        instance.setTitle("Console - " + nome);
        instance.area.setText(resposta);
        return instance;
    }
    
    private void initGUI(String resposta) {
        setSize(400, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        area = new JTextArea();
        area.setEditable(false);
        area.setText(resposta);
        scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll);
    }
}
