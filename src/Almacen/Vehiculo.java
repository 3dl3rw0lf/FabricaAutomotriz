/*
 * Project: FabricaAutomotriz
 * Package: Almacen
 * Class: Vehiculo
 * Version: 1.0
 * Date: 26/09/2024 19:00
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */
package Almacen;

import java.util.ArrayList;

public class Vehiculo {
    public int peso;
    public Componente[] partes = new Componente[2];
    // public Componente motor;
    // public Componente carroceria;

    // TODO: sacar marca
    public Vehiculo(Motor motor, Carroceria carroceria, int peso) {
        this.peso = peso;
        partes[0] = motor;
        partes[1] = carroceria;
    }

    @Override
    public String toString() {
        return ("---- Vehículo ----\n"+"Peso: "+ this.getPeso()+" kg\n"+"Precio: $"+this.getPrecio()+"\n");
    }

    public float getPrecio(){
        return (partes[0].precio + partes[1].precio) * 2.5f;
    }

    public int getPeso() {
        return peso;
    }

    public Componente[] getPartes() {
        return partes;
    }
}
