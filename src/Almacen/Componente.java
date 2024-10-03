/*
 * Project: FabricaAutomotriz
 * Package: Almacen
 * Class: Componente
 * Version: 1.0
 * Date: 26/09/2024 18:54
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */
package Almacen;

public abstract class Componente {
    public Integer numero;
    public float precio;


    public Componente(Integer numero, float precio){
        this.numero = numero;
        this.precio = precio;
    }

    // TODO: hacer método mostrarDatos
}
