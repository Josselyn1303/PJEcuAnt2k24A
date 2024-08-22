package PJBusinessLogic;

public abstract class PJAlimento {
    protected String PJtipo;
    @Override
    public String toString() {
        if(PJtipo == null)
            PJtipo = "";
        return PJtipo.toUpperCase();
    }
}
