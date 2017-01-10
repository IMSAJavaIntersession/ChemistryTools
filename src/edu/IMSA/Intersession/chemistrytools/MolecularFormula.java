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
     for (int i =0; i<formula.length(); i++)
     {       
        
        if(i<formula.length()-1&& Character.isLetter(formula.charAt(i+1)) && Character.isLetter(formula.charAt(i)))
        {
            elements.add(Character.toString(formula.charAt(i))+ Character.toString(formula.charAt(i+1)));
        }   
        else if(i>0 && Character.isLetter(formula.charAt(i))&& Character.isDigit(formula.charAt(i-1)))
        {
          elements.add(Character.toString(formula.charAt(i)));
        }
        else if(i==0 & Character.isLetter(formula.charAt(i)))
        {
            elements.add(Character.toString(formula.charAt(i)));
        }
        
        
        }
     
          for (String element: elements)
          {
              System.out.println(element);
          }
 
              
 }

     public static void main (String[] args)
     {
         MolecularFormula one = new MolecularFormula("H2FE2O");
     }
 }


    

