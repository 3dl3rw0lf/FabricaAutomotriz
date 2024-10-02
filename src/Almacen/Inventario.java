/*
 * Project: FabricaAutomotriz
 * Package: Almacen
 * Class: Inventario
 * Version: 1.0
 * Date: 26/09/2024 18:54
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */
package Almacen;

import Dispositivo.Impresora;

import java.io.*;
import java.util.ArrayList;

public class Inventario implements Serializable {
    public String marca;
    public ArrayList<Vehiculo> unidades;

    public void agregar(Vehiculo unidad){
        unidades.add(unidad);
    }

    public void listar(Impresora impresora, Vehiculo unidad){
        for(Vehiculo vehiculo : unidades) {
            impresora.imprimir(vehiculo.toString());
        }
    }

/*
    public void grabar(){
        ObjectInputStream  outFile;
        String ser;

        for( it:item){
            String destino = "C:\\";
            try{
                outFile = new ObjectInputStream(new FileInputStream(destino));
                outFile.writeObject((Object)(Vehiculo) item.get(i)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
}
