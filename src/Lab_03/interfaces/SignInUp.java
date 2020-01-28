package Lab_03.interfaces;

import Lab_03.Driver;
import Lab_03.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class SignInUp extends JFrame{
    int role;
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
    private JTextField textname1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    private JTextField textname2;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton signUpButton;
    private JPanel mainPanel_Padme;



    public SignInUp(int role) throws SQLException, ClassNotFoundException {
        super("University Management System");
        this.setContentPane(this.mainPanel_Padme);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SgnIn button*********************
                ShowDetails obj2=new ShowDetails();
                obj2.setVisible(true);


            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                username=textname2.getText();

                String passText1 = new String(passwordField2.getPassword());
                String passText2 = new String(passwordField3.getPassword());
                if(passText1.equals(passText2))
                {
                    //Deletethis and create pass to next form to fill this details
                    password= String.valueOf(new String(passwordField3.getPassword()));
                    Student student = new Student();
                    student.setPassword(password);
                    student.setUsername(username);
                    //this one open the window


                }


            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SHOW SECOND FORM
                ShowDetails obj2=new ShowDetails();
                obj2.setVisible(true);
                System.out.println("User Name:");
                username = input.next();
                System.out.println("Password:");
                password = input.next();


            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SignIn button action Listner.
                setVisible(false);
            }
        });
    }

}
