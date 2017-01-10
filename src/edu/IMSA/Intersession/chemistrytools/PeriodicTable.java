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
    int n;
    
    Element[] elm = new Element[3];
    //String[] sym = new String[3];
    
    
    
    public PeriodicTable(){
        
        elm[0] = new Element("Oxygen", 9, "O",15.9);
    }
    public Element getElement(String symbol){
        int n = 9000;
        for(int i = 0; i<1; i++){
            if (elm[i].getSymbol() == symbol){
                
                n=i;
            }
        }
        return elm[n];
    }
}
