package edu.IMSA.Intersession.chemistrytools;

import java.util.*;

public class ChemicalEquation {
    String equation;
    
    String reactants;
    String products;
    String molecule1;
    String molecule2;
    
    ArrayList moleculeList = new ArrayList();
    
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
        String[] parts = reactants.split("+");
        moleculeList.add(parts[0]);
        moleculeList.add(parts[0]);
        if(products.contains("+"));
            String[] parts2 = products.split("+");
            moleculeList.add(parts2[0]);
            moleculeList.add(parts2[1]);
    }
    
    public ArrayList getMolecules()
    {
        return moleculeList;
    }
}