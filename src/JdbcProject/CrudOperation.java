/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcProject;

import dbconnection.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author adars
 */
public class CrudOperation 
{
    void getValues(String name)
    {
         try
        (   
             Connection con=Dbconnection.getconnection();
            PreparedStatement  ps=con .prepareStatement("select * from register where name=?");
           
        )
        {
            ps.setString(1, name);
            ResultSet   rs=  ps.executeQuery();
            while(rs.next()) 
            {
                System.out.println("Name :"+rs.getString("name"));   
                System.out.println("Email id : "+rs.getString("email"));
                System.out.println("pass: "+rs.getString("password"));
                System.out.println("Gender : "+rs.getString("gender"));
                System.out.println("City : "+rs.getString("city"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } 
    void InsertValues(String name,String email,String pass,String gender,String city)
    {
       try
       (
            Connection con=Dbconnection.getconnection();
            PreparedStatement  ps=con .prepareStatement("insert into register values(?,?,?,?,?)");
       )
       {
           ps.setString(1,name);
           ps.setString(2,email);
           ps.setString(3,pass);
           ps.setString(4,gender);
           ps.setString(5,city);
           
           int i=ps.executeUpdate();
           if(i>0)
           {
               System.out.println("Inserted Succesfully");   
           }
           else
           {
               System.out.println("Failed...."); 
           }
       }
           catch(Exception e)
           {
                 System.out.println(e);  
           }
           
       }
    void UpdateDetails(String name ,String email)
    {
         try
       (
            Connection con=Dbconnection.getconnection();
            PreparedStatement  ps=con .prepareStatement("update register set name=? where email=?");
       )
       {
           ps.setString(1, name);
           ps.setString(2,email);
         
           
           int i=ps.executeUpdate();
           if(i>0)
           {
               System.out.println("Updated Succesfully");   
           }
           else
           {
               System.out.println("Failed........"); 
           }
       }
           catch(Exception e)
           {
                 System.out.println(e);  
           }
           
       }
     void DeleteValues(String email)
    {
       try
       (
            Connection con=Dbconnection.getconnection();
            PreparedStatement  ps=con .prepareStatement("delete from register where email=?");
       )
       {
           ps.setString(1,email);
         
           
           int i=ps.executeUpdate();
           if(i>0)
           {
               System.out.println("Deleted Succesfully");   
           }
           else
           {
               System.out.println("Failed........"); 
           }
       }
           catch(Exception e)
           {
                 System.out.println(e);  
           }
           
       }
      
    }
    
        


            
   
    