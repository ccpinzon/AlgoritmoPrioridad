package Logic;

/**
 * Created by cristhian on 10/10/16.
 */
public class Proceso {
    String Trabajo;
    int Rafaga;
    int tiempoLlegada;
    int prioridad;

    public Proceso(String trabajo, int rafaga, int tiempoLlegada, int prioridad) {
        Trabajo = trabajo;
        Rafaga = rafaga;
        this.tiempoLlegada = tiempoLlegada;
        this.prioridad = prioridad;
    }

    public String getTrabajo() {
        return Trabajo;
    }

    public void setTrabajo(String trabajo) {
        Trabajo = trabajo;
    }

    public int getRafaga() {
        return Rafaga;
    }

    public void setRafaga(int rafaga) {
        Rafaga = rafaga;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "Trabajo='" + Trabajo + '\'' +
                ", Rafaga=" + Rafaga +
                ", tiempoLlegada=" + tiempoLlegada +
                ", prioridad=" + prioridad +
                '}';
    }
}
