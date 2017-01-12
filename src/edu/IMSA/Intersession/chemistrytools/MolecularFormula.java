/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

import java.util.*;
public class MolecularFormula {
    ArrayList<Element> elements=new ArrayList<Element>();
    String formula;
 public MolecularFormula(String formula)
 {
     this.formula = formula;
     for (int i =0; i<formula.length(); i++)
     {       
        
        if(i<formula.length()-1&& Character.isLetter(formula.charAt(i+1)) && Character.isLetter(formula.charAt(i)))
        {
            elements.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))+ Character.toString(formula.charAt(i+1))));
        }
        else if(i>0 && Character.isLetter(formula.charAt(i))&& Character.isDigit(formula.charAt(i-1)))
        {
          elements.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))));
        }
        else if(i==0 & Character.isLetter(formula.charAt(i)))
        {
            elements.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))));
        }
        else if(i>1&&Character.isDigit(formula.charAt(i))&& Character.isLetter(formula.charAt(i-2)))
        {
            int addElement = Character.getNumericValue(formula.charAt(i));
            while ((addElement-1)>0)
            {
                elements.add(PeriodicTable.getElement(Character.toString(formula.charAt(i-2))+Character.toString(formula.charAt(i-1))));
                addElement--;
            }
        }
        else if (Character.isDigit(formula.charAt(i)))
        {
            int addElement = Character.getNumericValue(formula.charAt(i));
            while ((addElement-1)>0)
            {
                elements.add(PeriodicTable.getElement(Character.toString(formula.charAt(i-1))));
                addElement--;
            }
        }
    }
     
    for (Element element: elements)
    {
        System.out.println(element);
    }     
     
        
 }
 
 public void MolecularWeight()
 {
     double molecularMass = 0;
     for (int i = 0; i<elements.size(); i++){

         molecularMass+=elements.get(i).getWeight1();
         System.out.println("Weight" + elements.get(i).getWeight1());
     }
     System.out.println("Molecular Mass is: " + molecularMass);
 }
 
    public void getElements(Map<Element,Integer> element )
    {
        Boolean isThere=false;
        for (int i=0; i<elements.size();i++)
        {
            if (i>0)
            {
                for (int z=0; z<i;z++)
                {
                    if(elements.get(z).getSymbol().equals(elements.get(i).getSymbol()))
                    {
                        Integer value=element.get(elements.get(z));
                        element.remove(elements.get(z));
                        element.put(elements.get(z),value++);
                        isThere=true;
                    }
                }
            }
            if (!isThere)
                element.put(elements.get(i),new Integer(1));

        }
          
        System.out.println(element);
    }
     public static void main (String[] args)
     {
         MolecularFormula one = new MolecularFormula("H2");
         Map<Element,Integer> m = new HashMap<Element,Integer>();
         one.getElements(m);
     }
     
    public String toString(){
        return formula;
        
    }
     
 }


    

