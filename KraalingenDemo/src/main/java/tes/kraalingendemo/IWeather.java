/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tes.kraalingendemo;
import java.util.Iterator; 
import java.util.Properties; 

public interface IWeather extends Iterator { 
    public double getSolarRadiation(); 
    public double getAverageTempDuringDay(); 
    public double getAverageTemperaturc(); 
    public double getAverageTemperatureForPT(); 
    public double getRainFall(); 
    public double getTemperaturcMin(); 
    public double getTemperaturcMax(); 
    public double getPAR(); 
    public int getDayOfYear(); 
    public void initialize(Properties props); 
} 
