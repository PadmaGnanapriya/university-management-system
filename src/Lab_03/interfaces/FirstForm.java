package Lab_03.interfaces;

import Lab_03.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FirstForm extends JFrame{
    private JButton studentButton;
    private JButton lecturerButton;
    private JLabel Student_imge;
    private JPanel FirstFormPanel;
    private JLabel lecturer_img;

    public FirstForm() throws SQLException, ClassNotFoundException {
        super("University Management System");
        this.setContentPane(this.FirstFormPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //student listner
                try {
                    SignInUp ob = new SignInUp(1);
                    ob.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                setVisible(false);

            }
        });
        lecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lecturer Listner
                try {
                    SignInUp ob = new SignInUp(2);
                    ob.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                setVisible(false);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Student_imge=new JLabel(new ImageIcon("Student.jpg"));
        lecturer_img=new JLabel(new ImageIcon("Lecturer.jpg"));
    }
}
