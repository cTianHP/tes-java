/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

import java.net.*; 
import java.util.*; 
import java.io.*; 

public class WeatherDataFromStation implements IWeather { 
private int dayOfYear; 
private DailyWeatherData currentDay; 
private BufferedReader buffReader = null; 
private String startingDate, endingDate, stationNumber; 
private URL url=null; 
 
public WeatherDataFromStation() {} 
 
public void initialize(Properties props) { 
try { 
StartingDate = props.getProperty ("startingDate"); 
endingDate = props.getProperty("endingDate"); 
StationNumber = props.getProperty ("stationNumber"); 
url=new URL("http://fawn.ifas.ufl.edu/scripts/fawndataserver.asp?sql=select%20AirTempMin,AirTemMax,Rainfall,TotalRad%20from%20dailysummary%20where%20id="+stationNumber+"%20and%20datetime>="+startingDate+"%20and%20datetime<"+endingDate+" "); 
} 
catch(MalformedURLException me) { 

System.out.println("Cannot connect to the weather station"); 
System.exit(l); 
} 
try { 
buffReader = new BufferedReader(new 
InputStreamReader(url.openStream())); 
String firstLine = (String)buffReader.readLine(); //eliminates the titles 
} 
catch (IOException e){e.printStackTrace();} 
setDayOfYear(0); 
} 
public boolean hasNext(){ 
try { 
return buffReader.ready(); 
} 
catch (IOException e) { 
return false; 
} 
} 
public Object next() { 
try { 
String line = (String)buffReader.readLine(); 
StringTokenizer tokens = new StringTokenizer(line,","); 
if(line.length()>0) { 
String [] dailyData = new String [tokens.countTokens()]; 
dailyData[0] = tokens. nextToken(); 
dailyData[1] = tokens.nextToken();
dailyData[2] = tokens.nextToken(); 
dailyData[3] = tokens.nextToken(); 
currentDay=new DailyWeatherData( dailyData[0],dailyData[1],dailyData[2],dailyData[3]); 
} 
} 
catch (IOException e){} 
setDayOfYear(getDayOfYear()+1); 
return currentDay; 
} 
public void setDayOfYear(int dayOfYear) { 
this.dayOfYear=dayOfYear; 
} 
public int getDayOfYear(){ 
return dayOfYear; 
} 
public double getAverageTemperature() { 
return currentDay.getAverageTemperature(); 
} 
public void remove() {} 
public double getSolarRadiation() { 
return currentDay.getSolarRadiation(); 
} 
public double getAverageTempDuringDay(){ 
return currentDay.getAverageTemperature(); 
} 
public double getAverageTemperatureForPT(){ 
return currentDay.getAverageTemperatureForPT(); 
} 
public double getRainFall() { 
return currentDay.getRainFall(); 
} 
public double getTemperatureMin(){ 
return currentDay.getTemperatureMin(); 
} 
public double getTemperatureMax(){ 
return currentDay.getTemperatureMax(); 
} 
public double getPAR(){ 
return currentDay.getPAR(); 
} 
public double getPotentialET(){ 
return currentDay.getPotentialET(); 
} 
}
