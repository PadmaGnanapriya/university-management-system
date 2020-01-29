package Lab_03.interfaces;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowDetails extends JFrame{
    private JPanel secondMainPanel;
    private JTabbedPane tabbedPane1;
    private JLabel Image_Lable;
    private JLabel L_name;
    private JLabel L_ID;
    private JLabel L_Age;
    private JButton exitButton;

    public ShowDetails()
    {
        super("University Management System");
        this.setContentPane(this.secondMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();



    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Image_Lable=new JLabel(new ImageIcon("personIcon.jpg"));
    }
}
