package edu.IMSA.Intersession.chemistrytools;

import edu.IMSA.Intersession.Elements.Element;
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
    
    ArrayList<String> stepsList = new ArrayList<>();
    
    public ChemicalEquation(String r, String p){
        reactants = r;
        products = p;
        
        seperateMoleculeStrings();
        stringToMolecules();
    }
    
    public void seperateMoleculeStrings(){
        String[] parts = reactants.split("\\+");
        
        for(int i = 0; i< parts.length; i++)
            moleculeStringListReactants.add(parts[i].trim());
        
        String[] parts2 = products.split("\\+");
        
        for(int i = 0; i< parts2.length; i++)
            moleculeStringListProducts.add(parts2[i].trim());
    }
    public void stringToMolecules(){
        for(String mol: moleculeStringListProducts){
            MolecularFormula mf= MolecularFormula.of(mol);
            if(mf == null)System.out.println("Oh no we have a problem!");
            
            moleculeListProducts.put(MolecularFormula.of(mol), new Integer(1));
        }
        for(String mol: moleculeStringListReactants){
            MolecularFormula mf= MolecularFormula.of(mol);
            if(mf == null)System.out.println("Oh no we have a problem!");
            
            moleculeListReactants.put(MolecularFormula.of(mol), new Integer(1));
        }
    }  
    public void moleculesToElements(){
        
        elementListProducts.clear();
        elementListReactants.clear();
        
        for(Map.Entry<MolecularFormula, Integer> mol: getProducts().entrySet()){
            mol.getKey().addElement(elementListProducts, mol.getValue());
        }
        
        for(Map.Entry<MolecularFormula, Integer> mol: getReactants().entrySet()){
            mol.getKey().addElement(elementListReactants, mol.getValue());
        }
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
    
    public void balance(){
        for(int i = 0; i < 100; i++){
            moleculesToElements();
            Map<Element, String> differenceMap = ElementCounter.compareMap(elementListReactants, elementListProducts);
            if(differenceMap.isEmpty())break;
            
            for (Map.Entry<Element, String> entry : differenceMap.entrySet()){
                System.out.println(entry.getKey() + "/" + entry.getValue());
            }
            
            for (Map.Entry<Element, String> entry : differenceMap.entrySet()){
                Element el = entry.getKey();
                String ratio = ElementCounter.balanceOneElement(entry.getValue());
                
                MolecularFormula reactantMol = findMolHoldingEl(el, moleculeListReactants);
                MolecularFormula productMol = findMolHoldingEl(el, moleculeListProducts);
                
                String[] parts = ratio.split(":");
                int reactantRatio = Integer.valueOf(parts[0]);
                int productRatio = Integer.valueOf(parts[1]);
                
                moleculeListReactants.put(reactantMol, moleculeListReactants.get(reactantMol) * reactantRatio);
                moleculeListProducts.put(productMol, moleculeListProducts.get(productMol) * productRatio);
                
                break;
            }
            
            stepsList.add(toString() + "\n");
        }
    }
    public MolecularFormula findMolHoldingEl(Element el, Map<MolecularFormula, Integer> map){
        for(Map.Entry<MolecularFormula, Integer> molecule: map.entrySet()){
            if(molecule.getKey().containsElement(el)) return molecule.getKey();
        }
        return null;
    }
    public String getSteps(){
        String returnString = "";
        
        for(int i = 1; i <=stepsList.size(); i++){
            returnString += ("Step " + i + ":" + stepsList.get(i-1));
        }
        
        if(returnString == "") returnString = "No Steps.";
        
        return returnString;
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
        ChemicalEquation chem = new ChemicalEquation("H2 + O2", "H2O");
        
        System.out.println(chem.toString());
        
        for (Map.Entry<MolecularFormula, Integer> entry : chem.getReactants().entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        for (Map.Entry<MolecularFormula, Integer> entry : chem.getProducts().entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        chem.moleculesToElements();
        
        System.out.println("----------------");

        for (Map.Entry<Element, Integer> entry : chem.elementListReactants.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        System.out.println("----------------");
        
        for (Map.Entry<Element, Integer> entry : chem.elementListProducts.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        chem.balance();
        
        System.out.println(chem.getSteps());
    }
}