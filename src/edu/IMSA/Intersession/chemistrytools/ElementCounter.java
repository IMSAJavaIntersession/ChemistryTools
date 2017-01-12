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
    public static void main(String[] args) {
      Map<Element, Integer> m1 = new HashMap(); 
      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);
   }
    
    public void updateElements(MolecularFormula molecule){
  //      molecule.getelements
   //     for (Map.Entry<)
    }
    public Map<Element, String> compareMap(Map<Element, Integer> m1, Map<Element, Integer> map){
        Map<Element, String> results = new HashMap();
        for (Map.Entry<Element, Integer> e: m1.entrySet()){
            Integer val1 = e.getValue();
            Integer val2 = map.get(e.getKey());
            String Val = val1 + ":" + (val2 != null ? val2 : 0);
            results.put(e.getKey(), Val);
        }
        return results;
    }
}


