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
public class Automovil extends Vehiculo{
    
    private String tipcomb, tipotransm;
    private int puertas, asientos;

    public Automovil(String tipcomb, String tipotransm, int puertas, int asientos, String placa, String marca, String modelo, String tipo, Color color, Date anio) {
        super(placa, marca, modelo, tipo, color, anio);
        this.tipcomb = tipcomb;
        this.tipotransm = tipotransm;
        this.puertas = puertas;
        this.asientos = asientos;
    }

    public Automovil(String placa, String marca, String modelo, String tipo, Color color, Date anio) {
        super(placa, marca, modelo, tipo, color, anio);
    }

    public String getTipcomb() {
        return tipcomb;
    }

    public void setTipcomb(String tipcomb) {
        this.tipcomb = tipcomb;
    }

    public String getTipotransm() {
        return tipotransm;
    }

    public void setTipotransm(String tipotransm) {
        this.tipotransm = tipotransm;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }
    
    
    
    
    
    
    
    
}
