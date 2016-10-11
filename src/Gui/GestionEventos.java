package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by cristhian on 11/10/16.
 */
public class GestionEventos implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;


    public GestionEventos(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public static final String BTN_CSV = "AGREGAR CSV AL PROGRAMA";
    public static final String BTN_CALCULAR = "CALCULA PRIODIADES Y MUESTRA EN LA TABLA ORDENADA";

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(BTN_CSV)){
            try {
                ventanaPrincipal.btnCsvFunc();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else if (e.getActionCommand().equals(BTN_CALCULAR)){
            ventanaPrincipal.btnCalcularFunc();
        }
    }
}
