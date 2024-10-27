
package ej2;

public class Bono {
    private int id;
    private String descripcion;

    public Bono(int id, String descripcion) {
        this.id = id;
        //this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

   // public String getDescripcion() {
    //    return descripcion;
    //}

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Bono{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
