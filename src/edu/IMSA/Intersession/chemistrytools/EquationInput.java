/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author student
 */
public class EquationInput implements ActionListener {
    JButton butt;
    public static void main(String[] args){
        EquationInput window = new EquationInput();
        window.setup();
    }
    public void setup(){
        butt = new JButton("Exit");
        JFrame frame = new JFrame("Window");
        JPanel panel = new JPanel();
        butt.addActionListener(this);
        panel.add(butt);
        Dimension d = new Dimension(500, 300);
        frame.setPreferredSize(d);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
        panel.setBackground(Color.RED);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==butt){
            System.exit(0);
        }
    }
}
