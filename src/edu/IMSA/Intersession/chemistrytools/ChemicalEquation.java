package edu.IMSA.Intersession.chemistrytools;

import java.io.FileNotFoundException;
import java.util.*;

public class ChemicalEquation {
    String equation;
    
    String reactants;
    String products;
    
    ArrayList<String> moleculeStringListProducts = new ArrayList<String>();
    ArrayList<MolecularFormula> moleculeListProducts = new ArrayList<MolecularFormula>();
    
    ArrayList<String> moleculeStringListReactants = new ArrayList<String>();
    ArrayList<MolecularFormula> moleculeListReactants = new ArrayList<MolecularFormula>();
    
    public ChemicalEquation(String r, String p) throws FileNotFoundException
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
    
    public void stringToMolecules() throws FileNotFoundException
    {
        for(String mol: moleculeStringListProducts){
            moleculeListProducts.add(new MolecularFormula(mol));
        }
        for(String mol: moleculeStringListReactants){
            moleculeListReactants.add(new MolecularFormula(mol));
        }
    }
    
    public ArrayList getProducts(){
        return moleculeListProducts;
    }
    public ArrayList getReactants(){
        return moleculeListReactants;
    }
    
    public String toString(){
        return reactants + " --> " + products;
    }
}