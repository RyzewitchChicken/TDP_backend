package pe.upc.onticket.Service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletResponse;


import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import pe.upc.onticket.entity.Cargo;
import pe.upc.onticket.entity.User;



public class CargoPDFExporter {
	private Cargo cargo;
	
	
	

	public CargoPDFExporter(Cargo cargo) {
		this.cargo = cargo;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(4);
		Font font= FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		cell.setPhrase(new Phrase("Cargo Id"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Driver Name"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Driver Last Name"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Client Name"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Client Last Name"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Duration"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Status"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Comentary"));
		table.addCell(cell);
	
	}
	
	private void writeTableData(PdfPTable table) {
			table.addCell(String.valueOf(cargo.getCodigo()));
			table.addCell(String.valueOf(cargo.getPersonDriverId().getPersonName()));
			table.addCell(String.valueOf(cargo.getPersonDriverId().getPersonLastName()));
			table.addCell(String.valueOf(cargo.getPersonClientId().getPersonName()));
			table.addCell(String.valueOf(cargo.getPersonClientId().getPersonLastName()));
			table.addCell(String.valueOf(cargo.getCargoRouteDuration()));
			table.addCell(String.valueOf(cargo.getCargoStatus()));
			table.addCell(String.valueOf(cargo.getCargoRouteStatus()));

	}
	
	private static final String BUCKET= "logiappbucket";
	
	public void export(HttpServletResponse response, String filename) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document,response.getOutputStream());
		System.out.println(response.getOutputStream());
		document.open();
		document.add(new Paragraph("List of Cargo"));
		
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(9);
		writeTableHeader(table);
		writeTableData(table);
		document.add(table);
		document.close();


	     
	     
	}
	


}
