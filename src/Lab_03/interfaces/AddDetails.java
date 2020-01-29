package Lab_03.interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public AddDetails(int role,String username,String password){
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
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here



    }
}
