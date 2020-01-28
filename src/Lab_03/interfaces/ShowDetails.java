package Lab_03.interfaces;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDetails extends JFrame{
    private JPanel secondMainPanel;
    private JButton exitButton;

    public ShowDetails()
    {
        super("University Management System");
        this.setContentPane(this.secondMainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


    }
}
