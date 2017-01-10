package edu.IMSA.Intersession.chemistrytools;

import java.util.*;

public class ChemicalEquation {
    String equation;
    String reactants;
    String products;
    String molecule1;
    String molecule2;
    
    ArrayList<String> moleculeStringList = new ArrayList<String>();
    ArrayList<MolecularFormula> moleculeList = new ArrayList<MolecularFormula>();
    
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
    
    public void seperateMoleculeStrings()
    {
        String[] parts = reactants.split("\\+");
        
        for(int i = 0; i< parts.length; i++)
            moleculeStringList.add(parts[i].trim());
        
        String[] parts2 = products.split("\\+");
        
        for(int i = 0; i< parts2.length; i++)
            moleculeStringList.add(parts2[i].trim());
    }
    
    public void stringToMolecules()
    {
        for(String mol: moleculeStringList){
            moleculeList.add(new MolecularFormula(mol));
        }
    }
    
    public ArrayList getMolecules()
    {
        return moleculeList;
    }
}