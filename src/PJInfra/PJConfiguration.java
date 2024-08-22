package PJInfra;

import java.io.ObjectInputFilter.Config;
import java.net.URL;
import javax.swing.JOptionPane;

public abstract class PJConfiguration{
    public static final URL URL_LOGO = Config.class.getResource("src\\PJUserInterface\\PJResource\\PJHormiga2.png");
    public static final String DATAFILE = "Data\\PJhormiguero.csv";
    public static final String LOGFILE= "Data\\PJlog.txt";

    public static final void pjshowMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "EcuAnt", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void pjshowMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "EcuAnt", JOptionPane.OK_OPTION);
    }
    public static final boolean pjshowConfirmYesNo(String msg){    
        return(JOptionPane.showConfirmDialog(null, msg, "EcuAnt", JOptionPane.YES_NO_OPTION)==
        JOptionPane.YES_OPTION);
    }
}