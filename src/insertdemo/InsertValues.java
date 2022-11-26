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
public class InsertValues 
{
    public static void main(String[] args) 
    {   //taking user input
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name1=s.next();
        System.out.println("Enter Email Id :");
        String email1=s.next();
        System.out.println("Enter Password");
        String pass =s.next();
        System.out.println("Enter Gender :");
        String gender1=s.next();
        System.out.println("Enter city");
        String city1=s.next();
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo","root","sitaram");
            PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1, name1);
            ps.setString(2, email1);
            ps.setString(3, pass);
            ps.setString(4, gender1);
            ps.setString(5, city1);
            
            int i=  ps.executeUpdate();
          
          if (i>0)
          {
              System.out.println("Sucess.... ");
          }
          else 
          {
              System.out.println("failed... ");
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
