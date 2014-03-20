/*
 *  
 * Classe responsavel por todos os metodos de `Delete`
 * 
 * obs.: prefiro fazer assim devido a facilidade de manutenção.
 * 
 */
package banco;

/**
 *
 * @author Marco Aurelio
 */
public class Deletes {
    
        private java.sql.Connection conn;

    public Deletes() {
        conn = new ConectionFactory().getConnection();
    }
    
}
