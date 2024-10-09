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
    private String marca;
    public ArrayList<Vehiculo> items;

    public Inventario(String marca){
        setMarca(marca);
        this.items = new ArrayList<>();
    }

    public void agregar(Vehiculo vehiculo){
        items.add(vehiculo);
        vehiculo.setInventarioAsignado(this);
    }

    public void listar(Impresora impresora){
        for(Vehiculo vehiculo : items) {
            impresora.imprimir(vehiculo.toString());
        }
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
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
