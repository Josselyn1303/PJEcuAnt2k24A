/*package PJBL; 

import java.util.ArrayList;
import PJBL.Entities.PJHlarva;
import PJBL.Entities.PJIngestaNativa;
import PJBL.Entities.PJOmnivoro;
import PJBL.Entities.PJXY;
import PJBL.Entities.PJX;
import PJDataAccess.PJHormigaDAO;
import PJDataAccess.PJHormigueroDAC;
import PJBL.Entities.PJGenoAlimento;
import PJBL.Entities.PJHormiga;
import PJBL.Entities.PJNectarivoro;
import PJBL.Entities.PJXX;
import PJInfra.PJAppException;

public class PJHormigueroBL{
    public ArrayList<PJHormiga> lsthormiguero = new ArrayList<>();

    public String crearLarva() throws Exception{
        PJHormiga hormiga = new PJHlarva(lsthormiguero.size()+1);
        lsthormiguero.add(hormiga);
        return "HORMIGA LARVA, agrega al hormiguero"; 
    }
    public String eliminarHormiga(int idHormiga) throws Exception{
        String msg = "HORMIGA, no encontrada";
        for (int i = 0 < lsthormiguero.size(); i++){
            if(lsthormiguero.get(i).getId() == idHormiga){
                msg=lsthormiguero.get(i).getTipo() + ", eliminada del hormiguero";
                lsthormiguero.remove(i);
            }        
        }
        return msg;
    }

    public String guardarHormiguero() throws Exception{
        String fullDataHormiga = "";
        for (PJHormiga hormiga : lsthormiguero)
            fullDataHormiga += hormiga.toString();
        new PJHormigaDAO().save(hormiga);
        return "HORMIGUERO, almacenado";
    }

    public String alimentarHormiga(int Idhormiga, String alimentoGeno, String alimentoNativo) throws Exception{
        int indexList = 0;
        PJGenoAlimento aGeno= null;
        PJIngestaNativa aNativo = null;
        PJHormiga hormiga = null;
        //creando GenoAlimento 
        switch (alimentoGeno){
            case "XX": aGeno = new PJXX(); break;
            case "XY": aGeno = new PJXY(); break;
            default: aGeno = new PJX(); break;
        }

        //creando IngestaNativa
        switch (alimentoNativo){
            case "Carnivoro": aNativo = new Carnivoro(); break;
            case "Herbivoro": aNativo = new Herbivoro(); break;
            case "Omnivoro": aNativo = new Omnivoro(); break;
            case "Insectivoro": aNativo = new Insectivoro(); break;
            case "Nectarivoro": aNativo = new Nectarivoro(); break;
        }

        //buscar indexList y hormiga a alimentar
        for (;indexList< lstHormiguero.size(); indexList++){
        }
        if (lstHormiguero.get(indexList).getId() == Idhormiga){
            hormiga = lstHormiguero.get(indexList);
            break;
        }

        //validamos
        if(aNativo == null || aGeno == null || hormiga.getEstado() == "MUERTA")
        return "Ups...! alimento y hormiga no son validos";

        // inyectamos el genoAlimento a la ingestaNativa y se procede a alimentar a la hormiga 
        if(aNativo.inyectar(aGeno))
        lstHormiguero.set(indexList, hormiga.comer(aNativo));
        else 
        return hormiga.getTipo() + "NO alimentada";

        return lstHormiguero.get(indexList).getTipo()+"Alimentada";
    }
}*/