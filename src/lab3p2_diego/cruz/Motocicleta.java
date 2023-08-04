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
public class Motocicleta extends Vehiculo{
    
    private double vel, peso, consumo;

    public Motocicleta(double vel, double peso, double consumo, String placa, String marca, String modelo, String tipo, Color color, Date anio) {
        super(placa, marca, modelo, tipo, color, anio);
        this.vel = vel;
        this.peso = peso;
        this.consumo = consumo;
    }

    public Motocicleta(String placa, String marca, String modelo, String tipo, Color color, Date anio) {
        super(placa, marca, modelo, tipo, color, anio);
    }

    public double getVel() {
        return vel;
    }

    public void setVel(double vel) {
        this.vel = vel;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Motocicleta{" + "vel=" + vel + ", peso=" + peso + ", consumo=" + consumo + '}';
    }
    
    
    
    
    
}
