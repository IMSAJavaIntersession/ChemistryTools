/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;
import edu.IMSA.Intersession.Elements.Element;
import java.util.*;

/**
 *
 * @author student
 */
public class ElementCounter {
            int[] ratios= new int[2];
    public static Map<Element,ArrayList<Integer>> compareMap(Map<Element, Integer> m1, Map<Element, Integer> m2){
        Map <Element,ArrayList<Integer>> returnMap = new HashMap<>();

        for (Map.Entry<Element,Integer> e:m1.entrySet())
        {
            int val1=0;
            int val2=0;
            val1 = e.getValue();
            if (m2.containsKey(e.getKey()))
            {
                val2= m2.get(e.getKey());
            }
            if (val1!=val2)
            {
                ArrayList <Integer> Val = new ArrayList <Integer>();
                Val.add(val1);
                Val.add(val2);
                returnMap.put(e.getKey(),Val);
            }
        }


         
                  System.out.println(returnMap);
                  return returnMap;
    }

    public static ArrayList<Integer> balanceOneElement(ArrayList<Integer> a)
    {
       int val1=0;
       int val2=0;
       int greater=0;
       int lcm;
        val1=a.get(0);
        System.out.println(val1 + "val1");
        val2=a.get(1);
        System.out.println(val2 + "val2");
        if (val1>=val2)
        {
            greater=val1;
        }
        else if(val1<val2)
        {
            greater=val2;
        }
        System.out.println(greater + "greater");
        for (int i=greater; i<=val1*val2;i++)
        {
             double va1=val1;
             double va2=val2;
             double val1d=i/va1;
             double val2d=i/va2;
             if (val1d%1==0 && val2d%1==0)
             {
                     lcm=i;
                     val1=lcm/val1;
                     val2=lcm/val2;
                     break;
             }
        }
        ArrayList<Integer> ratios = new ArrayList<Integer>();
        ratios.add(val1);
        ratios.add(val2);
        return ratios;
    }

    
     public static void main(String[] args) 
     {
           Map <Element, Integer> m1 = new HashMap<>();
           Map <Element, Integer> m2 = new HashMap<>();
           MolecularFormula.of("H2").addElement(m1, 1);
           MolecularFormula.of("O2").addElement(m1, 1);
           MolecularFormula.of("H2O").addElement(m2, 1);
           compareMap(m1,m2);
           //ArrayList<Integer> a = new ArrayList<Integer>();
           //a.add(6);
           //a.add(10);
           //System.out.println(balanceOneElement(a));
      
      
     }
}


