/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

/**
 *
 * @author Admin
 */
public class Weather implements Weatherlnterface { 
    private double solarRadiation; 
    private double rainFall; 
    private double potentialET; 
    private double temperaturcMax; 
    private double temperaturcMin; 
    private double par; 
    public double getSolarRadiation() {return solarRadiation;} 
    public double getRainFall() {return rainFall;} 
    public double getTemperatureMax() {return temperatureMax;} 
    public double getTemperatureMin() {return temperatureMin;} 
    public double getAverageTemperature() { 
    return (getTemperatureMin()+getTemperatureMax())/2; 
    } 
    public double par(){return par;} 
    public double getPotentialET(){return potentialET;} 
    public Weather(){} 
    }
}
