
package medicine_management;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class database 
{
public static Connection getConnection()
{
    Connection con=null;
    try{
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine","root","");
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
    return con;
}
}
