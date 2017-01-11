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
    
    Element[] elm = new Element[3];
    //String[] sym = new String[3];
    
    
    
    /*public PeriodicTable(){
        
        elm[0] = new Element("Oxygen", 9, "O",15.9);
        elm[1] = new Element("Hydrogen",1,"H",1.0);
    }
    */
    public Element getElement(String symbol){
        for(int i = 0; i<2; i++){
            if (elm[i].getSymbol().equals(symbol)){
                return elm[i];
            }
        }
        return null;
    }
    /*public static void loadFile() throws FileNotFoundException
	{
		scan1 = new Scanner (new File("pt-data.txt"));
		elementList = new ArrayList<>();
		while (scan1.hasNext())
		{
			elementList.add(scan1.nextLine());
		}
                System.out.println(elementList);
    }
    */    

    public PeriodicTable()
    {
        elementList = new ArrayList<>();
    }
    
    public static void populate()
    {
        try {
            scan = new Scanner (new File("pt-data.txt"));
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
    public static ArrayList<Element> getElementList()
    {
        return elementList;
    }
    
    public void search(String search)
    //Type in a name and print out the ranks for each decade of that name
    {
        int zx = 0;
        for(int i = 0; i < elementList.size(); i++)
        {
            if(search.equals(elementList.get(i).getName()))
            {
                zx = 2;
                System.out.println(elementList.get(i).getSymbol() + " " );
                System.out.println(elementList.get(i).getAtomicNumber() + " " );
                System.out.println(elementList.get(i).getWeight() + " " );
            }
        }
        if (zx == 0)
            System.out.print("Not FOund Baka");
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PeriodicTable n = new PeriodicTable();
        populate();
        System.out.println("What element do you want info on? (tpye the first letter capital)");
        String findMe = scan.nextLine();
        n.search(findMe);
    }
}
