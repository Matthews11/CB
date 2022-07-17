package com.gm.mundopc;

public class Monitor {
        //atributos
    private final int idMonitor;

    private String nombre;

    private double tamano;

    private static int contadorMonitor;

    //constructores
    public Monitor() {idMonitor = ++contadorMonitor;
    }

    public Monitor(String nombre, double tamano) {
        this();
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    //tostring
    @Override
    public String toString() {
        return "Monitor [ id= "+idMonitor+", nombre= "+nombre+", tamano= "+tamano;
    }
}
