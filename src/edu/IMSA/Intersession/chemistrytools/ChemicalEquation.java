package edu.IMSA.Intersession.chemistrytools;

import java.util.*;

public class ChemicalEquation {
    String equation;
    String reactants;
    String products;
    String molecule1;
    String molecule2;
    
    ArrayList<String> moleculeList = new ArrayList<String>();
    
    public ChemicalEquation(String r, String p)
    {
        reactants = r;
        products = p;
    }
   /*
    public void seperateSides()
    {
        String[] parts = equation.split("-");
        equationSide1 = parts[0];
        equationSide2 = parts[1];
    }
   */
    
    public void seperateMolecules()
    {
        String[] parts = reactants.split("\\+");
        
        for(int i = 0; i< parts.length; i++)
            moleculeList.add(parts[i].trim());
        
        String[] parts2 = products.split("\\+");
        
        for(int i = 0; i< parts2.length; i++)
            moleculeList.add(parts2[i].trim());
    }
    
    public ArrayList getMolecules()
    {
        return moleculeList;
    }
}