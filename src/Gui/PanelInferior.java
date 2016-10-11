package Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by cristhian on 10/10/16.
 */
public class PanelInferior extends JPanel{

    private VentanaPrincipal ventanaPrincipal;

    public PanelInferior(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.setBorder(new TitledBorder("Acciones: "));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        beginComponents();
        addComponents();

    }

    private void addComponents() {
    }

    private void beginComponents() {
        
    }
}
