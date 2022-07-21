package herencia;

import java.util.Date;

public class Cliente extends Persona{
    private int idCliente;
    private Date fecha;
    private boolean vip;

    private static int contador;

    public Cliente(String nombre, Date fecha, boolean vip) {
        super(nombre);
        this.fecha = fecha;
        this.vip = vip;
        this.idCliente=++contador;
    }

    public Cliente(String nombre, char genero, int edad, String direccion, Date fecha, boolean vip) {
        super(nombre, genero, edad, direccion);
        this.fecha = fecha;
        this.vip = vip;
        this.idCliente=++contador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    public String obtenerDetalle() {
        return super.obtenerDetalle()+" Es VIP: "+this.vip;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", fecha=").append(fecha);
        sb.append(", vip=").append(vip);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
