package Ejercicio3;

public class CerrarPuertaCommand implements Command {
    private Puerta puerta;

    public CerrarPuertaCommand(Puerta puerta) {
        this.puerta = puerta;
    }

    @Override
    public void ejecutar() {
        puerta.cerrar();
    }

    @Override
    public void deshacer() {
        puerta.abrir();
    }
}
