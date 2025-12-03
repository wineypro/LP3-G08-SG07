package Ejercicio3;

public class AbrirPuertaCommand implements Command {
    private Puerta puerta;

    public AbrirPuertaCommand(Puerta puerta) {
        this.puerta = puerta;
    }

    @Override
    public void ejecutar() {
        puerta.abrir();
    }

    @Override
    public void deshacer() {
        puerta.cerrar();
    }
}
