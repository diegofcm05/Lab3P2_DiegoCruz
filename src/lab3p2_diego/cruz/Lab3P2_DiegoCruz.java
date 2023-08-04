/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3p2_diego.cruz;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JColorChooser;

/**
 *
 * @author dfcm9
 */
public class Lab3P2_DiegoCruz {
    
    static Scanner sc_st = new Scanner (System.in);
    static Scanner sc = new Scanner (System.in);
    static ArrayList<Vehiculo> registro = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println("Exito!");
        boolean resp = true;
        while (resp){
            System.out.println("Menu");
            System.out.println("1. Agregar Automovil");
            System.out.println("2. Agregar Motocicleta");
            System.out.println("3. Agregar Autobus");
            System.out.println("4. Modificar Vehiculo ");
            System.out.println("5. Eliminar Vehiculo");
            System.out.println("6. Mostrar Vehiculo");
            System.out.println("7. Generar Boleta");
            System.out.println("8. Salir");
            System.out.println("Ingrese una opcion");
            int op  = sc.nextInt();
            switch (op) {
                case 1: {
                    AddAuto();
                    break;
                }
                case 2: {
                    
                    break;
                }
                case 3: {
                    
                    break;
                }
                case 4: {
                    
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                    break;
                    
                }
                case 8:{
                    resp = false;
                    break;
                }
                default:
                {
                    System.out.println("Opcion Invalida. Ingrese una opcion valida.");
                    break;
                }
                
            }
            
        }
    }
    
    
    public static boolean checknum(String x){
        boolean bueno = true;
        for (int i = 0; i <x.length(); i++) {
            char e = x.charAt(i);
            if (e<48 || e>57){
                bueno = false;
                break;
            }
            
            
        }
        return bueno;
                
    }
    
    public static boolean checkdecimal(String x){
        boolean bueno = true;
        int countpoint = 0;
        for (int i = 0; i <x.length(); i++) {
            char e = x.charAt(i);
            if ((e<48 || e>57) && e!=46){
                bueno = false;
                break;
            }
            if (e == 46){
                countpoint++;
            } 
        }
        
        if(countpoint >1){
            bueno = false;
        }
        return bueno;
                
    }
  
    public static void AddAuto(){
        String placa, marca, modelo, tipo= "", tipocomb, tipotransm;
        int puertas, asientos, choosetipo, aniox;
        Color color;
        Date anio = new Date();
        System.out.println("A continuacion agregara un auto. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaAutos(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con H.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoga el tipo de carro");
        System.out.println("1. Turismo");
        System.out.println("2. Camioneta");
        System.out.println("3. Otro");
        choosetipo = sc.nextInt();
        while (choosetipo<1 || choosetipo >3){
            System.out.println("Ingrese un indice valido.");
            choosetipo = sc.nextInt();
        }
        switch (choosetipo) {
            case 1: {
                tipo = "Turismo";
                break;
            }
            case 2: {
                tipo = "Camioneta";
                break;
            }
            case 3: {
                tipo = "Otro";
                break;
            }
            
        }
        color = JColorChooser.showDialog(null, "Escoga el color del vehiculo", Color.red);
        System.out.println("Ingrese el año del vehiculo: ");
        aniox = sc.nextInt();
        anio.setYear(aniox);
        System.out.println("Ingrese el tipo de Combustible del auto:");
        tipocomb = sc_st.nextLine();
        System.out.println("Ingrese el tipo de Transmision:");
        tipotransm = sc_st.nextLine();
        System.out.println("Ingrese el numero de puertas del auto:");
        puertas = sc.nextInt();
        System.out.println("Ingrese el numero de asientos del auto:");
        asientos = sc.nextInt();
        Automovil nauto = new Automovil(tipocomb, tipotransm, puertas, asientos, placa, marca, modelo, tipo, color, anio);
        registro.add(nauto);
        System.out.println("El automovil se ha creado exitosamente!");
    }
    
    public static boolean VeriPlacaAutos(String placa){
        boolean bueno = false;
        boolean carac = true;
        boolean let1 = true;
        boolean tam = true;
        for (int i = 0; i < placa.length(); i++) {
            char x = placa.charAt(i);
            System.out.println(x);
            if (i == 0 && x!= 'H'){
                let1 = false;
                System.out.println("let1");
                break;
            }
            
            if (i > 2 && (x<48 || x>57)){
                carac = false;
                System.out.println("caranum");
                break;
            }
            
            if (i < 3 && (x<65 || x>90)){
                carac = false;
                System.out.println("caraleT");
                break;
            }
            
        }
        
        if (placa.length()>7){
            tam = false;
        }
        
        if (carac && let1 && tam){
            bueno = true;
           
        }
        
        return bueno;
    }
}
