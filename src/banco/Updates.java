/*
 *  
 * Classe responsavel por todos os metodos de `update`
 * 
 * obs.: prefiro fazer assim devido a facilidade de manutenção.
 * 
 */
package banco;

/**
 *
 * @author Marco Aurelio
 */
public class Updates {
    
        private java.sql.Connection conn;

    public Updates() {
        conn = new ConectionFactory().getConnection();
    }
    
    
}
