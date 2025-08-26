package practica_2;

public class Actividad_2 {
    
    static class Contador {
        static int accumulator = 0;
        final static int VALOR_INICIAL = 10;
        static int nContadores = 0;        // j.1: Número de contadores creados
        static int ultimoContador = 0;     // j.2: Valor inicial del último contador
        private int valor;

        public static int accumulator() {
            return accumulator;
        }

        public static int getNContadores() {
            return nContadores;
        }

        public static int getUltimoContador() {
            return ultimoContador;
        }

        public Contador(int valor) {
            this.valor = valor;
            accumulator += valor;
            nContadores++;                 // Incrementar contador de instancias
            ultimoContador = valor;        // Guardar valor del último contador
        }

        public Contador() {
            this(Contador.VALOR_INICIAL);
        }

        public void inc() {
            valor++;
            accumulator++;
        }

        public int getValor() {
            return this.valor;
        }
    }

    // j.3: Clase ContadorTest modificada
    public static void main(String[] args) {
        System.out.println("=== INICIO DEL PROGRAMA ===");
        System.out.println("Contadores creados: " + Contador.getNContadores());
        System.out.println("Último contador: " + Contador.getUltimoContador());
        System.out.println("Acumulador: " + Contador.accumulator());
        
        // Crear contadores
        Contador c1 = new Contador(3);
        System.out.println("\nDespués de crear c1(3):");
        System.out.println("Contadores: " + Contador.getNContadores() + 
                          " | Último: " + Contador.getUltimoContador() + 
                          " | Acumulador: " + Contador.accumulator());
        
        Contador c2 = new Contador();
        System.out.println("Después de crear c2():");
        System.out.println("Contadores: " + Contador.getNContadores() + 
                          " | Último: " + Contador.getUltimoContador() + 
                          " | Acumulador: " + Contador.accumulator());
        
        Contador c3 = new Contador(7);
        System.out.println("Después de crear c3(7):");
        System.out.println("Contadores: " + Contador.getNContadores() + 
                          " | Último: " + Contador.getUltimoContador() + 
                          " | Acumulador: " + Contador.accumulator());
        
        // Operaciones con los contadores
        c1.inc();
        c2.inc();
        c3.inc();
        
        System.out.println("\nDespués de incrementar:");
        System.out.println("c1: " + c1.getValor() + " | c2: " + c2.getValor() + " | c3: " + c3.getValor());
        System.out.println("Acumulador final: " + Contador.accumulator());
        
        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Total de contadores creados: " + Contador.getNContadores());
        System.out.println("Valor del último contador creado: " + Contador.getUltimoContador());
        System.out.println("VALOR_INICIAL: " + Contador.VALOR_INICIAL);
    }
}