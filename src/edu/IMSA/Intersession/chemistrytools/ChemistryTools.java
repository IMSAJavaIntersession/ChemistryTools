package edu.IMSA.Intersession.chemistrytools;
import edu.IMSA.Intersession.Elements;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChemistryTools implements ActionListener {
	JButton data;
	JTextField extraData;
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

    public static void main(String[] args){
    	
        ChemistryTools window = new ChemistryTools();
        window.setup();
    }
    public void setup(){
    	data = new JButton("Print extra data!");
    	extraData = new JTextField(40);
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
        data.addActionListener(this);
        panel.add(label1);
        panel.add(r);
        panel.add(reactants);
        panel.add(p);
        panel.add(products);
        submit.addActionListener(this);
        panel.add(submit);
        panel.add(a);
        panel.add(textans);
        panel.add(extraData);
        panel.add(data);
        Dimension d = new Dimension(500, 550);
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
            
            ce.balance();
            strans = ce.toString();
            textans.setText(strans);
            
            System.out.println(ce.getSteps());
        }
        
        if(e.getSource() == data) {
        	extraData.setText("The button has been pushed!");
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
