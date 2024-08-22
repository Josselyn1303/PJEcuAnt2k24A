package PJBL.Entities;

public abstract class PJIngestaNativa extends PJAlimento {
    
    // Constructor que recibe el tipo y llama al constructor de PJAlimento
    public PJIngestaNativa(String tipo) {
        super();
        this.PJtipo = tipo;
    }

    // Método abstracto que las clases concretas deben implementar
    public abstract boolean inyectar(PJGenoAlimento genoAlimento);
}
