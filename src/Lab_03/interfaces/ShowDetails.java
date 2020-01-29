package Lab_03.interfaces;

import Lab_02.Driver;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowDetails extends JFrame {
    private JPanel secondMainPanel;
    private JTabbedPane tabbedPane1;
    private JLabel Image_Lable;
    private JLabel L_name;
    private JLabel L_ID;
    private JLabel L_Age;
    private JButton exitButton;
    private JButton exitButton1;
    private JLabel Sub1;
    private JLabel Sub2;
    private JLabel Sub3;
    int role;
    String username;
    String password;

    public ShowDetails(int role, String username, String password) throws SQLException, ClassNotFoundException {
        super("University Management System");
        this.setContentPane(this.secondMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        Sub1.setText("Unnrol");
        Sub2.setText("Unnrol");
        Sub3.setText("Unnrol");


        Connection connection = Driver.getInstance().getConnection();
        Statement stmt = connection.createStatement();
        String checker = null;
        this.role = role;
        this.username = username;
        this.password = password;

        String quary21="select * from Lecturer where username='" + username + "'and password='" + password + "';";
        String quary22="SELECT course_code from course where course_id in (SELECT course from lecturer where username='" + username + "'and password='" + password + "');";
        String quary11="select * from Student where username='" + username + "'and password='" + password + "';";
        String quary12="SELECT course_code from course where course_id in (SELECT course_id from studentsubject where ids=(Select ids from student where username='" + username + "'and password='" + password + "'));";
        String quary31="SELECT * from studentsubject where ids in (Select ids from student where username='" + username + "'and password='" + password + "');";

        //Lecturer
        if (role == 2) {
            ResultSet rs = stmt.executeQuery(quary21);
            while (rs.next()) {
                L_name.setText(rs.getString(2));
                L_ID.setText(rs.getString(1));
                L_Age.setText(rs.getString(3));
                int courz=Integer.parseInt(rs.getString(6));
                if(courz==1)
                    Sub1.setText("Enrol");
                else if(courz==2)
                    Sub2.setText("Enrol");
                else if(courz==3)
                    Sub3.setText("Enrol");

            }
        }

        if (role == 1) {
            ResultSet rs1 = stmt.executeQuery(quary11);
            while (rs1.next()) {
                L_name.setText(rs1.getString(2));
                L_ID.setText(rs1.getString(1));
                L_Age.setText(rs1.getString(3));
            }
            ResultSet rs2 = stmt.executeQuery(quary31);
            while (rs2.next()) {
                int courzz=Integer.parseInt(rs2.getString(1));
                if(courzz==1)
                    Sub1.setText("Enrol");
                else if(courzz==2)
                    Sub2.setText("Enrol");
                else if(courzz==3)
                    Sub3.setText("Enrol");
            }
        }
        exitButton.addActionListener(new ActionListener() {
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
        exitButton1.addActionListener(new ActionListener() {
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
    //*************
    
    ///****************
        private void createUIComponents () {
            // TODO: place custom component creation code here
            Image_Lable = new JLabel(new ImageIcon("personIcon.jpg"));

        }
}
