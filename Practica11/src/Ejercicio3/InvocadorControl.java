package Ejercicio3;

public class InvocadorControl {

    private Command ultimoComando;

    public void ejecutarComando(Command comando) {
        comando.ejecutar();
        ultimoComando = comando;
    }

    public void deshacerUltimo() {
        if (ultimoComando != null) {
            ultimoComando.deshacer();
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }
}
