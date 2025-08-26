package practica_2;

public class Actividad1 {
	public static class Coche {
		private String marca;
		private String modelo;
		private int anioFabricacion;
		private double precio;
		
		public Coche(){
			marca= "default";
			modelo = "default";
			anioFabricacion = 2025;
			precio = 0;
		}
		public Coche(String marca, String modelo, int anioFabricacion, double precio){
			this.marca = marca;
			this.modelo = modelo;
			this.anioFabricacion = anioFabricacion;
			this.precio = precio;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			 this.marca = marca;
		}

		public String getModelo() {
			 return modelo;
		}

		public void setModelo(String modelo) {
			 this.modelo = modelo;
		}

		public int getAnioFabricacion() {
			 return anioFabricacion;
		}

		public void setAnioFabricacion(int anioFabricacion) {
			 this.anioFabricacion = anioFabricacion;
		}

		public double getPrecio() {
			 return precio;
		}

		public void setPrecio(double precio) {
			 this.precio = precio;
		}

		public void aplicarDescuento(double descuento){
			if(anioFabricacion<2010) {
				setPrecio(precio*=descuento);
			}

		}

		public static void main(String[] args) {
			Coche coche1 = new Coche();
            System.out.println("Coche 1 - Marca: " + coche1.getMarca() + 
                             ", Modelo: " + coche1.getModelo() +
                             ", Año: " + coche1.getAnioFabricacion() +
                             ", Precio: " + coche1.getPrecio());
            
            Coche coche2 = new Coche("Toyota", "Corolla", 2008, 15000);
            System.out.println("Coche 2 - Marca: " + coche2.getMarca() + 
                             ", Modelo: " + coche2.getModelo() +
                             ", Año: " + coche2.getAnioFabricacion() +
                             ", Precio: " + coche2.getPrecio());
            
            coche2.aplicarDescuento(0.8);
            System.out.println("Precio con descuento: " + coche2.getPrecio());
            
            Coche coche3 = new Coche("Honda", "Civic", 2015, 20000);
            System.out.println("Coche 3 - Marca: " + coche3.getMarca() + 
                             ", Modelo: " + coche3.getModelo() +
                             ", Año: " + coche3.getAnioFabricacion() +
                             ", Precio: " + coche3.getPrecio());
            
            coche3.aplicarDescuento(0.8);
            System.out.println("Precio (sin cambios): " + coche3.getPrecio());
            
            coche1.setMarca("Ford");
            coche1.setModelo("Focus");
            coche1.setAnioFabricacion(2005);
            coche1.setPrecio(12000);
            
            System.out.println("Coche 1 actualizado - Marca: " + coche1.getMarca() + 
                             ", Modelo: " + coche1.getModelo() +
                             ", Año: " + coche1.getAnioFabricacion() +
                             ", Precio: " + coche1.getPrecio());
            }
	}
}
