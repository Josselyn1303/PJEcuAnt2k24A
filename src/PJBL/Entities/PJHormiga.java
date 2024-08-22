package PJBL.Entities;

public abstract class PJHormiga{
    private Integer id;
    private String tipo;
    private String sexo;
    private String estado;

    public PJHormiga(Integer id, String tipo, String sexo, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.sexo = sexo;
        this.estado = estado;
    }

    public Integer getid() {
        return id;
    }
    public void setid(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
