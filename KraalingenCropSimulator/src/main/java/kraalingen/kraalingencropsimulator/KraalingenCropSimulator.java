package kraalingen.kraalingencropsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Interface IPlant
interface IPlant {
    void grow(int day, double temperature);
    void wither(int day);
    double getFruitDryWeight();
    double getCanopyWeight();
    double getRootWeight();
}

// Interface ISoil
interface ISoil {
    void fertilize(int day);
    void irrigate(int day);
}

// Interface IWeather
interface IWeather {
    double getTemperature(int day);
    void changeWeather(int day);
}

// Class Plant
class Plant implements IPlant {
    private double fruitDryWeight;
    private double canopyWeight;
    private double rootWeight;

    @Override
    public void grow(int day, double temperature) {
        fruitDryWeight += 0.1 * temperature;
        canopyWeight += 0.05 * temperature;
        rootWeight += 0.02 * temperature;

        // Append growth message to the simulationTextArea
        SimulationGUI.appendSimulationText("Day " + day + ": Plant is growing. Fruit Dry Weight: " +
                fruitDryWeight + " kg, Canopy Weight: " + canopyWeight + " kg, Root Weight: " + rootWeight + " kg\n");
    }

    @Override
    public void wither(int day) {
        // Append withering message to the simulationTextArea
        SimulationGUI.appendSimulationText("Day " + day + ": Plant is withering.\n");
    }

    @Override
    public double getFruitDryWeight() {
        return fruitDryWeight;
    }

    @Override
    public double getCanopyWeight() {
        return canopyWeight;
    }

    @Override
    public double getRootWeight() {
        return rootWeight;
    }
}

// Class Soil
class Soil implements ISoil {
    @Override
    public void fertilize(int day) {
        // Append fertilization message to the simulationTextArea
        SimulationGUI.appendSimulationText("Day " + day + ": Soil is being fertilized.\n");
    }

    @Override
    public void irrigate(int day) {
        // Append irrigation message to the simulationTextArea
        SimulationGUI.appendSimulationText("Day " + day + ": Soil is being irrigated.\n");
    }
}

// Class Weather
class Weather implements IWeather {
    private Random random;

    public Weather() {
        random = new Random();
    }

    @Override
    public double getTemperature(int day) {
        // Generate random temperature between 20 and 30
        return 20 + random.nextDouble() * 10;
    }

    @Override
    public void changeWeather(int day) {
        // Append weather change message to the simulationTextArea
        SimulationGUI.appendSimulationText("Day " + day + ": Weather is changing.\n");
    }
}

// Interface ISimulationController
interface ISimulationController {
    void startSimulation(IPlant plant, ISoil soil, IWeather weather, int plantingDay, int maturityDay);
    void stopSimulation();
}

// Class CropSimulator
class CropSimulator implements ISimulationController {
    private boolean isRunning;

    @Override
    public void startSimulation(IPlant plant, ISoil soil, IWeather weather, int plantingDay, int maturityDay) {
        isRunning = true;
        SimulationGUI.appendSimulationText("Simulation started.\n");

        // Print input data
        SimulationGUI.appendSimulationText("Planting Day: " + plantingDay + "\n");
        SimulationGUI.appendSimulationText("Maturity Day: " + maturityDay + "\n");

        // Main simulation loop
        int currentDay = plantingDay;

        while (isRunning && currentDay <= maturityDay) {
            double temperature = weather.getTemperature(currentDay);

            plant.grow(currentDay, temperature);
            soil.fertilize(currentDay);
            soil.irrigate(currentDay);
            weather.changeWeather(currentDay);
            plant.wither(currentDay);

            currentDay++;
        }

        // Print simulation output
        SimulationGUI.appendSimulationText("DOY Maturity: " + maturityDay + "\n");
        SimulationGUI.appendSimulationText("Fruit Dry Weight: " + plant.getFruitDryWeight() + " kg\n");
        SimulationGUI.appendSimulationText("Canopy Weight: " + plant.getCanopyWeight() + " kg\n");
        SimulationGUI.appendSimulationText("Root Weight: " + plant.getRootWeight() + " kg\n");
        SimulationGUI.appendSimulationText("Simulation stopped.\n");
    }

    @Override
    public void stopSimulation() {
        isRunning = false;
        SimulationGUI.appendSimulationText("Simulation stopped.\n");
    }
}

// Class SimulationGUI
class SimulationGUI extends JFrame {
    private JTextField plantingDayField;
    private JTextField maturityDayField;
    private static JTextArea simulationTextArea;

    public SimulationGUI() {
        setTitle("Crop Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel plantingDayLabel = new JLabel("Planting Day:");
        plantingDayField = new JTextField();
        JLabel maturityDayLabel = new JLabel("Maturity Day:");
        maturityDayField = new JTextField();

        inputPanel.add(plantingDayLabel);
        inputPanel.add(plantingDayField);
        inputPanel.add(maturityDayLabel);
        inputPanel.add(maturityDayField);

        // Create simulation panel
        JPanel simulationPanel = new JPanel();
        simulationPanel.setLayout(new BorderLayout());
        simulationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel simulationLabel = new JLabel("Simulation Output:");
        simulationPanel.add(simulationLabel, BorderLayout.NORTH);

        simulationTextArea = new JTextArea();
        simulationTextArea.setEditable(false);
        simulationPanel.add(new JScrollPane(simulationTextArea), BorderLayout.CENTER);

        // Create simulate button
        JButton simulateButton = new JButton("Simulate");
        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }
        });

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(simulationPanel, BorderLayout.CENTER);
        add(simulateButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startSimulation() {
        // Clear simulation text area
        simulationTextArea.setText("");

        // Get input values from the text fields
        int plantingDay = Integer.parseInt(plantingDayField.getText());
        int maturityDay = Integer.parseInt(maturityDayField.getText());

        // Create instances of the required classes
        IPlant plant = new Plant();
        ISoil soil = new Soil();
        IWeather weather = new Weather();
        ISimulationController simulator = new CropSimulator();

        // Start simulation
        simulator.startSimulation(plant, soil, weather, plantingDay, maturityDay);
    }

    public static void appendSimulationText(String text) {
        simulationTextArea.append(text);
    }
}

// Main class
public class KraalingenCropSimulator{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimulationGUI();
            }
        });
    }
}

