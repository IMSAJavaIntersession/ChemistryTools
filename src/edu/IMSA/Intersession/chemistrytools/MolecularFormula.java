/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;



public class MolecularFormula {
    String[] elements;
    int e = 0;
    
 public MolecularFormula(String formula)
 {
     for (int i=0; i<formula.length(); i++)
     {
        Character a = new Character(formula.charAt(i));
        
        
        if (!Character.isDigit(a))
        {
            elements[e]=Character.toString(a);
            e++;
        }
        
     }
          for (String element: elements)
          {
              System.out.println(element);
          }
              
 }

     public static void main (String[] args)
     {
         MolecularFormula one = new MolecularFormula("");
     }
 }

    

