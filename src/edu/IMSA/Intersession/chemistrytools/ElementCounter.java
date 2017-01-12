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

    public Map<Element,String> compareMap(Map<Element, Integer> m1, Map<Element, Integer> map){
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

    

    
     public static void main(String[] args) {
      ElementCounter eC = new ElementCounter();
      
      
   }
}


