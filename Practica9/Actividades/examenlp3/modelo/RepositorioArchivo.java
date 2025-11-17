package examenlp3.modelo;

import java.io.*;
import java.time.LocalDate;
import java.util.StringJoiner;

public class RepositorioArchivo extends RepositorioAsociativo<Equipo, Mantenimiento> {
    private final String nombreArchivo;

    public RepositorioArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // Guarda CSV con todos los campos (como en la foto)
    public void guardarEnArchivo() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (ParAsociado<Equipo, Mantenimiento> par : asociaciones) {
                Equipo e = par.getPrimero();
                Mantenimiento m = par.getSegundo();

                StringJoiner sj = new StringJoiner(",");
                sj.add(String.valueOf(e.getId()))
                  .add(e.getNombre())
                  .add(e.getTipo())
                  .add(String.valueOf(m.getId()))
                  .add(m.getDescripcion())
                  .add(m.getTecnico())
                  .add(m.getFecha().toString())
                  .add(String.valueOf(m.getCosto()));

                bw.write(sj.toString());
                bw.newLine();
            }
        }
    }

    // Carga CSV (misma lógica que viste: parsear y crear objetos)
    public void cargarDesdeArchivo() throws IOException {
        asociaciones.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length < 8) continue;

                // Equipo
                int idEquipo = Integer.parseInt(p[0]);
                String nombre = p[1];
                String tipo = p[2];
                Equipo e = new Equipo(idEquipo, nombre, tipo);

                // Mantenimiento
                int idMant = Integer.parseInt(p[3]);
                String desc = p[4];
                String tecnico = p[5];
                LocalDate fecha = LocalDate.parse(p[6]);
                double costo = Double.parseDouble(p[7]);
                Mantenimiento m = new Mantenimiento(idMant, desc, tecnico, fecha, costo);

                asociaciones.add(new ParAsociado<>(e, m));
            }
        }
    }
}