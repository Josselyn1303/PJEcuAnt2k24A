package PJBL.Entities;

public class PJGenoAlimento extends PJAlimento {
    
    public PJGenoAlimento(String tipo) {
        super();
        this.PJtipo = tipo;
    }

    public String getTipo() {
        return PJtipo;
    }

    public void setTipo(String tipo) {
        this.PJtipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
