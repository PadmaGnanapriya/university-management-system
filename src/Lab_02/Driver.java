package Lab_02;
import java.sql.*;
import java.util.Scanner;

public class Driver {


   public static void main(String   args[])
   {
       int choice1,choice2,age;
       String name,username;
       Scanner scanner=new Scanner(System.in);

       System.out.println("Select, [1] sign up, [2] sign in.");
       choice1=scanner.nextInt();
       System.out.println("Please select your registation role [1] Lecturer, [2] Student");
       choice2=scanner.nextInt();
       if(choice1==1 && choice2==1)
           signUpLecture();
       else if(choice1==2 && choice2==1)
           signInLecture();
       else if(choice1==1 && choice2==2)
           signUpStudent();
       else if(choice1==2 && choice2==2)
           signInStudent();


       try
       {
           Class.forName( "com.mysql.jdbc.Driver" );
           Connection   con=DriverManager.getConnection(   "jdbc:mysql://localhost:3306/university_management_system" , "root" , "" );
           Statement   stmt=con.createStatement();
           ResultSet   rs=stmt.executeQuery( "select   *   from   student" );
           while (rs.next())   System.out.println(rs.getString( 1 )+ "    " +rs.getString( 2 )+ "    " +rs.getString( 3 ));
           con.close();
       }
       catch (Exception   e)
       {
            System.out.println(e);
       }

   }
}