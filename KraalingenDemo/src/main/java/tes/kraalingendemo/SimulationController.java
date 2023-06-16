/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;
import java.util.Properties; 

final public class SimulationController implements 
ISimulationController { 
private static SimulationController uniquelnstance=null;  
private IPlant plant; 
private ISoil soil; 
private IWeather weather; 
private Properties props; 
 
private SimulationController(){ 
plant = new Plant(); 
soil = new Soil(); 
weather = new WeatherDataFromFile(); 

//Establish relation Soil-Plant 
plant. setSoil(soil); 
soil.setPlant(plant); 

//Establish relation Plant-Weather 
plant.setWeather(weather); 
//Establish relation Soil-Weather 
soil.setWeather(weather); 
} 

public static SimulationController getlnstance(){ 
if (uniquelnstance == null) 
    uniquelnstance = new SimulationController(); 
    return uniquelnstance; 
} 
 
public void simulate(Properties props) { 
// Initializations 
weather.initialize(props); 
soil.initialize(props); 
plant.initialize(props); 
while (weather.hasNext()) { 
    weather.next(); 
    soil.calculateRate(); 
    if (plant. isPostPlanting()) 
    plant.calculateRate(); 
    soil.integrate(); 
    if (plant.isPostPlanting()) 
        plant.integrate(); 
    if(plant.isMature()) { 
        plant.setMaturityDay(); 
        saveFinalResults(); 
        return; 
        } 
    } 
} 
public Properties getPropertyFile(){ 
    return props; 
} 

private void saveFinalResults(){ 
    props = new Properties(); 
    props.put("totalPlantDryWeight", new Double( plant.getTotalPlantDryWeight())); 
    props.put("rootDry Weight",new Double(plant.getRootDryWeight())); 
    props.put("fruitDryWeight", new Double(plant.getFruitDryWeight())); 
    props.put("maturityDay", new Integer (plant.getMaturityDay())); 
    } 
}