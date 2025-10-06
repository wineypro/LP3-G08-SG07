package modelo;

import java.util.ArrayList;

public class HistorialCompras {
    private ArrayList<String> compras = new ArrayList<>();

    public void registrarCompra(String detalle) {
        compras.add(detalle);
    }

    public ArrayList<String> getCompras() {
        return compras;
    }
}

