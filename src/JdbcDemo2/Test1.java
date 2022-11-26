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

/**
 *
 * @author adars
 */
public class Test1
{
    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
 
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo","root","sitaram");
             ps=con.prepareStatement("select * from register");
            
             rs=  ps.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Name : "+rs.getString("name"));
                System.out.println("Email id : "+rs.getString("email"));
                System.out.println("pass: "+rs.getString("password"));
                System.out.println("Gender : "+rs.getString("gender"));
                System.out.println("City : "+rs.getString("city"));
                System.out.println("----------------------------------------------------");
            }
            
        }
        catch(Exception e)       
        {
            System.out.println(e); 
        }
        finally
        {
            try
            {
                rs.close();
                ps.close();
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }          
    }
}
