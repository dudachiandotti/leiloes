
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public static Connection connectDB() throws ClassNotFoundException{
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/uc11";
        String user = "root";
        String password = "180513";
        
        try {
        
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            return conn;
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
}
