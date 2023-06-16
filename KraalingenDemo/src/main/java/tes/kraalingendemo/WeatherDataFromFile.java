/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

import java.io.*; 
import java.util.*; 
public class WeatherDataFromFile implements IWeather { 

private int dayOfYear; 
private BufferedReader br=null; 
private DailyWeatherData currentDay=null; 
public WeatherDataFromFile(){} 
 
public void initialize(Properties props) { 
try{ 
    String filcName = props.getProperty("weatherFile"); 
    FileReader fileReader = new FileReader(fileName); 
    br = new BufferedReader(fileReader); 
    setDayOfYear(0); 
    } 
    catch (FileNotFoundException e) 
    { 
    System.out.println("Weather file not found; the system will shut \n" +
    "down") ;
    System.exit(l); // Implementation of the precondition 
    } 
    catch (IOException e){System.out.println("IO Exception");} 
} 
public boolean hasNext() { 
    try { 
        return br.ready(); 
    } 
catch (IOException e){return false;} 
} 
public Object next() {
    try{ 
        String line = (String)br.readLine(); 
        StringTokenizer tokens = new StringTokenizer(line,","); 
        if(line.length()>0) { 
        String [] dailyData = new String [tokens.countTokens()]; 
        dailyData[0] = tokens.nextToken(); 
        dailyData[1] = tokens.nextToken(); 
        dailyData[2] = tokens.nextToken(); 
        dailyData[3] = tokens.nextToken(); 
        dailyData[4] = tokens.nextToken(); 
        currentDay=new Daily WeatherData(dailyData[1], dailyData[2], dailyData[3], dailyData[4]); 
        }
    }    
    catch (IOException e){System.out.println("Error reading data");}
    setDay OfYear(getDayOfYear()+1); 
    return currentDay; 
    }
    public void remove(){} 
    public void setDayOfYear(int dayOfYear) { 
        this.dayOfYear=dayOfYear; 
    } 
    public int getDayOfYear(){ 
        return dayOfYear; 
    } 
    public DailyWeatherData getDailyData(){ 
        return currentDay; 
    } 
    public double getSolarRadiation(){ 
        return currentDay.getSolarRadiation(); 
    } 
    public double getTemperatureMax() { 
        return currentDay.getTemperatureMax(); 
    } 
    public double getTemperatureMin() { 
        return currentDay.getTemperatureMin(); 
    } 
    public double getRainFall(){ 
        return currentDay.getRainFall(); 
    } 
    public double getPAR() { 
        return currentDay.getPAR(); 
    } 
    public double getAverageTempDuringDay(){ 
        return currentDay.getAverageTempDuringDay(); 
    } 
    public double getAveragcTemperatureForPT(){ 
        return currentDay.getAverageTemperatureForPT(); 
    } 
    public double getAveragcTemperature(){ 
        return currentDay.getAverageTemperature(); 
    } 
} 


