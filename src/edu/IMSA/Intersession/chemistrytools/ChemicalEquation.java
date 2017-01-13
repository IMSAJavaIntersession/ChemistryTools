package edu.IMSA.Intersession.chemistrytools;

import java.util.*;
import java.util.HashMap;

public class ChemicalEquation {
    String equation;
    
    String reactants;
    String products;
    
    ArrayList<String> moleculeStringListProducts = new ArrayList<String>();
    HashMap<MolecularFormula, Integer> moleculeListProducts = new HashMap<>();
    HashMap<Element, Integer> elementListProducts = new HashMap<>();
    
    ArrayList<String> moleculeStringListReactants = new ArrayList<String>();
    HashMap<MolecularFormula, Integer> moleculeListReactants = new HashMap<>();
    HashMap<Element, Integer> elementListReactants = new HashMap<>();
    
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
    
    public void moleculesToElements(){
        
        elementListProducts.clear();
        elementListReactants.clear();
        
        for(Map.Entry<MolecularFormula, Integer> mol: getProducts().entrySet()){
            for(int i = 0; i < mol.getValue(); i++)mol.getKey().addElement(elementListProducts);
        }
        
        for(Map.Entry<MolecularFormula, Integer> mol: getReactants().entrySet()){
            for(int i = 0; i < mol.getValue(); i++)mol.getKey().addElement(elementListReactants);
        }
        /*
        for(Map.Entry<MolecularFormula, Integer> mol: getProducts().entrySet()){
            
            Map<Element, Integer> elementMap = new HashMap<>();
            mol.getKey().addElement(elementMap);
            
            for(Map.Entry<Element, Integer> element: elementMap.entrySet()){
                if(elementListProducts.containsKey(element.getKey())){
                    elementListProducts.put(element.getKey(), moleculeListProducts.get(element.getKey()) + 1);
                }else{
                    elementListProducts.put(element.getKey(), new Integer(1));
                }
            }
        }
        
        Map<Element, Integer> elementMap = new HashMap<>();
        for(Map.Entry<MolecularFormula, Integer> mol: getReactants().entrySet()){
           
            mol.getKey().addElement(elementMap);
            
            for(Map.Entry<Element, Integer> element: elementMap.entrySet()){
                if(elementListReactants.containsKey(element.getKey())){
                    elementListReactants.put(element.getKey(), moleculeListReactants.get(element.getKey()) + 1);
                }else{
                    elementListReactants.put(element.getKey(), new Integer(1));
                }
            }
        }*/
    }
    
    public HashMap<MolecularFormula, Integer> getProducts(){
        return moleculeListProducts;
    }
    public HashMap<MolecularFormula, Integer> getReactants(){
        return moleculeListReactants;
    }
    
    public void incrementFromProducts(MolecularFormula key){
        moleculeListProducts.put(key, moleculeListProducts.get(key) + 1);
    }
    public void incrementFromReactants(MolecularFormula key){
        moleculeListReactants.put(key, moleculeListReactants.get(key) + 1);
    }
    
    public String toString(){
        String returnString = "";
        
        int counter = 0;
        
        for(Map.Entry<MolecularFormula, Integer> mol : getReactants().entrySet()){
            if(mol.getValue() != 1)returnString += mol.getValue();
            returnString += mol.getKey();
            
            counter++;
            
            if(getReactants().size() != counter) returnString += " + ";
        }
        
        returnString += " --> ";
        
        counter = 0;
        
        for(Map.Entry<MolecularFormula, Integer> mol : getProducts().entrySet()){
            if(mol.getValue() != 1)returnString += mol.getValue();
            returnString += mol.getKey(); 
            
            counter++;
            
            if(getProducts().size() != counter) returnString += " + ";
        }
        
        return returnString;
    }
    
    public static void main(String[] args){
        ChemicalEquation chem = new ChemicalEquation("H2O + O2", "H2O");
        
        System.out.println(chem.toString());
        
        for (Map.Entry<MolecularFormula, Integer> entry : chem.getProducts().entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        for (Map.Entry<MolecularFormula, Integer> entry : chem.getReactants().entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        //chem.incrementFromProducts();
        chem.moleculesToElements();
        
        System.out.println("----------------");
        
        for (Map.Entry<Element, Integer> entry : chem.elementListProducts.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        System.out.println("----------------");
        
        for (Map.Entry<Element, Integer> entry : chem.elementListReactants.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
    }
}