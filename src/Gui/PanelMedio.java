package Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by cristhian on 10/10/16.
 */
public class PanelMedio extends JPanel {

    private VentanaPrincipal ventanaPrincipal;

    private JPanel pn1,pn2;

    private JTable tablaProcesos;
    private JTable tablaProcesosOrdenada;

    private DefaultTableModel modeloTablaProceso;
    private DefaultTableModel modeloTablaProcesoOrdenado;


    public PanelMedio(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.setBorder(new TitledBorder("Datos "));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(1,1));
        pn2 = new JPanel();
        pn2.setLayout(new GridLayout(1,1));

        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        pn1.setBorder(new TitledBorder("Tabla de Procesos: "));
        String[] ColsProcesos = {"Trabajo","Rafaga CPU","Tiempo de llegada","Prioridad"};
        modeloTablaProceso = new DefaultTableModel(ColsProcesos,0);
        tablaProcesos = new JTable(modeloTablaProceso);

        pn2.setBorder(new TitledBorder("Tabla de procesos Ordenada: "));
        String[]  ColsProcesosOrdenado = {"Orden","Trabajo","Rafaga CPU","Tiempo de llegada","Prioridad","Tiempo Espera","Tiempo de retorno"};
        modeloTablaProcesoOrdenado = new DefaultTableModel(ColsProcesosOrdenado,0);
        tablaProcesosOrdenada = new JTable(modeloTablaProcesoOrdenado);




    }

    private void addComponents() {
        pn1.add(new JScrollPane(tablaProcesos));
        pn2.add(new JScrollPane(tablaProcesosOrdenada));

        this.add(pn1);
        this.add(pn2);

    }
}
