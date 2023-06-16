/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tes.kraalingendemo;
import java.util.Properties;
/**
 *
 * @author Admin
 */
public interface SoilInterface {
    public double getSWFac(); 
    public void initialize(); 
    public void initialize(Properties props); 
    public void calculateRate(); 
    public void integrate(); 
    public void setWeather(WeatherInterface weather); 
    public void setPlant(PlantInterface plant); 
}

