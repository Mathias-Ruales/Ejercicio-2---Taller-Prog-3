public class Cliente {
    String nombre;
    public Cliente siguente;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.siguente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
