package infraestructure.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //FREE é o meu SID do banco local, tem q ser ajustado conforme db local
            String urlBD="jdbc:oracle:thin:@//200.132.53.144:1521/XEpdb1";
            //o mesmo p user e pass
            return DriverManager.getConnection(urlBD, "usr95", "bd220231");
        }catch (SQLException e){
            System.out.println("Exceção SQL");
        }catch (ClassNotFoundException e){
            System.out.println("Exceção Classe não encontrada");
        }

        return null;
    }
}
