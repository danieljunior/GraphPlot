/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the controladorGrafo.
 */
package trabalhotpa.teste.gui;

import java.awt.event.KeyEvent;
import trabalhotpa.teste.modelos.Vertice;
import trabalhotpa.teste.modelos.Aresta;
import trabalhotpa.teste.observador.Observador;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import trabalhotpa.teste.comando.ComandoCaminhoMinimo;
import trabalhotpa.teste.comando.ComandoGeradoraMinima;
import trabalhotpa.teste.fachada.Operacoes;
import trabalhotpa.teste.fachada.OperacoesConcreta;
import trabalhotpa.teste.strategy.Algoritmo;

/**
 *
 * @author Daniel Junior
 */
public class Janela extends JFrame implements Observador {

    Layout<Vertice, Aresta> layoutGrafo;
    VisualizationViewer<Vertice, Aresta> panelVisualizadorGrafo;
    EditingModalGraphMouse controladorMouseGrafo;
    JList<String> listaVertices, listaArestas;
    Vector<String> itensVertices, itensArestas;
    Algoritmo alg = null;
    VisualizadorAlgoritmo visualizadorAlgoritmo;
    Operacoes operacoes;

    public Janela() {
        super("Algoritmos em Grafos");
        operacoes = new OperacoesConcreta();
        operacoes.addObservador(this);
        layoutGrafo = new StaticLayout(operacoes.getGrafo());
        panelVisualizadorGrafo = new VisualizationViewer<>(layoutGrafo);
        controladorMouseGrafo = new EditingModalGraphMouse(panelVisualizadorGrafo.getRenderContext(),
                operacoes.getFabricaVertices(), operacoes.getFabricaArestas());
        initGUI();
        operacoes.addColaboradores(listaArestas, itensArestas);
    }

    private void initGUI() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        initGraphOptions();
        initMenus();
        initPanels();

    }

    private void initMenus() {
        JMenuBar menubar = new JMenuBar();

        JMenu menuGrafo = controladorMouseGrafo.getModeMenu();
        menuGrafo.setText("Opções do Grafo");
        menuGrafo.setIcon(null);
        menuGrafo.setPreferredSize(new Dimension(130, 20));

        controladorMouseGrafo.setMode(ModalGraphMouse.Mode.EDITING); // iniciar o modo do mouse para edição de grafo

        JMenu menuAlgoritmos = new JMenu("Algoritmos");

        JMenuItem item = new JMenuItem("Geradora Mínima");
        JMenuItem item2 = new JMenuItem("Caminho Mínimo");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.executarAlgoritmo(new ComandoGeradoraMinima());
            }
        });
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                operacoes.executarAlgoritmo(new ComandoCaminhoMinimo());
            }
        });
        menuAlgoritmos.add(item);
        menuAlgoritmos.add(item2);

        menubar.add(menuAlgoritmos);
        menubar.add(menuGrafo);

        setJMenuBar(menubar);
    }

    private void initPanels() {
        itensVertices = new Vector<>();
        itensArestas =  new Vector<>();
        listaVertices = new JList<>(itensVertices);
        listaArestas = new JList<>(itensArestas);

        listaArestas.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    operacoes.excluirAresta(Janela.this);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        JPanel panelInferior = new JPanel();
        panelInferior.setBorder(BorderFactory.createMatteBorder(3, 1, 1, 1, Color.BLACK));

        JScrollPane scrollVertices = new JScrollPane(listaVertices);
        scrollVertices.add(new JLabel("Vértices"));
        scrollVertices.setPreferredSize(new Dimension(300, 150));

        JScrollPane scrollArestas = new JScrollPane(listaArestas);
        scrollArestas.setPreferredSize(new Dimension(300, 150));

        panelInferior.add(new JLabel("Vértices: "));
        panelInferior.add(scrollVertices);
        panelInferior.add(new JLabel("Arestas: "));
        panelInferior.add(scrollArestas);
        getContentPane().add(panelInferior);
    }

    private void initGraphOptions() {
        layoutGrafo.setSize(new Dimension(300, 300));
        panelVisualizadorGrafo.setPreferredSize(new Dimension(350, 350));
        // Show vertex and edge labels
        panelVisualizadorGrafo.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        panelVisualizadorGrafo.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        // Create a graph mouse and add it to the visualization viewer
        // Our Vertices are going to be Integer objects so we need an Integer factory
        panelVisualizadorGrafo.setGraphMouse(controladorMouseGrafo);
        getContentPane().add(panelVisualizadorGrafo, BorderLayout.PAGE_START);
    }

    @Override
    public void atualizar() {

        Object[] vertices = operacoes.vertices();
        Arrays.sort(vertices);
        itensVertices.removeAllElements();
        for (Object v : vertices) {
            Vertice a = (Vertice) v;
            itensVertices.add(a.toString());
        }
        listaVertices.setListData(itensVertices);
    }
}
