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
        String tempReactants = reactants;
        while(tempReactants.contains("+")) {
            String[] parts = tempReactants.split("+");
            moleculeList.add(parts[0]);
            tempReactants = parts[1];
        }
        moleculeList.add(tempReactants);
        String tempProducts = products;
        
        while(tempProducts.contains("+")){
            String[] parts2 = tempProducts.split("+");
            moleculeList.add(parts2[0]);
            tempProducts = parts2[1];
        }
        moleculeList.add(tempProducts);
    }
    
    public ArrayList getMolecules()
    {
        return moleculeList;
    }
}