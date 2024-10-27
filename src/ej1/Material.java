package ej1;


public class Material {
    public enum TipoMaterial { PELOTAS, CANASTAS, CONOS }
    public enum EstadoMaterial { DISPONIBLE, RESERVADO, MAL_ESTADO }

    private int id;
    private TipoMaterial tipo;
    private boolean usoExterior;  // true para exterior, false para interior
    private EstadoMaterial estado;

    public Material() {}

    public Material(int id, TipoMaterial tipo, boolean usoExterior, EstadoMaterial estado) {
        this.id = id;
        this.tipo = tipo;
        this.usoExterior = usoExterior;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoMaterial getTipo() { return tipo; }
    public void setTipo(TipoMaterial tipo) { this.tipo = tipo; }

    public boolean isUsoExterior() { return usoExterior; }
    public void setUsoExterior(boolean usoExterior) { this.usoExterior = usoExterior; }

    public EstadoMaterial getEstado() { return estado; }
    public void setEstado(EstadoMaterial estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Material[ID: " + id + ", Tipo: " + tipo + ", Uso Exterior: " + usoExterior + ", Estado: " + estado + "]";
    }
}
