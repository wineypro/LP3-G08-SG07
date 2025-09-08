package Actividad;

//===== OCP: Políticas de cancelación =====
interface PoliticaCancelacion {
 boolean puedeCancelar();
}

class PoliticaFlexible implements PoliticaCancelacion {
 @Override
 public boolean puedeCancelar() { return true; }
}

class PoliticaEstricta implements PoliticaCancelacion {
 @Override
 public boolean puedeCancelar() { return false; }
}

public class Reserva {
 private Habitacion habitacion;
 private PoliticaCancelacion politica;

 public Reserva(Habitacion habitacion, PoliticaCancelacion politica) {
     this.habitacion = habitacion;
     this.politica = politica;
 }

 public boolean cancelar() {
     return politica.puedeCancelar();
 }
}