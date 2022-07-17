package com.gm.mundopc;

public class Computadora {
    //atributos
    private int idComputadora;

    private String nombre;

    private Monitor monitor;

    private Teclado teclado;

    private Raton raton;

    private static int contadorComputadora;

    //constructores
    private Computadora() {idComputadora = ++contadorComputadora;}

    public Computadora(  String nombre, Monitor monitor, Teclado teclado, Raton raton) {
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Raton getRaton() {
        return raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }


    @Override
    public String toString(){
        return "Computadora [id= "+idComputadora+", nombre= "+nombre+", Monitor= "+monitor+", Teclado= "
                +teclado+", Raton= "+raton+"]";
    }
}
