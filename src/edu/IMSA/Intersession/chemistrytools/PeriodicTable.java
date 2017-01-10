/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

/**
 *
 * @author student
 */
public class PeriodicTable { 
    
    String[] elm = new String[3];
    String[] sym = new String[3];
    
    
    
    public PeriodicTable(String symbol){
        
        elm[0] = "Hydrogen";
        elm[1] = "Helium";
        elm[2] = "Lithium";
        
        sym[0] = "H";
        sym[1] = "He";
        sym[2] = "Li";
    }
    public void getElement(String symbol){
        
        for(int i = 0; i<4; i++){
            if (sym[i] == symbol){
                System.out.println(elm[i]);
            }
            else{}
        }
    }
        
}
