package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConectionFactory {

        private final String conn="jdbc:mysql://localhost:3306/mydb";
        private final String user="usuario";
        private final String pass="senha";
        
	public Connection getConnection() {

		try {
			return DriverManager.getConnection(conn,user,pass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
