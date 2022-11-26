/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author adars
 */
public class Test3
{
    public static void main(String[] args)
    {
     //   Dbconnection dbc=new Dbconnection();
       
         try
        (   
             Connection con=Dbconnection.getconnection();
            PreparedStatement  ps=con .prepareStatement("select * from register");
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
    

