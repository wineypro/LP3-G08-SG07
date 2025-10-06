package Main;

import modelo.*;
import vista.*;
import controlador.*;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);
        controlador.iniciar();
    }
}
