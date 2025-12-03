package Ejercicio1;

public interface Subject {
    void suscribir(Observer o);
    void desuscribir(Observer o);
    void notificar(Notificacion n);
}
