package Lab_03.interfaces;

import Lab_03.Driver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDetails extends JFrame{
    int role;
    String username,password;
    private JCheckBox SENG11111IntroductionToCheckBox;
    private JPanel addDetails;
    private JTextField textField_ID;
    private JButton backButton;
    private JButton addButton;
    private JButton clearButton;
    private JTextField textField_FullName;
    private JTextField textField_Username;
    private JTextField textField_Password;
    private JTextField textField_Age;
    private JButton exitButton;
    Connection connection = Driver.getInstance().getConnection();
    private JCheckBox SENG11112;
    private JCheckBox SENG11123;

    public AddDetails(int role,String username,String password) throws SQLException, ClassNotFoundException {
        super("University Management System");
        this.setContentPane(this.addDetails);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        textField_Username.setText(username);
        textField_Password.setText(password);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear button
                textField_ID.setText("");
                textField_FullName.setText("");
                textField_Username.setText(username);
                textField_Password.setText(password);
                textField_Age.setText("");
             }
        });
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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //role 1 for student
                if(role==1)
                {
                    PreparedStatement stm = null;
                    try {
                        stm = connection.prepareStatement("Insert Into Student Values(?,?,?,?,?);");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        stm.setObject(1, textField_ID.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        stm.setObject(2, textField_FullName.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        stm.setObject(3, textField_Age.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        stm.setObject(4, textField_Username.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        stm.setObject(5, textField_Password.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        stm.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    if(SENG11111IntroductionToCheckBox.isSelected())
                    {
                        PreparedStatement stmm = null;
                        try {
                            stmm = connection.prepareStatement("INSERT INTO studentSubject VALUES (?,?)");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.setObject(1, 1);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.setObject(2, textField_ID.getText());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.executeUpdate();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }

                    if(SENG11112.isSelected())
                    {
                        PreparedStatement stmm = null;
                        try {
                            stmm = connection.prepareStatement("INSERT INTO studentSubject VALUES (?,?)");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.setObject(1, 2);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.setObject(2, textField_ID.getText());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.executeUpdate();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }

                    if(SENG11123.isSelected())
                    {
                        PreparedStatement stmm = null;
                        try {
                            stmm = connection.prepareStatement("INSERT INTO studentSubject VALUES (?,?)");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.setObject(1, 3);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.setObject(2, textField_ID.getText());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            stmm.executeUpdate();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }

                }
                //role 2 for lecture
                else
                {

                }
            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here



    }
}
