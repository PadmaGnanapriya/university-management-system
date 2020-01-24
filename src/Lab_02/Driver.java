package Lab_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
    private static Driver dBConnection;
    private Connection connection;
    private Driver() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system", "root", "");
    }
    public static Driver getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new Driver();
        }
        return dBConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}