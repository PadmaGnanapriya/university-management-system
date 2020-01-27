package Lab_03;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Second_Form extends JFrame{
    private JPanel secondMainPanel;
    private JButton exitButton;

    public Second_Form()
    {
        super("University Management System");
        this.setContentPane(this.secondMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


    }
}
