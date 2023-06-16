/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

/**
 *
 * @author Admin
 */
public class Plant implements Plantlnterface{ 
private double baseTemperature; 
private double fractionCanopy; 
LeafSystem leafSystem = new LeafSystem(); 
RootSystem rootSystem = new RootSystem(); 
StemSystem stemSystem = new StemSystem(); 

public double getLeafArealndex() { 
return leafSystem.getLeafArealndex(); 
} 
Soil theSoil; 
public Plant(){} 

//initilaization methods 
public void setBaseTemperature(double baseTemperature) { 
    this.baseTemperature = baseTemperature; 
} 
public void setFractionCanopy(double fractionCanopy) { 
    this.fractionCanopy = fractionCanopy; 
} 
 
//query methods 
public boolean isMature(){ 
    return getPhenologicalPhase().eqals("maturity"); 
} 
public boolean isPostPlanting() { 
    return weather.getDayOfYear()> getPlantingDate(); 
    } 
} 


