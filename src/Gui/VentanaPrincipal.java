package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cristhian on 10/10/16.
 */
public class VentanaPrincipal extends JFrame {

    private PanelMedio panelMedio;
    private PanelInferior panelInferior;

    public VentanaPrincipal()  {
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Procesos");
        this.setLayout(new BorderLayout());
        beginComponets();
        addComponents();
    }

    private void beginComponets() {
        panelMedio = new PanelMedio(this);
        panelInferior = new PanelInferior(this);

    }

    private void addComponents() {

        this.add(panelMedio,BorderLayout.CENTER);
        this.add(panelInferior,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(true);
    }

    public PanelMedio getPanelMedio() {
        return panelMedio;
    }

    public void setPanelMedio(PanelMedio panelMedio) {
        this.panelMedio = panelMedio;
    }

    public PanelInferior getPanelInferior() {
        return panelInferior;
    }

    public void setPanelInferior(PanelInferior panelInferior) {
        this.panelInferior = panelInferior;
    }
}
