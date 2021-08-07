package modelos;

import java.util.List;

public class ProcesoValidacion {
    int id;
    String titulo, fecha;
    List<ProcesoDetail> detalles;

    public ProcesoValidacion() {
    }

    public ProcesoValidacion(int id, String titulo, String fecha, List<ProcesoDetail> detalles) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<ProcesoDetail> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProcesoDetail> detalles) {
        this.detalles = detalles;
    }
    
    
}
