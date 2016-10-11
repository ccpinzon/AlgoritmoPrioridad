package Gui;

import Logic.Equipo;
import Logic.Proceso;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by cristhian on 10/10/16.
 */
public class VentanaPrincipal extends JFrame {

    private PanelMedio panelMedio;
    private PanelInferior panelInferior;
    private GestionEventos gestionEventos;
    private ArrayList<Proceso> arrayProcesos;
    private Equipo eq1;


    public VentanaPrincipal()  {
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Procesos");
        this.setLayout(new BorderLayout());
        gestionEventos = new GestionEventos(this);
        beginComponets();
        addComponents();
    }

    private void beginComponets() {
        arrayProcesos = new ArrayList<>();
        eq1 = new Equipo(arrayProcesos);
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


    //METHODS BUTTONS

    //Leer CSV
    public void btnCsvFunc() throws IOException {
        refrescarTablaDEsordenada();
        arrayProcesos.clear();

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);


        File file = chooser.getSelectedFile();

        String path = file.getCanonicalPath();
        if (file!=null) {
            System.out.println(path);

            String line = "";
            String cvsSplitBy = ";";
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                //System.out.println(br.lines().count());
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] proceso = line.split(cvsSplitBy);

                    String trabajo = proceso[0];
                    int rafaga = Integer.parseInt(proceso[1]);
                    int tiempo = Integer.parseInt(proceso[2]);
                    int prioridad = Integer.parseInt(proceso[3]);

                    Proceso proceso1 = new Proceso(trabajo, rafaga, tiempo, prioridad);
                    arrayProcesos.add(proceso1);

                    //System.out.println("Proceso [" + proceso[0] + " " + proceso[1] +  " " + proceso[2] + " " + proceso[3] +"]");

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            refrescarTablaDEsordenada();

            for (int i = 0; i < arrayProcesos.size(); i++) {
                String trab = arrayProcesos.get(i).getTrabajo();
                int raf = arrayProcesos.get(i).getRafaga();
                int tiem = arrayProcesos.get(i).getTiempoLlegada();
                int prio = arrayProcesos.get(i).getPrioridad();

                Object data[] = {trab,raf,tiem,prio};

                panelMedio.getModeloTablaProceso().insertRow(i,data);
            }


        }

        refrescarTablaOrdenada();
    }

    public void btnCalcularFunc() {

        ArrayList<Proceso> arrayOrdenado = eq1.Ordenar();
        refrescarTablaOrdenada();
        //System.out.println("Ordenado \n");
        int vecRetorno[] = eq1.tiempoRetorno(arrayOrdenado);
        int vecEspera [] =  eq1.tiempoEspera(arrayOrdenado);

        for (int i = 0; i < arrayOrdenado.size(); i++) {
            String trab = arrayOrdenado.get(i).getTrabajo();
            int raf = arrayOrdenado.get(i).getRafaga();
            int tiem = arrayOrdenado.get(i).getTiempoLlegada();
            int prio = arrayOrdenado.get(i).getPrioridad();

            int retor = 0;
            if (i == 0){
                retor = vecRetorno[0];
            }else {
                retor =vecRetorno[i+1];
            }

            Object data[] = {(i+1),trab,raf,tiem,prio,retor,vecEspera[i]};

            panelMedio.getModeloTablaProcesoOrdenado().insertRow(i,data);
        }

        String tem = String.valueOf(eq1.tiempoEsperaMedio(vecEspera));
        String trm = String.valueOf(eq1.tiempoRetornoMedio(vecRetorno));
        panelInferior.getLbTem().setText(tem);
        panelInferior.getLbTrm().setText(trm);



    }

// METHODS REFRESH TABLES
        public void refrescarTablaDEsordenada(){
            while(panelMedio.getModeloTablaProceso().getRowCount() !=0){
                panelMedio.getModeloTablaProceso().removeRow(0);
            }
        }

    public void refrescarTablaOrdenada(){
        while(panelMedio.getModeloTablaProcesoOrdenado().getRowCount() !=0){
            panelMedio.getModeloTablaProcesoOrdenado().removeRow(0);
        }
    }





    // GETS AND SETS
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
    public GestionEventos getGestionEventos() {
        return gestionEventos;
    }


}
