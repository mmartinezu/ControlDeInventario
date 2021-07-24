package modelos;
public class Activo {
    String id, nombre, estado, codigoBarras, funcionario;

    public Activo() {
    }
    
    public Activo(String id, String nombre, String estado, String codigoBarras, String funcionario) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.codigoBarras = codigoBarras;
        this.funcionario = funcionario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return nombre;
    }

    

}
