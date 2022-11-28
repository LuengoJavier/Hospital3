package Hospital;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;


public class GenerarPDF {

	public void generadorPDF(Doctor doctor) throws IOException {
		//Se crea un nuevo documento
		PDDocument documento = new PDDocument();
//Al documento se le crea y agrega una nueva página, en este caso en formato A6
		PDPage pagina = new PDPage(PDRectangle.A6);
		documento.addPage(pagina);
//Se genera un arreglo de líneas que va a tener el archivo PDF
		String[] lineasPdf= this.obtenerLineasPdf(doctor);
		this.rellenarPDF(documento,pagina,lineasPdf);
//Se guarda el documento en la ubicación descrita
		documento.save(this.generarNombrePdf(doctor));
		documento.close();
	}
	public void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasDoctores){
//Por cada linea del arreglo, se irá agregando texto
		try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
			for(int linea=0; linea<lineasDoctores.length; linea++) {
				contenidoPagina.beginText();
//Se define en que posición del documento estará el texto
				contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight()-(10*linea));
				contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
//Agrega el texto al documento
				contenidoPagina.showText(lineasDoctores[linea]);
				contenidoPagina.endText();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String[] obtenerLineasPdf(Doctor doctor){
		String[] lineasPdf= new String[6];
		lineasPdf[0]= "________________________________________________";
		lineasPdf[1]= "Clínica Alemana";
		lineasPdf[2]= "-------------------------------------------------";
		lineasPdf[3]= "Nombre: " + doctor.getNombre();
		lineasPdf[4]= "Edad: " + doctor.getEdad();
		lineasPdf[5]= "Rut:" + doctor.getRut();
		return lineasPdf;
	}
	private String generarNombrePdf(Doctor doctor){
		String archivo = doctor.getNombre();
		archivo = archivo.replace(" ","").replace(":","");
		String nombreArchivo="target/"+"Doctor"+ archivo+".pdf";
		return nombreArchivo;
	}
}