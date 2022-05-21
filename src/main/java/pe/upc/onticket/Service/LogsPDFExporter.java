package pe.upc.onticket.Service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import pe.upc.onticket.entity.Logs;



public class LogsPDFExporter {
	
	
	private List<Logs> logs;
	

	public LogsPDFExporter(List<Logs> logs) {
		this.logs = logs;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5);
		Font font= FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.RED);
		cell.setPhrase(new Phrase("Log Id"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Date"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Hour"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Ubication"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Temperature"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Humidity"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Velocity"));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Alert"));
		table.addCell(cell);
	
	}
	
	private void writeTableData(PdfPTable table) {
		
		
		for (Logs log:logs) {
			if(log.isLogCargoAlertType() == 0){
				table.addCell(String.valueOf(log.getCodigo()));
				table.addCell(String.valueOf(log.getLogCargoDate()));
				table.addCell(String.valueOf(log.getLogCargoHour()));
				table.addCell(String.valueOf(log.getLogCargoUbication()));
				table.addCell(String.valueOf(log.getLogCargoTemperature()));
				table.addCell(String.valueOf(log.getLogCargoHumidity()));
				table.addCell(String.valueOf(log.getLogCargoVelocity()));
				table.addCell(String.valueOf(log.isLogCargoAlertType()));
				System.out.println(String.valueOf(log.isLogCargoAlertType()));
				}
			
			}
	}
	private void writeTableData2(PdfPTable table) {
		
		
		for (Logs log:logs) {
			if(log.isLogCargoAlertType() == 1){
				table.addCell(String.valueOf(log.getCodigo()));
				table.addCell(String.valueOf(log.getLogCargoDate()));
				table.addCell(String.valueOf(log.getLogCargoHour()));
				table.addCell(String.valueOf(log.getLogCargoUbication()));
				table.addCell(String.valueOf(log.getLogCargoTemperature()));
				table.addCell(String.valueOf(log.getLogCargoHumidity()));
				table.addCell(String.valueOf(log.getLogCargoVelocity()));
					
				table.addCell(String.valueOf(log.isLogCargoAlertType()));
				System.out.println(String.valueOf(log.isLogCargoAlertType()));
				}
			
			}
	}
	
	
	public void export(HttpServletResponse response, String filename) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document,response.getOutputStream());
		System.out.println(response.getOutputStream());
		document.open();
		document.add(new Paragraph("Alerts"));
		
		PdfPTable table = new PdfPTable(8);
		PdfPTable table2 = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10);
		table2.setWidthPercentage(100);
		table2.setSpacingBefore(10);
		writeTableHeader(table);
		writeTableData(table);
		writeTableHeader(table2);
		writeTableData2(table2);
		document.add(table);
		document.add(table2);
		document.close();


	     
	     
	}

}
