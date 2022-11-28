package Hospital;

public abstract class Persona {
	private String nombre;
	private final String rut;
	private int edad;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Persona(String nombre, String rut, int edad) {
		this.nombre = nombre;
		this.rut = rut;
		this.edad = edad;
	}
	@Override
	public String toString(){
		return this.nombre+","+this.rut+","+this.edad;
	}
	public abstract String getTipo();
}