/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.chemistrytools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class PeriodicTable { 
    int n;
private Scanner scan1;
private ArrayList<String> elementList;
    
    Element[] elm = new Element[3];
    //String[] sym = new String[3];
    
    
    
    public PeriodicTable(){
        
        elm[0] = new Element("Oxygen", 9, "O",15.9);
        elm[1] = new Element("Hydrogen",1,"H",1.0);
    }
    public Element getElement(String symbol){
        for(int i = 0; i<2; i++){
            if (elm[i].getSymbol().equals(symbol)){
                return elm[i];
            }
        }
        return null;
    }
    public void loadFile() throws FileNotFoundException
	{
		scan1 = new Scanner (new File("test/pt-data.txt"));
		elementList = new ArrayList<>();
		while (scan1.hasNext())
		{
			elementList.add(scan1.nextLine());
		}
                System.out.println(elementList);
        }
}
