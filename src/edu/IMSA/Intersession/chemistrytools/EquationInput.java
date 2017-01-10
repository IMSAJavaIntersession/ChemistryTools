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
    JFrame frame;
    JPanel panel;
    JLabel label1;
    JTextArea reactants;
    JTextArea products;
    JLabel r;
    JLabel p;
    String reactantsString;
    String productsString;
    public static void main(String[] args){
        EquationInput window = new EquationInput();
        window.setup();
        window.input();
    }
    public void setup(){
        butt = new JButton("Exit");
        reactants = new JTextArea(5,40);
        products = new JTextArea(5,40);
        frame = new JFrame("Window");
        panel = new JPanel();
        label1 = new JLabel("Chemistry");
        r = new JLabel("Reactants:");
        p = new JLabel("Products:");
        label1.setFont(new Font("Verdana",1,30));
        panel.add(label1);
        panel.add(r);
        panel.add(reactants);
        panel.add(p);
        panel.add(products);
        butt.addActionListener(this);
        panel.add(butt);
        Dimension d = new Dimension(500, 600);
        frame.setPreferredSize(d);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
        panel.setBackground(Color.RED);
    }
    public void input(){
        reactantsString = JOptionPane.showInputDialog("Enter the reactants!");
        productsString = JOptionPane.showInputDialog("Enter the products!");
        reactants.append(reactantsString);
        products.append(productsString);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==butt){
            System.exit(0);
        }
    }
    public String returnreact(){
        return reactantsString;
    }
    public String returnprod(){
        return productsString;
    }
}
