package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Marco Aurelio
 */

public class ConversorTime {

    
    /*
     * Transforma um String que deve estar no formato: dd/MM/yyyy e transforma em sql Date, 
     * para adiconar ao banco
     */
    public java.sql.Date dataString_dataSql(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dataSql = null;

        try {
            dataSql = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ConversorTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSql;
    }
    
}
