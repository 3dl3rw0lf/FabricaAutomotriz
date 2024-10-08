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

    public Carroceria(String descripcion, String color, float precio){
        super(precio);
        this.descripcion = descripcion;
        this.color = color;
    }

    @Override
    public String toString() {
        return ("Carrocería:\n" + "  Descripción: " + this.getDescripcion() + "\n" +
                "  Color: " + this.getColor() + "\n" + "  Precio: $" + this.getPrecio() + "\n");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getColor() {
        return color;
    }
}
