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
            Map<Element, ArrayList<Integer>> differenceMap = ElementCounter.compareMap(elementListReactants, elementListProducts);
            if(differenceMap.isEmpty())break;
            
            for (Map.Entry<Element, ArrayList<Integer>> entry : differenceMap.entrySet()){
                System.out.println(entry.getKey() + "/" + entry.getValue());
            }

            Element el = count(differenceMap);
            
            if(el==null)System.out.println("ELEMENT IS NULL");
            else System.out.println("ELEMENTASDFASZDFASDFASZDF:" + el);
            
            ArrayList<Integer> ratio = ElementCounter.balanceOneElement(differenceMap.get(el));
            
            System.out.println("RATIO:" + ratio);

            ArrayList<MolecularFormula> rmList = findMolHoldingEl2(el, moleculeListReactants);
            ArrayList<MolecularFormula> pmList = findMolHoldingEl2(el, moleculeListProducts);
            
            System.out.println("rmList:" + rmList.size());
            System.out.println(pmList.size());
            
            if(pmList.isEmpty()) System.out.println("List is empty");

            int reactantRatio = ratio.get(0);
            int productRatio = ratio.get(1);

            System.out.println(ratio + " _ " + reactantRatio + ":" + productRatio);

            for(MolecularFormula rm: rmList){
                System.out.println(rm);
                moleculeListReactants.put(rm, moleculeListReactants.get(rm) * reactantRatio);
            }
            for(MolecularFormula pm: pmList){
                System.out.println(pm);
                moleculeListProducts.put(pm, moleculeListProducts.get(pm) * productRatio);
            }
            
            System.out.println(toString());
            stepsList.add(toString() + "\n");
        }
    }
    public MolecularFormula findMolHoldingEl(Element el, Map<MolecularFormula, Integer> map){
        for(Map.Entry<MolecularFormula, Integer> molecule: map.entrySet()){
            if(molecule.getKey().containsElement(el)) return molecule.getKey();
        }
        return null;
    }
    
    public ArrayList <MolecularFormula> findMolHoldingEl2(Element el, Map<MolecularFormula, Integer> map){
        ArrayList<MolecularFormula> m = new ArrayList <MolecularFormula>();
        Element e;
        for(Map.Entry<MolecularFormula, Integer> molecule: map.entrySet()){
            if(molecule.getKey().containsElement(el))
            {
                  m.add(molecule.getKey());  
            }
        }
        return m;
    }
    
    public Element count(Map <Element, ArrayList <Integer>> m1)
    {
        int count=1000000000;
        Element e1=null;
        for (Map.Entry<Element,ArrayList<Integer>> e: m1.entrySet())
        {
            ArrayList <MolecularFormula> a = findMolHoldingEl2(e.getKey(),moleculeListReactants);
            ArrayList <MolecularFormula> b = findMolHoldingEl2(e.getKey(),moleculeListProducts);
            if (a.size()+b.size()<count)
            {
                count=a.size()+b.size();
                e1=e.getKey();
               
            }
            
        }
        return e1;
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
        ChemicalEquation chem = new ChemicalEquation("NH3 + CuO", "Cu + N2 + H2O");
        
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