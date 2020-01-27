package Lab_03;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
    private static Lab_03.Driver dBConnection;
    private Connection connection;
    private Driver() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system", "root", "");
    }
    public static Lab_03.Driver getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new Lab_03.Driver();
        }
        return dBConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}