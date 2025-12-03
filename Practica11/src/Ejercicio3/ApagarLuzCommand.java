package Ejercicio3;

public class ApagarLuzCommand implements Command {
    private Luz luz;

    public ApagarLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutar() {
        luz.apagar();
    }

    @Override
    public void deshacer() {
        luz.encender();
    }
}
