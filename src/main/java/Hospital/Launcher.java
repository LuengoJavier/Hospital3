package Hospital;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args){
		Launcher launcher= new Launcher();
		launcher.inicializar();
	}
	public void inicializar(){
		Hospital hospital = new Hospital();
		hospital= GestorDatos.almacenarDoctores(hospital);
		hospital.mostrarDoctores();
		hospital= GestorDatos.almacenarPacientes(hospital);
		hospital.mostrarPacientes();

		Doctor doctor = new Doctor("Juan","13.452.245-9",48, Especialidad.valueOf("TRAUMATOLOGIA"));
		GenerarPDF generarPDF = new GenerarPDF();
		try{
			generarPDF.generadorPDF(doctor);
		}catch (IOException e){
			throw new RuntimeException(e);
		}
	}
}