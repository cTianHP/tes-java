/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;
public class DailyWeatherData { 
private double solarRadiation; 
private double maxTemperature; 
private double minTemperature; 
private double rainFall; 
    public DailyWeatherData(String minTemperature,String maxTemperature, String rainFall,String solarRadiation) { 
        this.solarRadiation=Double.parseDouble(solarRadiation);
        this.maxTemperature=Double.parseDouble(maxTemperature); 
        this.minTemperature=Double.parseDouble(minTemperature); 
        this.rainFall=Double.parseDouble(rainFall); 
    } 

    public double getSoIarRadiation() { 
        return solarRadiation; 
    } 
    public double getTemperatureMax() { 
        return maxTemperature; 
    } 
    public double getTemperatureMin(){ 
        return minTemperature; 
    } 
    public double getRainFall() { 
    return rainFall; 
    } 
    public double getPAR() { 
    return 0.50*getSolarRadiation(); 
    } 
    public double getAverageTempDuringDay() { 
        return 0.6*getTemperatureMax()+0.4*getTemperatureMin(); 
    } 
    public double getAverageTemperatureForPT() { 
        return 0.25* getTemperatureMin()+0.75*getTemperatureMax(); 
    } 
    public double getAverageTemperature() { 
        return 0.5* getTemperatureMin()+0.5 * getTemperatureMax(); 
    } 
} 