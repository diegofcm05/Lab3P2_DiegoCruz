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
                    AddMoto();
                    
                    break;
                }
                case 3: {
                    AddBus();
                    break;
                }
                case 4: {
                    if (registro.isEmpty()){
                        System.out.println("No hay vehiculos para modificar. Agregue un vehiculo primero.");
                    }
                    else{
                        System.out.println("Los vehiculos disponibles para modificar son: ");
                        for (Vehiculo vehiculo : registro) {
                            System.out.println((registro.indexOf(vehiculo)+1)+"- "+vehiculo.getClass().getSimpleName()+" -"+vehiculo);
                            
                        }
                        System.out.println("Ingrese el indice del vehiculo que quiere modificar: ");
                        int ind = sc.nextInt();
                        if (ind > 0 && ind<= registro.size()){
                                                   
                            if (registro.get(ind-1) instanceof Automovil){
                                ModAuto(ind-1);
                            }
                            else if (registro.get(ind-1) instanceof Motocicleta){
                                ModMoto(ind-1);
                            }
                            else{
                                ModBus(ind-1);   
                            }
                        }
                        else{
                            System.out.println("El indice que selecciono esta fuera de rango.");
                        }
                    }
                    
                    break;
                }
                case 5:{
                    if (registro.isEmpty()){
                        System.out.println("No hay vehiculos para eliminar. Agregue un vehiculo primero.");
                    }
                    else{
                        System.out.println("Los vehiculos disponibles para eliminar son:");
                        for (Vehiculo vehiculo : registro) {
                            System.out.println((registro.indexOf(vehiculo)+1)+"- "+vehiculo);
                            
                        }
                        System.out.println("Ingrese el indice del vehiculo que quiere eliminar: ");
                        int ind = sc.nextInt();
                        if (ind> 0 && ind<= registro.size()){
                            System.out.println("Esta seguro de que quiere eliminar este vehiculo? Presione 1 para confirmar.");
                            int dest = sc.nextInt();
                            if (dest ==1){
                                registro.remove(ind-1);
                                System.out.println("El vehiculo se ha eliminado exitosamente.");
                            }
                            else{
                                System.out.println("No se ha eliminado el vehiculo. Regresara al menu principal.");
                            }
                        }
                        else{
                            System.out.println("El indice que selecciono esta fuera de rango. Regresara al menu principal.");
                        }
                    }
                    break;
                }
                case 6:{
                    if (registro.isEmpty()){
                        System.out.println("No hay vehiculos para listar. Agregue un vehiculo primero.");
                    }
                    else{
                        int total1 = 0, total2= 0, total3= 0;
                        System.out.println("La lista completa de vehiculos es:");
                        System.out.println("");
                        System.out.println("Automoviles: ");
                        for (Vehiculo vehiculo : registro) {
                            if(vehiculo instanceof Automovil){
                                
                                total1++;
                                System.out.println(total1+"- "+vehiculo);
                            }


                        }
                        System.out.println("El total de Automoviles es: "+total1);
                        System.out.println("");
                        System.out.println("Motocicletas: ");
                        for (Vehiculo vehiculo : registro) {
                            if(vehiculo instanceof Motocicleta){
                                
                                total2++;
                                System.out.println(total2+"- "+vehiculo);
                            }

                        }
                        System.out.println("El total de Motocicletas es: "+total2);
                        System.out.println("");
                        System.out.println("Autobuses ");
                        for (Vehiculo vehiculo : registro) {
                            if(vehiculo instanceof Autobus){
                                
                                total3++;
                                System.out.println(total3+"- "+vehiculo);
                            }

                        }
                        System.out.println("El total de Autobuses es: "+total3);
                    }
                    break;
                }
                case 7:{
                    if (registro.isEmpty()){
                        System.out.println("No se peude generar una boleta para un vehiculo ya que no hay vehiculos. Agregue un vehiculo primero.");
                    }
                    else{
                        double subtotal = 525;
                        System.out.println("Los vehiculos disponibles para generar una boleta son:");
                        for (Vehiculo vehiculo : registro) {
                            System.out.println((registro.indexOf(vehiculo)+1)+"- "+vehiculo);
                            
                        }
                        System.out.println("Ingrese el indice del vehiculo del cual quiere generar una boleta: ");
                        int ind = sc.nextInt();
                        if (ind> 0 && ind<= registro.size()){
                            System.out.println("Boleta de Revision Vehicular: ");
                            System.out.println("Datos del Vehiculo: ");
                            System.out.println("Vehiculo: "+registro.get(ind-1).getClass().getSimpleName());
                            System.out.println("Placa: "+registro.get(ind-1).getPlaca());
                            System.out.println("Marca: "+registro.get(ind-1).getMarca());
                            System.out.println("Modelo: "+registro.get(ind-1).getModelo());
                            System.out.println("Tipo de Vehiculo: "+registro.get(ind-1).getTipo());
                            System.out.println("Color: "+registro.get(ind-1).getColor());
                            System.out.println("Año "+registro.get(ind-1).getAnio().getYear());
                            if(registro.get(ind-1) instanceof Automovil){
                                subtotal+=1200;
                            }
                            if(registro.get(ind-1) instanceof Motocicleta){
                                subtotal+=200;
                            }
                            if(registro.get(ind-1) instanceof Autobus){
                                subtotal+=1000;
                            }
                            System.out.println("");
                            System.out.println("El Total a Pagar de la Tasa Vehicular de este vehiculo es: "+subtotal);
                        }
                        else{
                            System.out.println("El indice que selecciono esta fuera de rango. Regresara al menu principal.");
                        }
                        
                        
                    }
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
            System.out.println("");

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
        String placa, marca, modelo, tipo= "", tipocomb="", tipotransm;
        int puertas, asientos, choosetipo, aniox, choosecm;
        Color color;
        Date anio = new Date();
        System.out.println("A continuacion agregara un auto. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaAutos(placa) || !PlacaDif(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con H. Ademas, la placa no puede ser igual.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoja el tipo de carro");
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
        while (aniox <1){
            System.out.println("Ingrese un numero valido.");
            aniox = sc.nextInt();
        }
        anio.setYear(aniox);
        System.out.println("Escoja tipo de Combustible del auto:");
        System.out.println("1. Super");
        System.out.println("2. Regular");
        System.out.println("3. Diesel");
        choosecm = sc.nextInt();
        while (choosecm<1 || choosecm >3){
            System.out.println("Ingrese un indice valido.");
            choosecm = sc.nextInt();
        }
        switch (choosetipo) {
            case 1: {
                tipocomb = "Super";
                break;
            }
            case 2: {
                tipocomb = "Regular";
                break;
            }
            case 3: {
                tipocomb = "Diesel";
                break;
            }
        }
        System.out.println("Ingrese el tipo de Transmision (Manual/Automatica):");
        tipotransm = sc_st.nextLine();
        System.out.println("Ingrese el numero de puertas del auto:");
        puertas = sc.nextInt();
        while (puertas<1){
            System.out.println("Amigo, no se puede entrar a su carro! Ingrese un numero valido.");
            puertas = sc.nextInt();
        }
        System.out.println("Ingrese el numero de asientos del auto:");
        asientos = sc.nextInt();
        while (asientos<1){
            System.out.println("Ingrese un numero valido (mayor a 0).");
            asientos = sc.nextInt();
        }
        Automovil nauto = new Automovil(tipocomb, tipotransm, puertas, asientos, placa, marca, modelo, tipo, color, anio);
        registro.add(nauto);
        System.out.println("El automovil se ha creado exitosamente!");
    }
    
    public static void AddMoto(){
        String placa, marca, modelo, tipo= "";
        Color color;
        Date anio = new Date();
        int aniox, choosetipo;
        double vel, peso, consumo;
        System.out.println("A continuacion agregara una moto. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaMoto(placa)|| !PlacaDif(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con B. Ademas, la placa no puede ser igual.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoja el tipo de moto");
        System.out.println("1. Normal");
        System.out.println("2. Custom");
        System.out.println("3. Otro");
        choosetipo = sc.nextInt();
        while (choosetipo<1 || choosetipo >3){
            System.out.println("Ingrese un indice valido.");
            choosetipo = sc.nextInt();
        }
        switch (choosetipo) {
            case 1: {
                tipo = "Normal";
                break;
            }
            case 2: {
                tipo = "Custom";
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
        while (aniox <1){
            System.out.println("Ingrese un numero valido.");
            aniox = sc.nextInt();
        }
        anio.setYear(aniox);
        System.out.println("Ingrese la velocidad maxima de la motocicleta (Km/h):");
        vel = sc.nextDouble();
        while (vel<1){
            System.out.println("Ingrese un numero valido (1 en adelante.)");
            vel = sc.nextDouble();
        }
        System.out.println("Ingrese el peso del vehiculo: (en kg)");
        peso = sc.nextDouble();
        while (peso<1){
            System.out.println("Ingrese un numero valido (1 en adelante.)");
            peso = sc.nextDouble();
        }
        System.out.println("Ingrese el Consumo de Combustible del Vehiculo (en L/Km)");
        consumo = sc.nextDouble();
        while (consumo<1){
            System.out.println("Ingrese un numero valido (1 en adelante.)");
            consumo = sc.nextDouble();
        }
        Motocicleta nmoto = new Motocicleta(vel, peso, consumo, placa, marca, modelo, tipo, color, anio);
        registro.add(nmoto);
        System.out.println("La motocicleta ha sido agregada exitosamente!!");
        
        
    }
    
    public static void AddBus(){
        String placa, marca, modelo, tipo = "";
        Color color;
        Date anio = new Date();
        int capacidad, ejes, aniox, choosetipo;
        double longitud;
        System.out.println("A continuacion agregara un autobus. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaAutos(placa)|| !PlacaDif(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con H. Ademas, la placa no puede ser igual.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoja el tipo de autobus");
        System.out.println("1. Rapidito");
        System.out.println("2. Bus de Ruta");
        System.out.println("3. Otro");
        choosetipo = sc.nextInt();
        while (choosetipo<1 || choosetipo >3){
            System.out.println("Ingrese un indice valido.");
            choosetipo = sc.nextInt();
        }
        switch (choosetipo) {
            case 1: {
                tipo = "Rapidito";
                break;
            }
            case 2: {
                tipo = "Bus de Ruta";
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
        while (aniox <1){
            System.out.println("Ingrese un numero valido.");
            aniox = sc.nextInt();
        }
        anio.setYear(aniox);
        System.out.println("Ingrese la capacidad de pasajeros del bus:");
        capacidad = sc.nextInt();
        while (capacidad <1){
            System.out.println("Ingrese un numero valido.");
            capacidad = sc.nextInt();
        }
        System.out.println("Ingrese los ejes del vehiculo:");
        ejes = sc.nextInt();
        System.out.println("Ingrese la longitud del vehiculo:");
        longitud = sc.nextDouble();
        Autobus nbus = new Autobus(capacidad, ejes, longitud, placa, marca, modelo, tipo, color, anio);
        registro.add(nbus);
        System.out.println("El autobus ha sido agregado exitosamente!");
                
    }
    
    public static void ModAuto(int index){
        String placa, marca, modelo, tipo= "", tipocomb, tipotransm;
        int puertas, asientos, choosetipo, aniox;
        Color color;
        Date anio = new Date();
        System.out.println("A continuacion modificara un auto. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaAutos(placa)|| !PlacaDif(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con H. Ademas, la placa no puede ser igual.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoja el tipo de carro");
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
        while (aniox <1){
            System.out.println("Ingrese un numero valido.");
            aniox = sc.nextInt();
        }
        anio.setYear(aniox);
        System.out.println("Ingrese el tipo de Combustible del auto:");
        tipocomb = sc_st.nextLine();
        System.out.println("Ingrese el tipo de Transmision:");
        tipotransm = sc_st.nextLine();
        System.out.println("Ingrese el numero de puertas del auto:");
        puertas = sc.nextInt();
        while (puertas<1){
            System.out.println("Amigo, no se puede entrar a su carro! Ingrese un numero valido.");
            puertas = sc.nextInt();
        }
        System.out.println("Ingrese el numero de asientos del auto:");
        asientos = sc.nextInt();
        while (asientos<1){
            System.out.println("Ingrese un numero valido (mayor a 0).");
            asientos = sc.nextInt();
        }
        Automovil nauto = new Automovil(tipocomb, tipotransm, puertas, asientos, placa, marca, modelo, tipo, color, anio);
        registro.set(index, nauto);
        System.out.println("El automovil se ha modificado exitosamente!");
    }
    
    public static void ModMoto(int index){
        String placa, marca, modelo, tipo= "";
        Color color;
        Date anio = new Date();
        int aniox, choosetipo;
        double vel, peso, consumo;
        System.out.println("A continuacion modificara una moto. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaMoto(placa)|| !PlacaDif(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con H. Ademas, la placa no puede ser igual.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoja el tipo de moto");
        System.out.println("1. Normal");
        System.out.println("2. Cuatrimoto");
        System.out.println("3. Otro");
        choosetipo = sc.nextInt();
        while (choosetipo<1 || choosetipo >3){
            System.out.println("Ingrese un indice valido.");
            choosetipo = sc.nextInt();
        }
        switch (choosetipo) {
            case 1: {
                tipo = "Normal";
                break;
            }
            case 2: {
                tipo = "Cuatrimoto";
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
        while (aniox <1){
            System.out.println("Ingrese un numero valido.");
            aniox = sc.nextInt();
        }
        anio.setYear(aniox);
        System.out.println("Ingrese la velocidad maxima de la motocicleta:");
        vel = sc.nextDouble();
        System.out.println("Ingrese el peso del vehiculo:");
        peso = sc.nextDouble();
        System.out.println("Ingrese el Consumo de Combustible del Vehiculo");
        consumo = sc.nextDouble();
        Motocicleta nmoto = new Motocicleta(vel, peso, consumo, placa, marca, modelo, tipo, color, anio);
        registro.set(index,nmoto);
        System.out.println("La motocicleta ha sido modificada exitosamente!!");
    }
    
    public static void ModBus(int index ){
        String placa, marca, modelo, tipo = "";
        Color color;
        Date anio = new Date();
        int capacidad, ejes, aniox, choosetipo;
        double longitud;
        System.out.println("A continuacion modificara un autobus. Ingrese los siguientes datos:");
        System.out.println("Ingrese placa:");
        placa = sc_st.nextLine();
        while (!VeriPlacaAutos(placa)|| !PlacaDif(placa)){
            System.out.println("Ingrese una placa valida. Las placas solo pueden tener 7 caracteres, y deben iniciar con H. Ademas, la placa no puede ser igual.");
            placa = sc_st.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo:");
        marca = sc_st.nextLine();
        System.out.println("Ingrese el modelo");
        modelo = sc_st.nextLine();
        System.out.println("Escoga el tipo de autobus");
        System.out.println("1. Rapidito");
        System.out.println("2. Bus de Ruta");
        System.out.println("3. Otro");
        choosetipo = sc.nextInt();
        while (choosetipo<1 || choosetipo >3){
            System.out.println("Ingrese un indice valido.");
            choosetipo = sc.nextInt();
        }
        switch (choosetipo) {
            case 1: {
                tipo = "Rapidito";
                break;
            }
            case 2: {
                tipo = "Bus de Ruta";
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
        while (aniox <1){
            System.out.println("Ingrese un numero valido.");
            aniox = sc.nextInt();
        }
        anio.setYear(aniox);
        System.out.println("Ingrese la capacidad de pasajeros del bus:");
        capacidad = sc.nextInt();
        while (capacidad <1){
            System.out.println("Ingrese un numero valido.");
            capacidad = sc.nextInt();
        }
        System.out.println("Ingrese los ejes del vehiculo:");
        ejes = sc.nextInt();
        System.out.println("Ingrese la longitud del vehiculo:");
        longitud = sc.nextDouble();
        Autobus nbus = new Autobus(capacidad, ejes, longitud, placa, marca, modelo, tipo, color, anio);
        registro.set(index, nbus);
        System.out.println("El autobus ha sido modificado exitosamente!");
    }
    
    public static boolean PlacaDif(String placa){
        boolean dif = true;
        if (registro.isEmpty()){
            System.out.print("");
        }
        else{
            for (Vehiculo vehiculo : registro) {
                if (vehiculo.getPlaca().equals(placa)){
                    dif = false;
                }
            }
        }
        return dif;
    }
    
    public static boolean VeriPlacaAutos(String placa){
        boolean bueno = false;
        boolean carac = true;
        boolean let1 = true;
        boolean tam = true;
        for (int i = 0; i < placa.length(); i++) {
            char x = placa.charAt(i);
            
            if (i == 0 && x!= 'H'){
                let1 = false;
               
                break;
            }
            
            if (i > 2 && (x<48 || x>57)){
                carac = false;
              
                break;
            }
            
            if (i < 3 && (x<65 || x>90)){
                carac = false;
         
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
    
    
    public static boolean VeriPlacaMoto(String placa){
        boolean bueno = false;
        boolean carac = true;
        boolean let1 = true;
        boolean tam = true;
        for (int i = 0; i < placa.length(); i++) {
            char x = placa.charAt(i);
            
            if (i == 0 && x!= 'B'){
                let1 = false;
                
                break;
            }
            
            if (i > 2 && (x<48 || x>57)){
                carac = false;
                
                break;
            }
            
            if (i < 3 && (x<65 || x>90)){
                carac = false;
                
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
