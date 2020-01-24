package Lab_02;

import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String name;
        int age;
        String subject;
        int option;
        int course[]=new int[3];
        int id;
        String module;
        String username;
        String password;
        int sop;

        Connection connection= Driver.getInstance().getConnection();
        Scanner input=new Scanner(System.in);

        System.out.println("Welcome to University Management System_2");
        System.out.println("");
        System.out.println("Please select an option to proceed");
        System.out.println("Press [1] Register as a Student");
        System.out.println("Press [2] Register as a Lecturer");

        option=input.nextInt();
        Subject sub=new Subject();

        switch (option){
            case 1:
                System.out.println("Select [1] for Sign up, [2} for sign in");
                sop=input.nextInt();
                switch (sop) {
                    case 1:
                        System.out.println("Student Registration\n");

                        System.out.println("Please Submit following information");
                        System.out.println("Student ID:");
                        id = input.nextInt();
                        System.out.println("1:  Name:");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.println("2:  Age:");
                        age = input.nextInt();
                        System.out.println("User name:");
                        username = input.next();
                        System.out.println("Password:");
                        password = input.next();
                        System.out.println("3: Select course number from following list,");
                        System.out.println("[1] SENG1111 Introduction to Programming");
                        System.out.println("[2] SENG1112 Fndamantales of Engineering");
                        System.out.println("[3] SENG1113 Data Structures and Algorithms");
                        subject=input.next();
                        Subject mod=new Subject();
                        String []val = subject.split(",");
                        Student student = new Student();
                        student.setAge(age);
                        student.setStdName(name);
                        student.setId(id);
                        student.setPassword(password);
                        student.setUsername(username);
                        int i=0;
                        System.out.println(val.length);
                        PreparedStatement stm = connection.prepareStatement("Insert Into Student Values(?,?,?,?,?);");

                        stm.setObject(1, student.getId());
                        stm.setObject(2, student.getStdName());
                        stm.setObject(3, student.getAge());
                        stm.setObject(4, student.getUsername());
                        stm.setObject(5, student.getPassword());

                        stm.executeUpdate();
                        for(String ttr: val) {
                            int subId=Integer.parseInt(ttr);
                            mod.setId(subId);
                            System.out.println(subId);

                            PreparedStatement stmm = connection.prepareStatement("INSERT INTO studentSubject VALUES (?,?)");
                            stmm.setObject(1, mod.getId());
                            stmm.setObject(2, student.getId());
                            stmm.executeUpdate();
                            i++;
                        }

                        System.out.println("Student Registration Completed");
                        System.out.println("Name    :" + student.getStdName());
                        System.out.println("Age     :" + student.getAge());
                        break;

                    case 2:
                        System.out.println("Student Login form");

                        System.out.println("User Name:");
                        username=input.next();
                        System.out.println("Password:");
                        password=input.next();

                        Statement  stmt=connection.createStatement();
                        //ResultSet rst=stmt.executeQuery("SELECT subName from subject where id in (SELECT subId from std_sub where stdId=(Select id from student where username='"+username+"'and password='"+password+"'));");
                        ResultSet rs=stmt.executeQuery( "select * from Student where username='"+username+"'and password='"+password+"';");
                        while (rs.next()) {
                            System.out.println( "Hi " + rs.getString(2));

                        }

                        ResultSet rst=stmt.executeQuery("SELECT course_code from course where course_id in (SELECT course_id from studentsubject where ids=(Select ids from student where username='"+username+"'and password='"+password+"'));");
                        System.out.println("You have successfully registered for this courses:");
                        while(rst.next()){
                            System.out.println(" "+rst.getString(1));
                        }
                        break;
                    default:
                }
                break;


            case 2:
                System.out.println("Select [1] for Sign up, [2} for sign in");
                sop=input.nextInt();
                switch (sop) {

                    case 1:
                        System.out.println("Lecturer Registration\n");
                        System.out.println("Please Submit following information");
                        System.out.println("Lecturer ID:");
                        id = input.nextInt();
                        System.out.println("1:  Name:");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.println("2:  Age:");
                        age = input.nextInt();
                        System.out.println("User name:");
                        username = input.next();
                        System.out.println("Password:");
                        password = input.next();
                        System.out.println("3: Select course number from following list,");
                        System.out.println("[1] SENG1111 Introduction to Programming");
                        System.out.println("[2] SENG1112 Fndamantales of Engineering");
                        System.out.println("[3] SENG1113 Data Structures and Algorithms");
                        subject=input.nextLine();
                        input.nextLine();
                        Subject mod=new Subject();
                        String []val = subject.split(",");
                        Lecturer lecturer = new Lecturer();

                        lecturer.setName(name);
                        lecturer.setAge(age);
                        lecturer.setId(id);
                        lecturer.setUsername(username);
                        lecturer.setPassword(password);
                        lecturer.setCourse(subject);
                        PreparedStatement stm = connection.prepareStatement("Insert Into Lecturer Values(?,?,?,?,?,?);");
                        stm.setObject(1, lecturer.getId());
                        stm.setObject(2, lecturer.getName());
                        stm.setObject(3, lecturer.getAge());
                        stm.setObject(4, lecturer.getUsername());
                        stm.setObject(5, lecturer.getPassword());
                        stm.setObject(6, lecturer.getCourse());
                        stm.executeUpdate();
                        System.out.println("Lecturer Registration Completed");
                        System.out.println("Name    :" + lecturer.getName());
                        System.out.println("Age     :" + lecturer.getAge());
                        System.out.println("Subject :" + sub.getSubName());
                        break;
                    case 2:
                        System.out.println("Lecturer Login form");

                        System.out.println("User Name:");
                        username=input.next();
                        System.out.println("Password:");
                        password=input.next();

                        Statement  stmt=connection.createStatement();
                        ResultSet   rs=stmt.executeQuery( "select * from lecturer where username='"+username+"'and password='"+password+"';");
                        while (rs.next()) {
                            System.out.println( "Hi " + rs.getString(2));
                            System.out.println("You have successfully registered for this course:");
                            System.out.println(" "+rs.getString(6));
                        }
                        break;
                    default:
                }
                break;

        }
        connection.close();




    }
}
