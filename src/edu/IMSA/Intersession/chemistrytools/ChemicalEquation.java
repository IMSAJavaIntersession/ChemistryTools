package edu.IMSA.Intersession.chemistrytools;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;

public class ChemicalEquation {
    String equation;
    
    String reactants;
    String products;
    
    ArrayList<String> moleculeStringListProducts = new ArrayList<String>();
    HashMap<MolecularFormula, Integer> moleculeListProducts = new HashMap<>();
    
    ArrayList<String> moleculeStringListReactants = new ArrayList<String>();
    HashMap<MolecularFormula, Integer> moleculeListReactants = new HashMap<>();
    
    public ChemicalEquation(String r, String p)
    {
        reactants = r;
        products = p;
        
        seperateMoleculeStrings();
        stringToMolecules();
    }
    
    public void seperateMoleculeStrings()
    {
        String[] parts = reactants.split("\\+");
        
        for(int i = 0; i< parts.length; i++)
            moleculeStringListReactants.add(parts[i].trim());
        
        String[] parts2 = products.split("\\+");
        
        for(int i = 0; i< parts2.length; i++)
            moleculeStringListProducts.add(parts2[i].trim());
    }
    
    public void stringToMolecules()
    {
        for(String mol: moleculeStringListProducts){
            moleculeListProducts.put(new MolecularFormula(mol), new Integer(1));
        }
        for(String mol: moleculeStringListReactants){
            moleculeListReactants.put(new MolecularFormula(mol), new Integer(1));
        }
    }
    
    public HashMap<MolecularFormula, Integer> getProducts(){
        return moleculeListProducts;
    }
    public HashMap<MolecularFormula, Integer> getReactants(){
        return moleculeListReactants;
    }
    
    public String toString(){
        return reactants + " --> " + products;
    }
    
    public static void main(String[] args){
        ChemicalEquation chem = new ChemicalEquation("H2O + O2", "CO2");
        
        System.out.println(chem.toString());
        
        for (Map.Entry<MolecularFormula, Integer> entry : chem.getProducts().entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue().toString());
        }
        
    }
}