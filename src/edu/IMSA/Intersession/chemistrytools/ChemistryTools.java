/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

/**
 *
 * @author WXU
 */
public class ChemistryTools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here hello
        EquationInput frame = new EquationInput();
        frame.setup();
        String r = frame.returnreact();
        String p = frame.returnprod();
        ChemicalEquation c = new ChemicalEquation(r,p);
        String ans = c.toString();
        frame.answer(ans);
    }
    
}
