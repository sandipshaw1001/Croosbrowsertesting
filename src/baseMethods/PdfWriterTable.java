package baseMethods;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfWriterTable {
	
	
	public static void writeTable(String Name1, String Name2, String DiffImage,String Pdfname, int Size) throws IOException, DocumentException {
		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "//" + Name1 + ".png"));
		BufferedImage ActualImage = ImageIO.read(new File(System.getProperty("user.dir") + "//" + Name2 + ".png"));
		BufferedImage DifferenceImage = ImageIO.read(new File(System.getProperty("user.dir") + "//" + DiffImage + ".png"));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		boolean foundWriter = ImageIO.write(expectedImage, "png", baos);
		byte[] bytes = baos.toByteArray();
		
		ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		boolean foundWriter2 = ImageIO.write(ActualImage, "png", baos2);
		byte[] bytes2 = baos2.toByteArray();
		
		ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
		boolean foundWriter3 = ImageIO.write(DifferenceImage, "png", baos3);
		byte[] bytes3 = baos3.toByteArray();
		
		Document document = new Document();
		
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\"+Pdfname+".pdf");

		// Instantiate the PDF writer
		PdfWriter writer = PdfWriter.getInstance(document, fos);

		// open the pdf for writing
		writer.open();
		document.open();
		
		
		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
		writer.setPageEvent(event);

		// process content into image
		Image im = Image.getInstance(bytes);
		// set the size of the image
		//im.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/4);
		im.scaleAbsoluteHeight(950);
		
		Image im2 = Image.getInstance(bytes2);
		// set the size of the image
		//im2.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight()/4 );
		im2.scaleAbsoluteHeight(950);
		
		
		Image im3 = Image.getInstance(bytes3);
		// set the size of the image
		im3.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight()/4);
		im3.scaleAbsoluteHeight(950);
		

		PdfPTable resimtable = new PdfPTable(3); // two colmns create tabble
		resimtable.setWidthPercentage(100f);
		// add the captured image to PDF
		/*
		 * document.add(im); document.add(new Paragraph(" "));
		 */
		resimtable.addCell(im);// Table One colmns added first image
		resimtable.addCell(im2);
		resimtable.addCell(im3);
		document.add(resimtable);
		
		
		
	
		

		// close the files and write to local system
		document.close();
		writer.close();

		
	}
	
}
	

 class HeaderFooterPageEvent extends PdfPageEventHelper {

	    public  void onStartPage(PdfWriter writer, Document document) {
	        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Pre Pricing Network"), 30, 800, 0);
	        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("wrwerw"), 550, 800, 0);
	    }

	    public void onEndPage(PdfWriter writer, Document document) {
	        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Pre Pricing Network"), 110, 60, 0);
	        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Url" + document.getPageNumber()), 550, 30, 0);
	    }
	}



