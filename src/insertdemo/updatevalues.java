/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class updatevalues 
{
    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter email id");
        String email1=s.next();
        System.out.println("Enter Password (To Be Updated)");
        String pass=s.next();
        System.out.println("Enter City (To Be Updated))");
        String city1=s.next();
        
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo","root","sitaram");
            PreparedStatement ps=con.prepareStatement("update register set password=?,city=? where email=?");
                    
             ps.setString(1, pass);
             ps.setString(2, city1);
             ps.setString(3, email1);
             
            int i=   ps.executeUpdate();
            
            if(i>0)
            {
                System.out.println("Updated successfully...");
            }
            else
            {
                System.out.println("Failed......");
            }
             
            ps.close();
            con.close();
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
