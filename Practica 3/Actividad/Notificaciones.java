package Actividad;

//===== DIP: Dependencias hacia abstracciones =====
interface CanalNotificacion {
 void enviarNotificacion(String mensaje);
}

class NotificadorCorreo implements CanalNotificacion {
 @Override
 public void enviarNotificacion(String mensaje) {
     System.out.println("Enviando correo: " + mensaje);
 }
}

class NotificadorSMS implements CanalNotificacion {
 @Override
 public void enviarNotificacion(String mensaje) {
     System.out.println("Enviando SMS: " + mensaje);
 }
}

class NotificadorReserva {
 private CanalNotificacion canal;

 public NotificadorReserva(CanalNotificacion canal) {
     this.canal = canal;
 }

 public void notificar(String mensaje) {
     canal.enviarNotificacion(mensaje);
 }
}
