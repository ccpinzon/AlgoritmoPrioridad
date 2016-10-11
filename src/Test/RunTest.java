package Test;

import Logic.Equipo;
import Logic.Proceso;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by cristhian on 10/10/16.
 */
public class RunTest {

    public static void main(String[] args) throws IOException {


        String csvFile = "./Resources/Datos.csv";

        String line = "";
        String cvsSplitBy = ",";

        ArrayList<Proceso> arrayProcesos = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

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
        Equipo eq1 = new Equipo(arrayProcesos);


        System.out.println("Desordenado");
        for (Proceso p : eq1.getProcesos()) {
            System.out.println(p);
        }

        ArrayList<Proceso> ordenado = eq1.Ordenar();

        System.out.println("Ordenado \n");
        for (Proceso p : ordenado) {
            System.out.println(p);
        }

        System.out.println("\nGant\n");
        for (Proceso p : ordenado) {
            System.out.print(p.getTrabajo() + "->");
        }

        System.out.println("\nRetorno: \n");
        int vec[] = eq1.tiempoRetorno(ordenado);

        for (int i : vec) {
            System.out.print(i + ",");

        }

        //Tiempo de retorno de c/u
        System.out.println("\nTiempo de retorno de c/u\n");
        int index = 0;
        for (Proceso p : ordenado) {


            if (index == 0){

                System.out.println(p.getTrabajo()+"=="+vec[0]);
            }else {
                System.out.println(p.getTrabajo()+"=="+ vec[index+1]);
            }
            index++;
        }


        //tiempo retorno medio
        System.out.println("tiempo retorno Medio : " + eq1.tiempoRetornoMedio(eq1.tiempoRetorno(ordenado)));


        //Tiempo de espera

        System.out.println("\nTiempo espera: \n" + Arrays.toString(eq1.tiempoEspera(ordenado)));

        //tiempo espera medio

        /*double total = 0;
        for (double ele: eq1.tiempoEspera(ordenado)) {
            total+=ele;
        }*/
        System.out.println("Tiempo Espera Medio: " + eq1.tiempoEsperaMedio(eq1.tiempoEspera(ordenado)));


    }


}





