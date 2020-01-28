package Lab_02;

import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String name;
        int age;
        String subject;
        int option;
        int course[] = new int[3];
        int id;
        String module;
        String username;
        String password;
        int sop;

        Connection connection = Driver.getInstance().getConnection();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to University Management System_2");
        System.out.println("");
        System.out.println("Please select an option to proceed");
        System.out.println("Press [1] Register as a Student");
        System.out.println("Press [2] Register as a Lecturer");

        option = input.nextInt();
        Subject sub = new Subject();

        switch (option) {
            case 1:
                System.out.println("Select [1] for Sign up, [2} for sign in");
                sop = input.nextInt();
                switch (sop) {
                    /*Student signUp form*/
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
                        System.out.println("[1] SENG 11111 - Introduction to Programming");
                        System.out.println("[2] SENG 11112 - Fundamental of Engineering");
                        System.out.println("[3] SENG 11123 - Project Management");
                        subject = input.next();
                        Subject mod = new Subject();
                        String[] val = subject.split(",");
                        Student student = new Student();
                        student.setAge(age);
                        student.setStdName(name);
                        student.setId(id);
                        student.setPassword(password);
                        student.setUsername(username);
                        System.out.println("\nStudent Registration Completed");
                        System.out.println("Name    : " + student.getStdName());
                        System.out.println("Age     : " + student.getAge());
                        System.out.print("Subject : ");

                        int i = 0;
                        /*Insert user input to SQL database */
                        /*Student details into student table */
                        PreparedStatement stm = connection.prepareStatement("Insert Into Student Values(?,?,?,?,?);");
                        stm.setObject(1, student.getId());
                        stm.setObject(2, student.getStdName());
                        stm.setObject(3, student.getAge());
                        stm.setObject(4, student.getUsername());
                        stm.setObject(5, student.getPassword());
                        stm.executeUpdate();

                        for (String ttr : val) {
                            int subId = Integer.parseInt(ttr);
                            mod.setId(subId);
                            if (subId == 1)
                                System.out.println("SENG 11111 - Introduction to Programming");
                            else if (subId == 2)
                                System.out.println("SENG 11112 - Fundamental of Engineering");
                            else if (subId == 3)
                                System.out.println("SENG 11123 - Project Management");

                            /*Insert user input to SQL database */
                            /*Student selected course moduls into studentSubject table */
                            PreparedStatement stmm = connection.prepareStatement("INSERT INTO studentSubject VALUES (?,?)");
                            stmm.setObject(1, mod.getId());
                            stmm.setObject(2, student.getId());
                            stmm.executeUpdate();
                            i++;
                        }
                        System.out.println("\nThank you");
                        break;

                         /*Student signIn form*/
                        case 2:
                        System.out.println("Student Login form");
                        System.out.println("User Name:");
                        username = input.next();
                        System.out.println("Password:");
                        password = input.next();
                        String stuIdNo;

                        Statement stmt = connection.createStatement();
                        String checker=null;
                        ResultSet rs = stmt.executeQuery("select * from Student where username='" + username + "'and password='" + password + "';");
                        while (rs.next()) {
                            System.out.println("\nHi " + rs.getString(2));
                            checker=rs.getString(2);
                        }
                        String checker2=String.valueOf(checker);

                        /* Check valid username and password,if invalid program will terminate*/
                        if(checker2==null || checker2=="null")
                        {
                            System.out.println("Hey,You have entered an invalid username or password.\nBye");
                            return;  /* Termination point */
                        }

                        ResultSet rst = stmt.executeQuery("SELECT course_code from course where course_id in (SELECT course_id from studentsubject where ids=(Select ids from student where username='" + username + "'and password='" + password + "'));");
                        System.out.println("You have successfully registered for this courses:");
                        while (rst.next()) {
                            System.out.println(" " + rst.getString(1));  /*Display his or her courses line by line*/
                        }
                        System.out.println("Please select a option");
                        System.out.println("[1] exit\n[2]Register new course");
                        int kk=input.nextInt();
                        if(kk==1)
                        {
                            System.out.println("\n Bye!");
                            break;
                        }
                        else if(kk==2)
                        {
                            System.out.println("3: Select one course number from following list,");
                            System.out.println("[1] SENG 11111 - Introduction to Programming");
                            System.out.println("[2] SENG 11112 - Fundamental of Engineering");
                            System.out.println("[3] SENG 11123 - Project Management");
                            System.out.println("Enter your choice : ");
                            int subId2 = input.nextInt();
                            Statement stmt2 = connection.createStatement();
                            String sqloutput = null;
                            ResultSet kkkk = stmt2.executeQuery("select * from Student where username='" + username + "'and password='" + password + "';");
                            while (kkkk.next()) {
                                sqloutput=kkkk.getString(1);
                            }
                            String studentd=String.valueOf(sqloutput);

                            /*Insert user input to SQL database */
                            /*INSERT Student selected course modules into studentSubject table */
                            PreparedStatement stmm2 = connection.prepareStatement("INSERT INTO studentSubject VALUES (?,?)");
                            stmm2.setObject(1, subId2);
                            stmm2.setObject(2, studentd);
                            stmm2.executeUpdate();
                            ResultSet rstt = stmt.executeQuery("SELECT course_code from course where course_id in (SELECT course_id from studentsubject where ids=(Select ids from student where username='" + username + "'and password='" + password + "'));");
                            System.out.println("Even now you have successfully registered for these courses:");
                            while (rstt.next()) {
                                System.out.println(" " + rstt.getString(1));  /*Display his or her courses line by line*/
                            }
                            System.out.println("Bye!");
                        }
                        break;
                    default:
                }
                break;


            case 2:
                System.out.println("Select [1] for Sign up, [2} for sign in");
                sop = input.nextInt();
                switch (sop) {

                    /*Lecturer signUp form*/
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
                        System.out.println("[1] SENG 11111 - Introduction to Programming");
                        System.out.println("[2] SENG 11112 - Fundamentals of Engineering");
                        System.out.println("[3] SENG 11123 - Project Management");
                        subject = input.next();
                        //Subject mod = new Subject();
                        //String[] val = subject.split(",");
                        Lecturer lecturer = new Lecturer();
                        lecturer.setAge(age);
                        lecturer.setName(name);
                        lecturer.setId(id);
                        lecturer.setPassword(password);
                        lecturer.setUsername(username);
                        lecturer.setCourse(subject);
                        Statement stmts = connection.createStatement();
                        System.out.println("\nLecturer Registration Completed");
                        System.out.println("Name    : " + lecturer.getName());
                        System.out.println("Age     : " + lecturer.getAge());
                        System.out.print("Subject : ");

                        int i = 0;
                        /*Insert user input to SQL database */
                        /*Student details into lecturer table */
                        PreparedStatement stm = connection.prepareStatement("Insert Into Lecturer Values(?,?,?,?,?,?);");
                        stm.setObject(1, lecturer.getId());
                        stm.setObject(2, lecturer.getName());
                        stm.setObject(3, lecturer.getAge());
                        stm.setObject(4, lecturer.getUsername());
                        stm.setObject(5, lecturer.getPassword());
                        stm.setObject(6, lecturer.getCourse());
                        stm.executeUpdate();
                        /* Display registered course */
                        ResultSet rstx = stmts.executeQuery("SELECT course_code from course where course_id in (SELECT course from lecturer where username='" + username + "'and password='" + password + "');");
                        while (rstx.next()) {
                            System.out.print(" " + rstx.getString(1));
                        }

                        System.out.println("\nThank you");
                        break;

                    case 2:
                        System.out.println("Lecturer Login form");
                        System.out.println("User Name:");
                        username = input.next();
                        System.out.println("Password:");
                        password = input.next();
                        Statement stmt = connection.createStatement();
                        String checker=null;
                        ResultSet rs = stmt.executeQuery("select * from lecturer where username='" + username + "'and password='" + password + "';");
                        while (rs.next()) {
                            System.out.println("Hi " + rs.getString(2));
                            checker=rs.getString(2);
                        }
                        String checker2=String.valueOf(checker);
                        if(checker2==null || checker2=="null")
                        {
                            System.out.println("Hey,You have entered an invalid username or password.\nBye");
                            return;
                        }
                        ResultSet rst = stmt.executeQuery("SELECT course_code from course where course_id in (SELECT course from lecturer where username='" + username + "'and password='" + password + "');");
                        System.out.println("You have successfully registered for this courses:");
                        while (rst.next()) {
                            System.out.println(" " + rst.getString(1));
                        }

                        break;
                    default:
                }
                break;

        }
        connection.close();




    }
}
