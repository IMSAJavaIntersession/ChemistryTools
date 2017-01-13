/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

import edu.IMSA.Intersession.Elements.PeriodicTable;
import edu.IMSA.Intersession.Elements.Element;
import java.io.FileNotFoundException;
import java.util.*;
public class MolecularFormula {
    ArrayList<Element> elements=new ArrayList<Element>();
    String formula;
 private MolecularFormula(String formula,ArrayList<Element> e)
 {
     this.formula = formula;
     this.elements=e;
    
 }
 public static MolecularFormula of(String formula)
 {
     ArrayList<Element> e = new ArrayList<Element>();
     boolean done=false;
     for (int i =0; i<formula.length(); i++)
     {       
        if (i<formula.length()-1 && Character.isLetter(formula.charAt(i)) && Character.isLetter(formula.charAt(i+1)) && Character.isUpperCase(formula.charAt(i))&& Character.isUpperCase(formula.charAt(i+1)))
        {
            e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))));
            Element a=PeriodicTable.getElement(Character.toString(formula.charAt(i+1)));
            e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i+1))));
            i=i+1;
            done=true;
        }
        else if(i<formula.length()-1&& Character.isLetter(formula.charAt(i+1)) && Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i+1)))
        {
            e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))+ Character.toString(formula.charAt(i+1))));
            done=true;
        }
        else if(i>0 && Character.isLetter(formula.charAt(i))&& Character.isDigit(formula.charAt(i-1)))
        {
          e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))));
          done=true;
        }
        else if(i==0 & Character.isLetter(formula.charAt(i)))
        {
           e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i))));
            done=true;
        }
        else if(i>1&&Character.isDigit(formula.charAt(i))&& Character.isLetter(formula.charAt(i-2)) && Character.isLowerCase(formula.charAt(i-1)))
        {
            int addElement = Character.getNumericValue(formula.charAt(i));
            while ((addElement-1)>0)
            {
                e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i-2))+Character.toString(formula.charAt(i-1))));
                addElement--;
            }
            done=true;
        }
                        
        else if(i>1&&Character.isDigit(formula.charAt(i))&& Character.isLetter(formula.charAt(i-2)) && Character.isUpperCase(formula.charAt(i-1)))
        {
            int addElement = Character.getNumericValue(formula.charAt(i));
            while ((addElement-1)>0)
            {
                Element el= PeriodicTable.getElement(Character.toString(formula.charAt(i-1)));
                e.add(el);
                addElement--;
            }
            done=true;
        }
        else if (Character.isDigit(formula.charAt(i)))
        {
            int addElement = Character.getNumericValue(formula.charAt(i));
            while ((addElement-1)>0)
            {
                e.add(PeriodicTable.getElement(Character.toString(formula.charAt(i-1))));
                addElement--;
            }
            done=true;
        }
    }
          for (int count=0;count<e.size();count++)
          {if (e.get(count)==null)
          {
              System.out.println(formula + " is not a valid molecular formula. ");
              break;
          }
          }
          MolecularFormula m=new MolecularFormula(formula,e);
                    return m;

 }
 public double MolecularWeight()
 {
     double molecularMass = 0;
     for (int i = 0; i<elements.size(); i++){
         molecularMass+=elements.get(i).getWeight1();
         System.out.println("Weight: " + elements.get(i).getWeight());
     }
     System.out.println("Molecular Mass is: " + molecularMass);
     return molecularMass;
 }
 
 public Map<Element,Integer> addElement(Map<Element,Integer> elementMap, int molecules)
 {
     for (int i = 0; i<molecules; i++){
     for (Element e:elements)
     {
         if (elementMap.containsKey(e))
         {
             elementMap.put(e,elementMap.get(e)+1);
         }
         
         else
         {
             elementMap.put(e,1);
         }
     }
     }
     return elementMap;
 }
 
 public boolean containsELement(Element e)
 {
     boolean contains=false;
     for(int i=0; i<elements.size();i++)
     {
         if(elements.get(i).equals(e))
         {
             contains=true;
         }
     }
     return contains;
 }
 
 public int getElementCount(String symbol){
    int counter = 0;
    for (int i = 0; i<elements.size(); i++){
        if (symbol.equals(elements.get(i).getSymbol())){
            counter++;
        }
    }
    System.out.println("Counter: " + counter);
    return counter;
 }
 
 public boolean equals(Object O) 
 {
     MolecularFormula mC=(MolecularFormula) O;
     if (mC.getFormula().equals(this.formula))
     {
         return true;
     }
     else
     {
         return false;
     }
 }
 
 public int hashCode()
 {
     return formula.hashCode();
 }
 
    public String getFormula()
    {
        return formula;
    }
     public static void main (String[] args)
     {
         of("CO2");

         
     }
     
    public String toString(){
        return formula;
        
    }
     
     
 }


    

