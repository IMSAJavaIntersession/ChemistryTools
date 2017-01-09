/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

import java.util.*;
public class MolecularFormula {
    ArrayList<String> elements=new ArrayList<String>();
    
 public MolecularFormula(String formula)
 {
     int i=0;
     while (i<formula.length())
     {
        Character a = new Character(formula.charAt(i));
        Character b = new Character(formula.charAt(i+1));
        if (!Character.isDigit(a) && !Character.isDigit(b))
        {
            String toAdd = Character.toString(a) + Character.toString(b);
            elements.add(toAdd);
            i+=2;
        }
        else if(!Character.isDigit(a))
        {
          elements.add(Character.toString(a));
          i++;
        }
        }
        i++;
     
          for (String element: elements)
          {
              System.out.println(element);
          }
 
              
 }

     public static void main (String[] args)
     {
         MolecularFormula one = new MolecularFormula("H2O5");
     }
 }


    

