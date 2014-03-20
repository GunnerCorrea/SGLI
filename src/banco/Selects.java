/*
 * 
 * Classe responsavel por todos os metodos de `Selects`
 * 
 * obs.: prefiro fazer assim devido a facilidade de manutenção.
 * 
 */
package banco;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marco Aurelio
 */
public class Selects {
    
    
   
    private java.sql.Connection conn;

    public Selects() {
        conn = new ConectionFactory().getConnection();
    }
    
    /**
     * Nao terminado
     * @param cidade
     * @return 
     */
     public int getIdCidade(String cidade) {
        int idCidade = 0;

        String sql = "sql aqui";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cidade);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                idCidade = rs.getInt(" ");
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return idCidade;
    }
    
}
