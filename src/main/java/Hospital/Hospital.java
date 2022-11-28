package Hospital;
import java.util.ArrayList;

public class Hospital {
	private final ArrayList<Persona> personas = new ArrayList<>();

	public Paciente agregarPaciente(Paciente paciente) {
		if(buscarPaciente(paciente.getRut()) == null) {
			this.personas.add(paciente);
		}
		return paciente;
	}

	public boolean eliminarPaciente(String nombre, int edad, String rut) {
		for(Persona persona : this.personas) {
			if (persona.getNombre().equals(nombre) && persona.getEdad() == edad && persona.getRut().equals(rut) && persona.getTipo().equals("Paciente")){
				this.personas.remove(persona);
				return true;
			}
		}
		return false;
	}

	public Doctor contratarDoctor(Doctor doctor) {
		if(buscarDoctor(doctor.getRut()) == null) {
			this.personas.add(doctor);
		}
		return doctor;
	}

	public boolean despedirDoctor(String nombre, String rut, int edad) {
		for(Persona persona : this.personas) {
			if (persona.getNombre().equals(nombre) && persona.getEdad() == edad && persona.getRut().equals(rut) && persona.getTipo().equals("Doctor")){
				this.personas.remove(persona);
				return true;
			}
		}
		return false;
	}
	public Persona buscarPaciente(String rut){
		for(Persona persona : this.personas){
			if(persona.getTipo().equals("Paciente") && persona.getRut().equals(rut)){
				return persona;
			}
		}
		return null;
	}
	public Persona buscarDoctor(String rut){
		for(Persona persona : this.personas){
			if(persona.getTipo().equals("Doctor") && persona.getRut().equals(rut)){
				return persona;
			}
		}
		return null;
	}
	public void mostrarPacientes(){
		for(Persona persona : personas ){
			if(persona.getTipo().equals("Paciente")){
				System.out.println(persona);
			}
		}
	}
	public void mostrarDoctores(){
		for(Persona persona : personas){
			if (persona.getTipo().equals("Doctor")){
				System.out.println(persona);
			}
		}
	}
}