/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

/**
 *
 * @author Admin
 */
public class PlantFactory { 
public PlantFactory() {} 

public Plant createPlant (String plantName) { 

Plant newPlant = null; 
if (plantName.equals("maize")) newPlant = new Maize(); 
else 
if (plantName.equals("wheat")) newPlant=new Wheat(); 
else 
if (plantName.equals("rice")) newPlant = new Rice(); 
return newPlant; 
} 
} 
