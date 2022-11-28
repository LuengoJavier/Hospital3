package Hospital;

public class Doctor extends Persona {
	private Especialidad especialidad;

	public Doctor(String nombre, String rut, int edad, Especialidad especialidad) {
		super(nombre, rut, edad);
		this.especialidad = especialidad;
	}
	public String getTipo() {
		return "Doctor";
	}

	@Override
	public String toString() {
		return this.getNombre() + ","+ this.getRut()+","+this.getEdad()+","+ this.especialidad;
	}
}