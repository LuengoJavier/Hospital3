package Hospital;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class GestorDatos {
	public static Hospital almacenarDoctores(Hospital hospital) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			archivo = new File ("C:\\Users\\jluen\\IdeaProjects\\Hospital\\src\\main\\java\\Hospital\\doctor.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null ) {
				String[] datos = linea.split(",");
				hospital.contratarDoctor(new Doctor(datos[0], datos[1], Integer.parseInt(datos[2]), Especialidad.valueOf(datos[3])));
			}
		}
		catch(Exception e){
			e.printStackTrace();

		}
		finally{
			try{
				if( null != fr ){
					fr.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}


		}
		return hospital;
	}
	public static Hospital almacenarPacientes(Hospital hospital) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			archivo = new File ("C:\\Users\\jluen\\IdeaProjects\\Hospital\\src\\main\\java\\Hospital\\pacientes.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null ) {
				String[] datos = linea.split(",");
				hospital.agregarPaciente(new Paciente(datos[0], datos[1],Integer.parseInt(datos[2])));
			}


		}
		catch(Exception e){
			e.printStackTrace();

		}finally{
			try{
				if( null != fr ){
					fr.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}


		}
		return hospital;
	}
}