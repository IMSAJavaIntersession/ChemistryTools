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
        elm[1] = new Element("Hydrogen",1,"H",1.0);
    }
    public Element getElement(String symbol){
        for(int i = 0; i<2; i++){
            if (elm[i].getSymbol() == symbol){
                return elm[i];
            }
        }
        return null;
    }
}
