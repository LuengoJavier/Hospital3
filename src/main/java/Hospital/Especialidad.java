package Hospital;

public enum Especialidad {
	PEDIATRIA("Pediatria"),
	TRAUMATOLOGIA("Traumatologia"),
	OFTALMOLOGIA("Oftalmologia"),
	DERMATOLOGIA("Dermatologia");
	private String especialidad;

	private Especialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	@Override
	public String toString() {
		return "Especialidad= " + especialidad;
	}
}