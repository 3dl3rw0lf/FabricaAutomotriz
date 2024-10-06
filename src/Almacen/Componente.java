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

import java.util.HashSet;
import java.util.Random;

public abstract class Componente {
    public Integer numero;
    public float precio;

    private static HashSet<Integer> numerosIdentificadores = new HashSet<>();
    private static final Random random = new Random();


    /**
     * Método para generar un número único.
     * Se repite hasta encontrar un número no existente en el HashSet.
     *
     * @return Número único generado
     */
    private Integer generarID() {
        int numeroIdentificador;
        do {
            numeroIdentificador = random.nextInt(2147483646) + 1;
        } while (numerosIdentificadores.contains(numeroIdentificador));
        numerosIdentificadores.add(numeroIdentificador);
        return numeroIdentificador;
    }

    public Componente(float precio){
        this.numero = generarID();
        this.precio = precio;
    }

    // TODO: hacer método mostrarDatos
}
