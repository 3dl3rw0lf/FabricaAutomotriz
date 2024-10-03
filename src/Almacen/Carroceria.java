/*
 * Project: FabricaAutomotriz
 * Package: Almacen
 * Class: Carroceria
 * Version: 1.0
 * Date: 26/09/2024 18:55
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */
package Almacen;

public class Carroceria extends Componente{
    public String descripcion;
    public String color;

    public Carroceria(String descripcion, String color, Integer numero, float precio){
        super(numero, precio);
        this.descripcion = descripcion;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Carroceria:" +
                "descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", numero=" + numero +
                ", precio=" + precio;
    }
}
