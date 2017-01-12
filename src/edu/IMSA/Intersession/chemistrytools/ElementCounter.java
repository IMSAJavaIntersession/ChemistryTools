/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;
import java.util.*;

/**
 *
 * @author student
 */
public class ElementCounter {

    public static Map<Element,String> compareMap(Map<Element, Integer> m1, Map<Element, Integer> map){
            Integer val1=0;
            Integer val2=0;
            Map <Element,String> returnMap = new HashMap<>();
            for (Map.Entry<Element,Integer> e:m1.entrySet())
            {
                val1 = e.getValue();
                if (m1.containsKey(e.getKey()))
                {
                    val2= m1.get(e.getKey());
                }
                else
                {
                    val2=0;
                }
                String Val = Integer.toString(val1) + ":" + Integer.toString(val2);
                returnMap.put(e.getKey(), Val);
            }
         
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
           System.out.println(balanceOneElement("6:8"));
      
      
     }
}


