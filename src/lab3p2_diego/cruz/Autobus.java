/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3p2_diego.cruz;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author dfcm9
 */
public class Autobus extends Vehiculo{
    
    private int capacidad, ejes;
    private double longitud;

    public Autobus(int capacidad, int ejes, double longitud, String placa, String marca, String modelo, String tipo, Color color, Date anio) {
        super(placa, marca, modelo, tipo, color, anio);
        this.capacidad = capacidad;
        this.ejes = ejes;
        this.longitud = longitud;
    }

    public Autobus(String placa, String marca, String modelo, String tipo, Color color, Date anio) {
        super(placa, marca, modelo, tipo, color, anio);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    
    
    
    
    
    
    
    
    
}
