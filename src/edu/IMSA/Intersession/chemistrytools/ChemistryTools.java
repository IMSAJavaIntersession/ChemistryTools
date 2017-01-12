/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author student
 */
public class ChemistryTools implements ActionListener {
    JButton submit;
    JFrame frame;
    JPanel panel;
    JLabel label1;
    JTextField reactants;
    JTextField products;
    JScrollPane ans;
    JTextArea textans;
    JLabel r;
    JLabel p;
    JLabel a;
    String reactantsString;
    String productsString;
    ChemicalEquation ce;
    String strans;
    //boolean done;
    //boolean done = false;
    public static void main(String[] args){
    	
        ChemistryTools window = new ChemistryTools();
        window.setup();
    }
    public void setup(){
        submit = new JButton("Submit!");
        reactants = new JTextField(40);
        products = new JTextField(40);
        textans = new JTextArea(13,40);
        ans = new JScrollPane(textans);
        frame = new JFrame("Window");
        panel = new JPanel();
        label1 = new JLabel("Chemical Equation Balancer");
        r = new JLabel("Reactants:");
        r.setFont(new Font("Verdana",1,15));
        p = new JLabel("Products:");
        a = new JLabel("Balanced Chemical Equation:");
        p.setFont(new Font("Verdana",1,15));
        a.setFont(new Font("Verdana", 1, 25));
        label1.setFont(new Font("Verdana",1,30));
        panel.add(label1);
        panel.add(r);
        panel.add(reactants);
        panel.add(p);
        panel.add(products);
        submit.addActionListener(this);
        panel.add(submit);
        panel.add(a);
        panel.add(textans);
        Dimension d = new Dimension(500, 500);
        frame.setPreferredSize(d);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
        panel.setBackground(new Color(193, 198, 252));
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            reactantsString = reactants.getText();
            productsString = products.getText();
            try {
                ce = new ChemicalEquation(reactantsString,productsString);
            } catch (Exception ex) {
                Logger.getLogger(ChemistryTools.class.getName()).log(Level.SEVERE, null, ex);
            }
            strans = ce.toString();
            textans.setText(strans);
            
            //done=true;
        }
    }
    public String returnreact(){
        return reactantsString;
    }
    public String returnprod(){
        return productsString;
    }
    public void answer(String ans){
        textans.setText(ans);
    }
}
