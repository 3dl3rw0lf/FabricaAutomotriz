
/*
 * Project: Default (Template) Project
 * Package:
 * Class: ${NAME}
 * Version: 1.0
 * Date: 26/09/2024 18:52
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 *
 */
import Almacen.Carroceria;
import Almacen.Inventario;
import Almacen.Motor;
import Almacen.Vehiculo;
import Dispositivo.Impresora;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
 /*       ArrayList<Inventario> inventarios = new ArrayList<>();

        Inventario inventarioFord = new Inventario("ford");
        Inventario invetarioRenault = new Inventario("renault");
        inventarioFord.agregar(new Vehiculo(inventarioFord.getMarca(), "focus", 777));

        inventarios.add(inventarioFord);
        inventarios.add(invetarioRenault);

        Impresora.imprimir(inventarioFord.getMarca());*/

        Motor motor = new Motor(4,4000,6500f);
        String stringMotor = motor.toString();
        System.out.println(stringMotor);

        Carroceria carroceria = new Carroceria("Hull", "azul", 7777f);
        String stringCarroceria = carroceria.toString();
        System.out.println(stringCarroceria);
    }
}