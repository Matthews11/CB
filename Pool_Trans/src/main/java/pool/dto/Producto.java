package pool.dto;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private Integer precio;
    private Date fecha;
    private Categoria categoria;

    private String sku;

    public Producto(){}

    public Producto(Long id, String nombre, Integer precio, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append("|").append(nombre);
        sb.append("|").append(precio);
        sb.append("|").append(fecha);
        sb.append("|").append(categoria.getNombre());
        sb.append("|").append(sku);
        return sb.toString();
    }
}
