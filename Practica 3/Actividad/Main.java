package Actividad;

public class Main {
    public static void main(String[] args) {
        // SRP
        Habitacion hab1 = new Habitacion(101, 150.0);
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion();
        gestor.reservar(hab1);
        System.out.println("Habitación disponible: " + gestor.verificarDisponibilidad(hab1));

        // OCP
        Reserva reserva1 = new Reserva(hab1, new PoliticaFlexible());
        System.out.println("Cancelación flexible: " + reserva1.cancelar());

        Reserva reserva2 = new Reserva(hab1, new PoliticaEstricta());
        System.out.println("Cancelación estricta: " + reserva2.cancelar());

        // LSP
        TipoHabitacion suite = new Suite(201, 300.0);
        TipoHabitacion simple = new HabitacionSimple(202, 100.0);
        System.out.println(suite.descripcion());
        System.out.println(simple.descripcion());

        // ISP
        ServicioLimpieza habLimpieza = new HabitacionConLimpieza();
        habLimpieza.solicitarLimpieza();

        HabitacionConTodo habCompleta = new HabitacionConTodo();
        habCompleta.solicitarLimpieza();
        habCompleta.solicitarComida();

        // DIP
        NotificadorReserva notificadorCorreo = new NotificadorReserva(new NotificadorCorreo());
        notificadorCorreo.notificar("Su reserva fue confirmada.");

        NotificadorReserva notificadorSMS = new NotificadorReserva(new NotificadorSMS());
        notificadorSMS.notificar("Su reserva fue cancelada.");
    }
}