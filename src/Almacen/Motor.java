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

    public Motor(int cantidadCilindros, int cilindrada, float precio) {
        super(precio);
        this.cantidadCilindros = cantidadCilindros;
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return ("Motor:\n" + "  Cilindros: " + this.getCantidadCilindros() + "\n" +"  Cilindrada: "
                + this.getCilindrada() + " cc\n" + "  Precio: $" +this.getPrecio()+ "\n");
    }

    public int getCantidadCilindros() {
        return cantidadCilindros;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}
