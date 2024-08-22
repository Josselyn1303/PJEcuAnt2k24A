package PJDataAccess;

public class PJHormigaDTO {
    private int pjsecuencial;
    private String pjtipoHormiga;
    private String pjubicacion;
    private String pjsexo;
    private String pjingestaNativa;
    private String pjgenoAlimento;
    private String pjestado;

    // Constructor
    public PJHormigaDTO(int pjsecuencial, String pjtipoHormiga, String pjubicacion, String pjsexo, 
                      String pjingestaNativa, String pjgenoAlimento, String pjestado) {
        this.pjsecuencial = pjsecuencial;
        this.pjtipoHormiga = pjtipoHormiga;
        this.pjubicacion = pjubicacion;
        this.pjsexo = pjsexo;
        this.pjingestaNativa = pjingestaNativa;
        this.pjgenoAlimento = pjgenoAlimento;
        this.pjestado = pjestado;
    }

    // Getters y Setters
    public int getpjSecuencial() { return pjsecuencial; }
    public void setpjSecuencial(int pjsecuencial) { this.pjsecuencial = pjsecuencial; }

    public String getpjTipoHormiga() { return pjtipoHormiga; }
    public void setpjTipoHormiga(String pjtipoHormiga) { this.pjtipoHormiga = pjtipoHormiga; }

    public String getpjUbicacion() { return pjubicacion; }
    public void setpjUbicacion(String pjubicacion) { this.pjubicacion = pjubicacion; }

    public String getpjSexo() { return pjsexo; }
    public void setpjSexo(String pjsexo) { this.pjsexo = pjsexo; }

    public String getpjIngestaNativa() { return pjingestaNativa; }
    public void setpjIngestaNativa(String pjingestaNativa) { this.pjingestaNativa = pjingestaNativa; }

    public String getpjGenoAlimento() { return pjgenoAlimento; }
    public void setpjGenoAlimento(String pjgenoAlimento) { this.pjgenoAlimento = pjgenoAlimento; }

    public String getpjEstado() { return pjestado; }
    public void setpjEstado(String pjestado) { this.pjestado = pjestado; }

    @Override
    public String toString() {
        return pjsecuencial + "\t" + pjtipoHormiga + "\t" + pjubicacion + "\t" + pjsexo + "\t" + 
               pjingestaNativa + "\t" + pjgenoAlimento + "\t" + pjestado;
    }
}