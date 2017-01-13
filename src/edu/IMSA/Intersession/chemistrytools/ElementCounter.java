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

    public static Map<Element,String> compareMap(Map<Element, Integer> m1, Map<Element, Integer> m2){
        Map <Element,String> returnMap = new HashMap<>();
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
                String Val = Integer.toString(val1) + ":" + Integer.toString(val2);
                returnMap.put(e.getKey(), Val);
            }
        }


         
                  System.out.println(returnMap);
                  return returnMap;
    }

    public static String balanceOneElement(String ratio)
    {
       int val1=0;
       int val2=0;
       int greater=0;
       int lcm;
        val1=Character.getNumericValue(ratio.charAt(0));
        val2=Character.getNumericValue(ratio.charAt(2));
        if (val1>=val2)
        {
            greater=val1;
        }
        else if(val1<val2)
        {
            greater=val2;
        }
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
        
        return Integer.toString(val1)+":" + Integer.toString(val2);
    }

    
     public static void main(String[] args) 
     {
           Map <Element,Integer> m1=new HashMap<>();
           Map <Element,Integer> m2=new HashMap<>();
           MolecularFormula.of("H2").addElement(m1, 1);
           MolecularFormula.of("O2").addElement(m1,1);
           MolecularFormula.of("H2O").addElement(m2,2);
           ElementCounter.compareMap(m1,m2);
           System.out.println(balanceOneElement("6:8"));
      
      
     }
}


