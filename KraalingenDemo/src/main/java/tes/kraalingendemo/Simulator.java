/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tes.kraalingendemo;

/**
 *
 * @author Admin
 */
final class Simulator { 
    private static Simulator instance = null; 
    private Simulator(){}; 
    public static Simulator getlnstance(){ 
        if (instance = null) return new Simulator(); 
        else return instance; 
        } 
} 
