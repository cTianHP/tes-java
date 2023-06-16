/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tes.kraalingendemo;

/**
 *
 * @author Admin
 */
import java.util.Properties; 
/**
 *
 * @author Admin
 */
public interface IPlant {
    
    //used by the simulator controller 
    public void initialize(Properties props); 
    public void initialize(); 
    public void calculateRate(); 
    public void integratc(); 
    public double getLeafAreaIndex(); 
    public int getMaturityDay(); 
    public boolean isPostPlanting(); 
    public boolean isMaturc(); 
    public void setMaturityDay(); 
    
    //used to set relationships with other classes 
    public void setWeather(IWeather weather); 
    public void setSoil(ISoil soil); 
    
    //used to provide simulaton results to users 
    public double getFruitDryWeight(); 
    public double getRootDryWeight(); 
    public double getTotalPlantDryWeight();
}