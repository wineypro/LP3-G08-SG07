package Ejercicio_1;

public class Salario extends Empleado{
	public Salario(String nombre, int salario, String departamento) {
		super(nombre, salario, departamento);
	}

	public int PagoMensual(Empleado Emp) {
		return Emp.getSalario() * 31*24;
	};
}
