package edu.IMSA.Intersession.chemistrytools;

import java.util.*;

public class ChemicalEquation {
    String equation;
    
    String equationSide1;
    String equationSide2;
    
    ArrayList moleculeList = new ArrayList();
    
    public ChemicalEquation(String inEquation)
    {
        equation = inEquation;
    }
    
    public void seperateSides()
    {
        String[] parts = equation.split("-");
        equationSide1 = parts[0];
        equationSide2 = parts[1];
    }
    
    public void seperateMolecules()
    {
        
    }
    
    public ArrayList getMolecules()
    {
        return moleculeList;
    }
}