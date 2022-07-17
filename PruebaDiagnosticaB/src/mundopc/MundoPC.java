package mundopc;

import com.gm.mundopc.*;

public class MundoPC {

    public static void main(String[] args) {

        //computadora toshiba
        Monitor monitorToshi = new Monitor("toshiba",13);
        Teclado tecladoToshi = new Teclado("bluetooth","Toshiba");
        Raton ratonToshi = new Raton("bluetooth","Toshiba");
        Computadora computadoraToshiba = new Computadora("Computadora Toshiba",monitorToshi,tecladoToshi,ratonToshi);

        //computadora dell
        Monitor monitorDell = new Monitor("Dell",24);
        Teclado tecladoDell = new Teclado("usb","Dell");
        Raton ratonDell = new Raton("usb","Dell");
        Computadora computadoraDell = new Computadora("Computadora Dell",monitorDell,tecladoDell,ratonDell);

        //computadora hp
        Monitor monitorHP = new Monitor("HP",27);
        Teclado tecladoHP = new Teclado("usb","HP");
        Raton ratonHP = new Raton("usb","HP");
        Computadora computadoraHP = new Computadora("Computadora HP",monitorHP,tecladoHP,ratonHP);

        //computadora armada

        Computadora pc = new Computadora("Pc armada",monitorDell,tecladoHP,ratonToshi);

        //se agrega a la orden
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraDell);
        orden1.agregarComputadora(computadoraHP);
        orden1.agregarComputadora(computadoraToshiba);
        orden1.mostrarOrden();

        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadoraDell);
        orden2.agregarComputadora(computadoraHP);
        orden2.agregarComputadora(computadoraToshiba);
        orden2.mostrarOrden();


    }
}
