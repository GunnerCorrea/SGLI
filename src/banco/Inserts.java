/*
 *  
 * Classe responsavel por todos os metodos de `insert`
 * 
 * obs.: prefiro fazer assim devido a facilidade de manutenção.
 * 
 */
package banco;

import Beans.Cliente;
//import com.sun.security.ntlm.Client;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.ConversorTime;

/**
 *
 * @author Marco Aurelio
 */
public class Inserts {

    private java.sql.Connection conn;

    public Inserts() {
        conn = new ConectionFactory().getConnection();
    }
    
    /**
     * Nao terminado
     * @param cl 
     */
     public void insert_cliente(Cliente cl) {

        String sql = "INSERT INTO Pessoa (ps_nome,ps_datanascimento,ps_logradouro,ps_numero,ps_bairro,ps_cep,ps_cid_id,ps_email_prima,ps_email_segun) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,cl.getNome());
            stmt.setDate(2,new ConversorTime().dataString_dataSql(cl.getDataNascimento()));
            stmt.setString(3,cl.getLagradouro());
            stmt.setString(4,cl.getNumero());
            stmt.setString(5,cl.getBairro());
            stmt.setString(5,cl.getCep());
            stmt.setString(5,cl.getBairro());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
