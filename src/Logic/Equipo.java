package Logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by cristhian on 10/10/16.
 */
public class Equipo {

    private ArrayList<Proceso> procesos;


    public Equipo(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public ArrayList Ordenar() {
        ArrayList<Proceso> aux = new ArrayList<>();
        aux = procesos;
        Collections.sort(aux, new Comparator<Proceso>() {
            @Override
            public int compare(Proceso p1, Proceso p2) {
                if (p1.getPrioridad() > p2.getPrioridad())
                    return 1;
                if (p1.getPrioridad() < p2.getPrioridad())
                    return -1;
                if (p1.getPrioridad() == p2.getPrioridad()) {
                    if (p1.getTiempoLlegada() > p2.getTiempoLlegada())
                        return 1;
                    if (p1.getTiempoLlegada() < p2.getTiempoLlegada())
                        return -1;
                    return 0;
                }
                return 0;
            }
        });
        return aux;
    }

    public int[] tiempoRetorno(ArrayList<Proceso> array) {

        int rafagas[] = new int[array.size() + 1];

        //tiempos[0]
        rafagas[0] = array.get(0).getTiempoLlegada();

        for (int i = 0; i < array.size(); i++) {

            rafagas[i + 1] = array.get(i).getRafaga();

        }
        int suma[] = new int[array.size() + 1];
        int total = 0;
        for (int i = 0; i < suma.length; i++) {
            total += rafagas[i];
            suma[i] = total;
        }

        return suma;
    }

    public double tiempoRetornoMedio(int[] retorno) {

        int index = 0;
        int[] array = new int[retorno.length - 1];
        for (Proceso p : procesos) {


            if (index == 0) {

                // System.out.println(p.getTrabajo()+"=="+retorno[0]);
                array[0] = retorno[0];
            } else {
                //System.out.println(p.getTrabajo()+"=="+ retorno[index+1]);
                array[index] = retorno[index + 1];
            }
            index++;
        }

        int total = 0;
        for (double ele : array) {
            total += ele;
        }
        System.out.println("Total = " + total);
        return total / array.length;
    }

    public int[] tiempoEspera(ArrayList<Proceso> array) {

        int espera[] = tiempoRetorno(array);
        int total[] = new int[array.size()];
        //System.out.println(espera.length+" <-> "+array.size());

        for (int i = 0; i < array.size(); i++) {
            //System.out.println(array.get(i).getTrabajo()+" = ("+espera[i]+" - "+array.get(i).getTiempoLlegada()+") ");
            total[i] = espera[i] - array.get(i).getTiempoLlegada();
        }

        return total;
    }

    public double tiempoEsperaMedio(int[] espera) {

        double total = 0;
        for (double ele : tiempoEspera(procesos)) {
            total += ele;
        }
        return total / tiempoEspera(procesos).length;
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }
}
