package Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by cristhian on 10/10/16.
 */
public class PanelInferior extends JPanel{

    private VentanaPrincipal ventanaPrincipal;
    private JLabel lb_Tem,lb_Trm,lbNull,lbNull2;
    private JLabel lbTem,lbTrm;
    private JButton btAddCsv,btCalcular,btGant;

    public PanelInferior(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.setBorder(new TitledBorder("Acciones: "));
        this.setLayout(new GridLayout(3,3));
        beginComponents();
        addComponents();

    }
    private void beginComponents() {
        lb_Tem = new JLabel("Tiempo Medio de Espera = ");
        lb_Trm = new JLabel("Tiempo Medio de Retorno = ");
        lbNull = new JLabel("");

        lbTem = new JLabel("0");
        lbTrm = new JLabel("0.0");
        lbNull2 = new JLabel("");


        btAddCsv = new JButton("Agregar CSV");
        btAddCsv.setActionCommand(GestionEventos.BTN_CSV);
        btAddCsv.addActionListener(ventanaPrincipal.getGestionEventos());

        btCalcular = new JButton("Calcular");
        btCalcular.setActionCommand(GestionEventos.BTN_CALCULAR);
        btCalcular.addActionListener(ventanaPrincipal.getGestionEventos());
        btGant = new JButton("Diagrama de Gantt");

    }

    private void addComponents() {
        this.add(lb_Tem);
        this.add(lbTem);
        this.add(lbNull);

        this.add(lb_Trm);
        this.add(lbTrm);
        this.add(lbNull2);

        this.add(btAddCsv);
        this.add(btCalcular);
        this.add(btGant);


    }

    public JLabel getLb_Tem() {
        return lb_Tem;
    }

    public void setLb_Tem(JLabel lb_Tem) {
        this.lb_Tem = lb_Tem;
    }

    public JLabel getLb_Trm() {
        return lb_Trm;
    }

    public void setLb_Trm(JLabel lb_Trm) {
        this.lb_Trm = lb_Trm;
    }

    public JLabel getLbTem() {
        return lbTem;
    }

    public void setLbTem(JLabel lbTem) {
        this.lbTem = lbTem;
    }

    public JLabel getLbTrm() {
        return lbTrm;
    }

    public void setLbTrm(JLabel lbTrm) {
        this.lbTrm = lbTrm;
    }

    public JButton getBtAddCsv() {
        return btAddCsv;
    }

    public void setBtAddCsv(JButton btAddCsv) {
        this.btAddCsv = btAddCsv;
    }

    public JButton getBtCalcular() {
        return btCalcular;
    }

    public void setBtCalcular(JButton btCalcular) {
        this.btCalcular = btCalcular;
    }

    public JButton getBtGant() {
        return btGant;
    }

    public void setBtGant(JButton btGant) {
        this.btGant = btGant;
    }
}
