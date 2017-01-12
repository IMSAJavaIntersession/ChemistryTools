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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class PeriodicTable { 

    private static Scanner scan;
    int n;
    private static String findMe;
private static Scanner scan1;
private static ArrayList<Element> elementList;
      

    private PeriodicTable()
    {
        
    }
    
    static {
        
        elementList = new ArrayList<>();
        populate();
        
    }
    
    public static void populate()
    {
        try {
            scan = new Scanner (new File("pt-data_2.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeriodicTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        elementList = new ArrayList<>();
        String line;
        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            elementList.add( new Element(line));
        }
    }

    public static Element getElement(String search)
    //Type in a name and print out the ranks for each decade of that name
    {
        for(Element e: elementList)
        {
            if((e.getSymbol()).equals(search))
            {
                return e;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PeriodicTable n = new PeriodicTable();
        populate();    
    }
}
