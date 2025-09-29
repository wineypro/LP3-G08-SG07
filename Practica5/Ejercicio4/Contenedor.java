package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F, S> {
    private List<Par<F, S>> pares;
    
    public Contenedor() {
        this.pares = new ArrayList<>();
    }
    
    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        pares.add(nuevoPar);
    }
    
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < pares.size()) {
            return pares.get(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
    }
    
    public List<Par<F, S>> obtenerTodosLosPares() {
        return new ArrayList<>(pares);
    }
    
    public void mostrarPares() {
        if (pares.isEmpty()) {
            System.out.println("El contenedor está vacío.");
            return;
        }
        
        System.out.println("Pares en el contenedor:");
        for (int i = 0; i < pares.size(); i++) {
            System.out.println("[" + i + "] " + pares.get(i));
        }
    }
    
    public int cantidadPares() {
        return pares.size();
    }
}