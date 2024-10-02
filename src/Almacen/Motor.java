/*
 * Project: FabricaAutomotriz
 * Package: Almacen
 * Class: Motor
 * Version: 1.0
 * Date: 26/09/2024 18:55
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */
package Almacen;

public class Motor extends Componente{
    public int cantidadCilindros;
    public int cilindrada;

    public Motor(int cantidadCilindros, int cilindrada, Integer numero, float precio) {
        super(numero, precio);
        this.cantidadCilindros = cantidadCilindros;
        this.cilindrada = cilindrada;
    }
}
