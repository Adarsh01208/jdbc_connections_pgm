/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcProject;

import java.util.Scanner;
/**
 *
 * @author adars
 */
public class Test
{
    static Scanner s;
    static CrudOperation co;
    
    void appStarted()
    {
        System.out.println("=====================Java Applictaion Started======================");
        System.out.println("Please Select Any One Option");
        System.out.println("1 : Select");
        System.out.println("2 : Insert");
        System.out.println("3 : Update");
        System.out.println("4 : Delete");
        System.out.println("5 : Exit");
        System.out.println("====================================================================");
    }
    void getUserInput()
    {
        int userinput=s.nextInt();
        if(userinput==1)
        {
            System.out.println("Enter Your Name");
            String name=s.next();
            co.getValues(name);   
        }
        else if(userinput==2)
        {
            System.out.println("Enter Your Name "); 
            String name=s.next();
            
            System.out.println("Enter Your email ID ");
            String email=s.next();
            
            System.out.println("Enter Your Password ");
            String password=s.next();
            
            System.out.println("Enter Your Gender ");
            String gender=s.next();
            
            System.out.println("Enter Your City ");
            String city=s.next();
            
            co.InsertValues(name, email, name, gender, city);
        }
        else if(userinput==3)
        {
            System.out.println("Enter Your Name "); 
            String name=s.next();
            
            System.out.println("Enter Your email ID ");
            String email=s.next();
            
            co.UpdateDetails(name, email);
            
        }
        else if(userinput==4)
        {  
            System.out.println("Enter Your email ID ");
            String email=s.next();
            
            co.DeleteValues(email);
        }
        else
        {
            System.exit(0);
        }
    }
     public static void main(String[] args)
    { 
        s=new Scanner(System.in);
        co=new CrudOperation();
        
        Test t=new Test();
        while(true)
        {
            t.appStarted();
            t.getUserInput();
        }
    }
}
