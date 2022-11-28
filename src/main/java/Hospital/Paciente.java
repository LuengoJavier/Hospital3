package Hospital;

public class Paciente extends Persona{

	public Paciente(String nombre, String rut, int edad) {
		super(nombre, rut, edad);
	}

	public String getTipo() {
		return "Paciente";
	}
}