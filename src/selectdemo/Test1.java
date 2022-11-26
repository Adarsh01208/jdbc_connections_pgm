/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectdemo;

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
        String user_email="adarsh012@gmail.com";
        String user_pass="ada123";
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); //This Is Use To Load The Driver Class (For Mysql 5 Version :com.mysql.jdbc.Driver)
            // connection is the class or interface present in java.sql.connention
            // con is the variable
            // DriverManager is the Class present in java sql
           /// getconnection is the  Static type method present in driver manager
            // jdbc is an api 
            // mysql is the database which we are using or installed in our pc
            // localhost is the server name where our database is executing
            // 3306 is the port number 
            // sp_demo is the datbase name which we have created
            // root is the by dafault username given by mysql  
             
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo","root","sitaram");//It Will Create Connection Between Java Application And Java Database
       
            // PreparedStatement is the Interface present in java sql package
            
           // PreparedStatement ps= con.prepareStatement("select * from register where email='"+user_email+"'and password='"+user_pass+"'");
               PreparedStatement ps= con.prepareStatement("select * from register where email=?and password=?");
               ps.setString(1, user_email);
               ps.setString(2, user_pass);
            
            
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
               String name1=rs.getString("name");
               String emaill=rs.getString("email");
               String pass=rs.getString("Password");
               String genderr=rs.getString("gender");
               String citys=rs.getString("city");
               
               
               System.out.println("Name :"+name1);
               System.out.println("Email :"+emaill);
               System.out.println("Password :"+pass);
               System.out.println("Gender :"+genderr);   
               System.out.println("City:"+citys);
               
               System.out.println("---------------------------------------------------");
             }
             
             con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
