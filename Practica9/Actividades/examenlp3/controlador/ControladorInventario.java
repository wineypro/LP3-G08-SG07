package examenlp3.controlador;

import examenlp3.modelo.*;

import java.sql.SQLException;
import java.util.List;

public class ControladorInventario {
    private RepositorioArchivo repositorioArchivo;
    // Si luego quieres BD:
    // private RepositorioBD repositorioBD;

    public ControladorInventario(String archivo) {
        this.repositorioArchivo = new RepositorioArchivo(archivo);
        // this.repositorioBD = new RepositorioBD(...);
    }

    // Operaciones de memoria / archivo
    public void registrarAsociacion(Equipo e, Mantenimiento m) {
        repositorioArchivo.agregar(e, m);
    }

    public List<ParAsociado<Equipo, Mantenimiento>> listarAsociaciones() {
        return repositorioArchivo.listar();
    }

    public boolean guardarArchivo() {
        try {
            repositorioArchivo.guardarEnArchivo();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean cargarArchivo() {
        try {
            repositorioArchivo.cargarDesdeArchivo();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // ----------- Operaciones sobre base de datos (opcional) -----------
    public boolean guardarEnBD() {
        try {
            // return repositorioBD.guardarAsociacionesEnBD(listarAsociaciones());
            // Simulación:
            return false; // cambia a true cuando implementes
        } catch (Exception ex) {
            return false;
        }
    }
}