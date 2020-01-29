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
    Statement stmt = connection.createStatement();
    private JButton backButton;


    //String usernam;



    public SignInUp(int role) throws SQLException, ClassNotFoundException {
        super("University Management System");
        this.setContentPane(this.mainPanel_Padme);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();



        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username=textname2.getText();
                String passText1 = new String(passwordField2.getPassword());
                String passText2 = new String(passwordField3.getPassword());
                boolean x=textname2.getText().isEmpty();
                int y=1,z=0;
                if(x==true)
                    y=0;
                System.out.println(x);
                if(passText1.equals(passText2))
                   z=1;
                if(passText1.isEmpty())
                    z=0;

                if(y*z!=0)
                {
                    //Deletethis and create pass to next form to fill this details
                    //**********
                    //*********
                    //*******
                    password= String.valueOf(new String(passwordField3.getPassword()));
                    Student student = new Student();
                    student.setPassword(password);
                    student.setUsername(username);
                    //this one open the window
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    setVisible(false);
                    AddDetails addDetails=new AddDetails(role,username,password);
                    addDetails.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Not equal both password or empty username");
                    passwordField3.setText("");
                    passwordField2.setText("");
                }

            }
        });



        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sign In buttion

                //**************
                username=textname1.getText();
                password= String.valueOf(passwordField1.getPassword());
                String quary="";
                if(role==1)
                {
                    quary="SELECT * from student where username='" + username + "'and password='" + password + "';";

                }
                else
                {
                    quary="SELECT * from lecturer where username='" + username + "'and password='" + password + "';";
                }
                try {
                    ResultSet rs=stmt.executeQuery(quary);
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null,"Login Successful");
                        setVisible(false);
                        ShowDetails obj2=new ShowDetails();
                        obj2.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect username or password");
                        textname1.setText("");
                        passwordField1.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


                ///final output




                //**********

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FirstForm firstForm= null;
                try {
                    firstForm = new FirstForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                firstForm.setVisible(true);

            }
        });
    }

}
