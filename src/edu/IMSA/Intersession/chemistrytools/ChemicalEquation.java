package edu.IMSA.Intersession.chemistrytools;

import java.util.*;
import java.util.regex.Pattern;

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
    
    public static void main(String[] args){
        ChemicalEquation chem = new ChemicalEquation("H2 + O2 + C2 + Li8", "H2O + H5O7");
        chem.seperateMolecules();
        
        ArrayList<String> output = chem.getMolecules();
        
        for(String k: output)
        {
            System.out.println(k);
        }
    }
}