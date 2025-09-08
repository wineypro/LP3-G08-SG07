package Ejercicio_1;

public class Empleado {
	private String nombre;
	private int salario;
	private String departamento;
	
	

	public Empleado(String nombre, int salario, String departamento) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	

	public static void main(String[] args) {
		Salario emp1 = new Salario("nombre",100,"departamento");
		System.out.println(emp1.PagoMensual(emp1));
		
	}

}

