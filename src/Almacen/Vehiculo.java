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

public class Vehiculo {
    public String marca;
    public String modelo;
    public int peso;
    public Componente motor;
    public Componente carroceria;

    public Vehiculo(String marca, String modelo, int peso) {
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        motor = new Motor(4,1500,3,7777.77f);
        carroceria = new Carroceria("Sedan", "azul", 7,9734.43f);
    }

    public float calcularPrecio(){
        return (float) 0;
    }
}
