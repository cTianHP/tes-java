/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

/**
 *
 * @author Admin
 */
public class Adaptor implements InterfaceRitchie { 
    private InterfacelSM ism; 
    public double calculatelnfiltration() { 
        return ism.calculateEffectiveRainfallSCS(); 
    } 
}