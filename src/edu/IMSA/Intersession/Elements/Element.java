/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.IMSA.Intersession.Elements;

import java.util.Scanner;

/**
 *
 * @author student
 */
final public class Element {

    private int atomicNumb;
    private String symbol;
    private String name;
    private double weight1;
    private String weight;
    private Scanner scan;
    
    Element(String name, int atomicNumb, String symbol, double weight){
        this.atomicNumb = atomicNumb;
        this.name = name;
        this.symbol = symbol;
        this.weight1 = weight1;
    }

    public int getAtomicNumber(){
        return atomicNumb;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public String getName(){
        return name;
    }
    
    public double getWeight1() {
        return weight1;
    }
    
    public String getWeight(){
        return weight;
    }
    
    //public static void main(String[] args) {
    //    int ELEMENTS = 118;
    //    Element[] elements = new Element[ELEMENTS];
    //}
    
    public String toString() {
        String s = "";
        s = s +  name   + " (" + symbol + ")\n";
        s = s + "Atomic number: " + atomicNumb + "\n";
        s = s + "Atomic weight: " + weight + "\n";
        return s;
    }
    public static void main(String[] args){
        
    }
    /*public static void main(String[] args) {
        int ELEMENTS = 118;
        Elements[] elementss = new Elements[ELEMENTS];
        String s = scan.nextLine();

        // read data
        for (int i = 0; i < ELEMENTS; i++) {
            s = scan.nextLine();
            String[] fields = s.split(",");
            String name   = fields[0];
            int number    = Integer.parseInt(fields[1]);
            String symbol = fields[2];
            double weight = Double.parseDouble(fields[3]);
            elementss[i] = new Elements(name, number, symbol, weight);
            System.out.println(elementss[i]);
        }
*/
    Element(String line)
    {
        scan = new Scanner(line);
        atomicNumb = scan.nextInt();
        symbol = scan.next();
        name = scan.next();
        weight = scan.next();
        weight1 = Double.parseDouble(weight);
        //System.out.println("Number: "+ atomicNumb + " Symbol: " + symbol + " Name: " + name + " Weight: " + weight2);
        
        
    }
}

