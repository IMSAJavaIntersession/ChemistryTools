/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Scanner;

/**
 *
 * @author WXU
 */
public class ChemistryTools {
    //boolean d;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //d = false;
        Scanner input = new Scanner(System.in);
        // TODO code application logic here hello
        EquationInput frame = new EquationInput();
        frame.setup();
        System.out.println("Type anything to continue");
        input.next();
        String r = frame.returnreact();
        String p = frame.returnprod();
        ChemicalEquation c = new ChemicalEquation(r,p);
        String ans = c.toString();
        frame.answer(ans);
    }
}
