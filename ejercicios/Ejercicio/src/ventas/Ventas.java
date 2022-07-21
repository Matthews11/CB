package ventas;

import com.gm.ventas.Orden;
import com.gm.ventas.Producto;

public class Ventas {
    public static void main(String[] args) {

        Producto p1 = new Producto("pc1",200);
        Producto p2 = new Producto("pc2",300);
        Producto p3 = new Producto("pc3",400);
        Producto p4 = new Producto("pc3",400);
        Producto p5 = new Producto("pc3",400);

        Orden or = new Orden();
        or.agregarProducto(p1);
        or.agregarProducto(p2);
        or.agregarProducto(p3);
        or.agregarProducto(p4);
        or.agregarProducto(p5);
        or.agregarProducto(p5);

        or.mostrar();

    }
}
