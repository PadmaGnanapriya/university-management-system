package Lab_03.interfaces;

import javax.swing.*;
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
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Student_imge=new JLabel(new ImageIcon("Student.jpg"));
        lecturer_img=new JLabel(new ImageIcon("Lecturer.jpg"));
    }
}
