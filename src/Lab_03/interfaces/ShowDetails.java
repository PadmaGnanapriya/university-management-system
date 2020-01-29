package Lab_03.interfaces;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowDetails extends JFrame{
    private JPanel secondMainPanel;
    private JButton exitButton;

    public ShowDetails()
    {
        super("University Management System");
        this.setContentPane(this.secondMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


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
}
