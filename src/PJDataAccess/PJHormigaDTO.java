package PJDataAccess;

public class PJHormigaDTO {
    private int secuencial;
    private String tipoHormiga;
    private String ubicacion;
    private String sexo;
    private String ingestaNativa;
    private String genoAlimento;
    private String estado;

    // Constructor
    public PJHormigaDTO(int secuencial, String tipoHormiga, String ubicacion, String sexo, 
                      String ingestaNativa, String genoAlimento, String estado) {
        this.secuencial = secuencial;
        this.tipoHormiga = tipoHormiga;
        this.ubicacion = ubicacion;
        this.sexo = sexo;
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
        this.estado = estado;
    }

    // Getters y Setters
    public int getSecuencial() { return secuencial; }
    public void setSecuencial(int secuencial) { this.secuencial = secuencial; }

    public String getTipoHormiga() { return tipoHormiga; }
    public void setTipoHormiga(String tipoHormiga) { this.tipoHormiga = tipoHormiga; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getIngestaNativa() { return ingestaNativa; }
    public void setIngestaNativa(String ingestaNativa) { this.ingestaNativa = ingestaNativa; }

    public String getGenoAlimento() { return genoAlimento; }
    public void setGenoAlimento(String genoAlimento) { this.genoAlimento = genoAlimento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return secuencial + "\t" + tipoHormiga + "\t" + ubicacion + "\t" + sexo + "\t" + 
               ingestaNativa + "\t" + genoAlimento + "\t" + estado;
    }
}