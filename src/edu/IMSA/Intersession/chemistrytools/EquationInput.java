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
    JButton submit;
    JFrame frame;
    JPanel panel;
    JLabel label1;
    JTextField reactants;
    JTextField products;
    JTextArea creactants;
    JTextArea cproducts;
    JLabel r;
    JLabel p;
    JLabel cr;
    JLabel cp;
    String reactantsString;
    String productsString;
    public static void main(String[] args){
        EquationInput window = new EquationInput();
        window.setup();
    }
    public void setup(){
        submit = new JButton("Submit!");
        reactants = new JTextField(40);
        products = new JTextField(40);
        creactants = new JTextArea(1,40);
        cproducts = new JTextArea(1,40);
        frame = new JFrame("Window");
        panel = new JPanel();
        label1 = new JLabel("Chemistry");
        r = new JLabel("Reactants:");
        p = new JLabel("Products:");
        cr = new JLabel("New Reactants:");
        cp = new JLabel("New Products:");
        label1.setFont(new Font("Verdana",1,30));
        panel.add(label1);
        panel.add(r);
        panel.add(reactants);
        panel.add(p);
        panel.add(products);
        submit.addActionListener(this);
        panel.add(submit);
        panel.add(cr);
        panel.add(creactants);
        panel.add(cp);
        panel.add(cproducts);
        Dimension d = new Dimension(500, 600);
        frame.setPreferredSize(d);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
        panel.setBackground(Color.RED);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            reactantsString = reactants.getText();
            productsString = products.getText();
        }
    }
    public String returnreact(){
        return reactantsString;
    }
    public String returnprod(){
        return productsString;
    }
    public void answer(String cre, String cpr){
        creactants.append(cre);
        cproducts.append(cpr);
    }
}
