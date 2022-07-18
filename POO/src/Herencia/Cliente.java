package Herencia;

import java.util.Date;

public class Cliente extends Persona{
    private int idCliente;
    private Date fechaRegistro;
    private boolean vip;
    private static int contador;

    public Cliente (Date fechaRegistro, boolean vip){
        this.idCliente=++contador;
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public String toString() {
        return super.toString()+ "Cliente{" +
                "idCliente=" + idCliente +
                ", fechaRegistro=" + fechaRegistro +
                ", vip=" + vip +
                '}';
    }
}
