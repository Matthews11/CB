package com.gm.mundopc;

public class DispositivosEntrada {

    //atributos
    private String tipoEntrada;

    private String marca;

    //constructor
    public DispositivosEntrada(String tipoEntrada, String marca) {
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    //getter y setter

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //tostring
    @Override
    public String toString() {
        return "DispositivoEntrada [ marca= "+marca+", tipo= "+tipoEntrada;
    }
}
