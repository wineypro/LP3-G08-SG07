package Ejercicio1;

import java.io.*;

class LeerEntrada {
 private Reader stream;

 public LeerEntrada(InputStream fuente) {
     stream = new InputStreamReader(fuente);
 }

 public char getChar() throws IOException {
     return (char) this.stream.read();
 }
}

class ExcepcionVocal extends Exception {
 public ExcepcionVocal(char c) {
     super("Se ingresó una vocal: " + c);
 }
}

class ExcepcionNumero extends Exception {
 public ExcepcionNumero(char c) {
     super("Se ingresó un número: " + c);
 }
}

class ExcepcionBlanco extends Exception {
 public ExcepcionBlanco() {
     super("Se ingresó un espacio en blanco");
 }
}

class ExcepcionSalida extends Exception {
 public ExcepcionSalida() {
     super("Se ingresó el carácter de salida. Programa terminado.");
 }
}

public class ProcesarEntrada {
 private LeerEntrada entrada;
 private char ultimoCaracter;

 public ProcesarEntrada() {
     entrada = new LeerEntrada(System.in);
 }

 public void procesar() throws Exception {
     ultimoCaracter = entrada.getChar();

     if (esVocal(ultimoCaracter)) {
         throw new ExcepcionVocal(ultimoCaracter);
     } else if (Character.isDigit(ultimoCaracter)) {
         throw new ExcepcionNumero(ultimoCaracter);
     } else if (ultimoCaracter == ' ') {
         throw new ExcepcionBlanco();
     } else if (ultimoCaracter == 'x' || ultimoCaracter == 'X') {
         throw new ExcepcionSalida();
     }
 }

 private boolean esVocal(char c) {
     c = Character.toLowerCase(c);
     return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
 }

 public static void main(String[] args) throws IOException {
	    ProcesarEntrada procesador = new ProcesarEntrada();
	    boolean continuar = true;

	    System.out.println("Ingrese caracteres (use 'x' para salir):");

	    while (continuar) {
	        try {
	            procesador.procesar();
	        } catch (ExcepcionVocal e) {
	            System.out.println(e.getMessage());
	        } catch (ExcepcionNumero e) {
	            System.out.println(e.getMessage());
	        } catch (ExcepcionBlanco e) {
	            System.out.println(e.getMessage());
	        } catch (ExcepcionSalida e) {
	            System.out.println(e.getMessage());
	            continuar = false;
	        } catch (Exception e) {
	            System.out.println("Error inesperado: " + e.getMessage());
	        }
	    }
	}
}
