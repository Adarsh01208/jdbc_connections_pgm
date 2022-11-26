/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adars con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo","root","sitaram");
             ps=con.prepareStatement("select * from register");
            
             rs=  ps.executeQuery();
 */
public class Test2 
{
    public static void main(String[] args)   throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try
        (
            Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo","root","sitaram");
            PreparedStatement  ps=con.prepareStatement("select * from register");
            ResultSet   rs=  ps.executeQuery();
        )
        {
            while(rs.next())
            {
                System.out.println("Namen :"+rs.getString("name"));
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
      }  
}
