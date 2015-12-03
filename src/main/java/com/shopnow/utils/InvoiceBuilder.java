package com.shopnow.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.shopnow.dto.InvoiceDetails;
import com.shopnow.dto.ProductDetails;

public class InvoiceBuilder extends AbstractITextPdfView {

	String paragraph1Matter1 = "Phrase objects knows how to add line spacing if the added phrase exceeds the right edge of the document. It does not, however, add extra space between paragraphs. For this, you need to use a Paragraph object.";

	String invoiceHeading  = "INVOICE";
	String shippingInfo  = "[COMPANY NAME]";
	
	Font tableHeaders = new Font(FontFamily.TIMES_ROMAN,10);
	Font tabledata = new Font(FontFamily.TIMES_ROMAN,10);
	
	Font paragraphFonts = new Font(FontFamily.TIMES_ROMAN,10);
	
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		InvoiceDetails invoiceDetails = (InvoiceDetails) model.get("invoiceDetails");
		document.open();
		document.setPageCount(1);

		// Adding heading of document 
		
		Paragraph paraHeading = new Paragraph();
		paraHeading.add("[Title of the Document]");
		paraHeading.setAlignment(Paragraph.ALIGN_CENTER);
		paraHeading.setFont(new Font(FontFamily.TIMES_ROMAN,18));
		
		document.add(paraHeading);
		
		// Adding paragraph
		Paragraph paragraph1 = new Paragraph();
		//paragraph1.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph1.add(invoiceHeading);
		paragraph1.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph1);
		
		// added Shipping info 
		Paragraph paragraph2 = new Paragraph();
		//paragraph1.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph2.add(shippingInfo);
		paragraph2.setFont(new Font(Font.FontFamily.TIMES_ROMAN,18));
		paragraph2.setAlignment(Element.ALIGN_LEFT);
		//paragraph2.setSpacingAfter(10);
		document.add(paragraph2);

		Paragraph paragraph3 = new Paragraph();
		//paragraph1.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph3.add("[Address of the company ]");
		paragraph3.setFont(new Font(Font.FontFamily.TIMES_ROMAN,10));
		paragraph3.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph3);
		
		Paragraph paragraph4 = new Paragraph();
		//paragraph1.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph4.add("Hyderabad Andhra Pradesh Pin  500081");
		paragraph4.setFont(new Font(Font.FontFamily.TIMES_ROMAN,10));
		paragraph4.setAlignment(Element.ALIGN_LEFT);
		paragraph4.setSpacingAfter(10);
		document.add(paragraph4);
		
		// Short details table at right side
		
		PdfPTable tableRight = new PdfPTable(2);
		// Setting table to the right aligned 
		tableRight.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);
		
		// Setting width of table columns 
		tableRight.setWidthPercentage(30);
		float [] colomnsWidths = {30f,30f};
		tableRight.setWidths(colomnsWidths);
	
		PdfPCell cellInvoice = new PdfPCell();
		cellInvoice.setBackgroundColor(BaseColor.GRAY);
		cellInvoice.setPhrase(new Phrase("INVOICE #",tableHeaders));
		
		PdfPCell cellDate = new PdfPCell();
		cellDate.setBackgroundColor(BaseColor.GRAY);
		cellDate.setPhrase(new Phrase("DATE #",tableHeaders));
		
		tableRight.addCell(cellInvoice);
		tableRight.addCell(cellDate);
		
		PdfPCell cellInvoiceValue = new PdfPCell();
		cellInvoiceValue.setPhrase(new Phrase("5482",tableHeaders));
		
		PdfPCell cellDateValue = new PdfPCell();
		cellDateValue.setPhrase(new Phrase("2015-11-25",tableHeaders));

		tableRight.addCell(cellInvoiceValue);
		tableRight.addCell(cellDateValue);
		
		
		PdfPCell cellCustomerId = new PdfPCell();
		cellCustomerId.setBackgroundColor(BaseColor.GRAY);
		cellCustomerId.setPhrase(new Phrase("CUSTOMER ID",tableHeaders));
		
		PdfPCell cellTerms = new PdfPCell();
		cellTerms.setBackgroundColor(BaseColor.GRAY);
		cellTerms.setPhrase(new Phrase("TERMS",tableHeaders));
		
		

		tableRight.addCell(cellCustomerId);
		tableRight.addCell(cellTerms);
		
		
		PdfPCell cellCustomerIdValue = new PdfPCell();
		cellCustomerIdValue.setPhrase(new Phrase("98745",tableHeaders));
		
		PdfPCell cellTermsValue = new PdfPCell();
		cellTermsValue.setPhrase(new Phrase("Net 30 Days",tableHeaders));

		tableRight.addCell(cellCustomerIdValue);
		tableRight.addCell(cellTermsValue);
		
		document.add(tableRight);
		
		// Billing and Shiping Address Area 
		
		PdfPTable tableBillAndShip= new PdfPTable(2);
		tableBillAndShip.setWidthPercentage(100);
		tableBillAndShip.setSpacingBefore(10);
		
		PdfPCell cellBS1 = new PdfPCell();
		cellBS1.setBackgroundColor(BaseColor.GRAY);
		cellBS1.setPhrase(new Phrase("BILL TO",tableHeaders));

		PdfPCell cellBS2 = new PdfPCell();
		cellBS2.setBackgroundColor(BaseColor.GRAY);
		cellBS2.setPhrase(new Phrase("SHIP TO",tableHeaders));
		
		tableBillAndShip.addCell(cellBS1);
		tableBillAndShip.addCell(cellBS2);
		
		
		PdfPCell cellBS11 = new PdfPCell();
		cellBS11.setPhrase(new Phrase("Vishnu Awasthu",tabledata));
		cellBS11.setBorder(Rectangle.NO_BORDER);
	
		
		PdfPCell cellBS12 = new PdfPCell();
		cellBS12.setPhrase(new Phrase("HNo. RB -II 157-B West Railway colony",tabledata));
		cellBS12.setBorder(Rectangle.NO_BORDER);
		
		PdfPCell cellBS13 = new PdfPCell();
		cellBS13.setPhrase(new Phrase("Bhopal",tabledata));
		cellBS13.setBorder(Rectangle.NO_BORDER);
		
		PdfPCell cellBS14 = new PdfPCell();
		cellBS14.setPhrase(new Phrase("Bhopal",tabledata));
		cellBS14.setBorder(Rectangle.NO_BORDER);



		PdfPCell cellBS21 = new PdfPCell();
		cellBS21.setPhrase(new Phrase("Micle",tabledata));
		cellBS21.setBorder(Rectangle.NO_BORDER);
		
		PdfPCell cellBS22 = new PdfPCell();
		cellBS22.setPhrase(new Phrase("RB -II 765",tabledata));
		cellBS22.setBorder(Rectangle.NO_BORDER);
		
		
		PdfPCell cellBS23 = new PdfPCell();
		cellBS23.setPhrase(new Phrase("New York City, Pin 987655",tabledata));
		cellBS23.setBorder(Rectangle.NO_BORDER);
		
		
		PdfPCell cellBS24 = new PdfPCell();
		cellBS24.setPhrase(new Phrase("United State America",tabledata));
		cellBS24.setBorder(Rectangle.NO_BORDER);
	
		tableBillAndShip.addCell(cellBS11);
		tableBillAndShip.addCell(cellBS21);

		
		tableBillAndShip.addCell(cellBS12);
		tableBillAndShip.addCell(cellBS22);
		
		
		
		tableBillAndShip.addCell(cellBS13);
		tableBillAndShip.addCell(cellBS23);
		
		
		tableBillAndShip.addCell(cellBS14);
		tableBillAndShip.addCell(cellBS24);
		
		
		document.add(tableBillAndShip);
		
		// Table to handle the particular 
		PdfPTable table = new PdfPTable(5);
		table.setSpacingBefore(20);
		table.setWidthPercentage(100);
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setBackgroundColor(BaseColor.GRAY);
		cell1.setPhrase(new Phrase("Serial Numer",tableHeaders));
		
		PdfPCell cell2 = new PdfPCell();
		cell2.setBackgroundColor(BaseColor.GRAY);
		cell2.setPhrase(new Phrase("Particular",tableHeaders));
		
		PdfPCell cell3 = new PdfPCell();
		cell3.setBackgroundColor(BaseColor.GRAY);
		cell3.setPhrase(new Phrase("Quantity",tableHeaders));
		
		PdfPCell cell4 = new PdfPCell();
		cell4.setBackgroundColor(BaseColor.GRAY);
		cell4.setPhrase(new Phrase("Price",tableHeaders));
		
		PdfPCell cell5 = new PdfPCell();
		cell5.setBackgroundColor(BaseColor.GRAY);
		cell5.setPhrase(new Phrase("Total",tableHeaders));
		
		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		int counter = 0;
		for(ProductDetails productDetails : invoiceDetails.getProductDetailsList()) {
			
			PdfPCell cell11 = new PdfPCell();
			cell11.setPhrase(new Phrase(productDetails.getId().toString(),tabledata));

			PdfPCell cell21 = new PdfPCell();
			cell21.setPhrase(new Phrase(productDetails.getProductName(),tabledata));
			
			PdfPCell cell31 = new PdfPCell();
			cell31.setPhrase(new Phrase(productDetails.getQuantity(),tabledata));
			
			PdfPCell cell41 = new PdfPCell();
			cell41.setPhrase(new Phrase(productDetails.getPrice(),tabledata));
			
			PdfPCell cell51 = new PdfPCell();
			cell51.setPhrase(new Phrase(productDetails.getPrice(),tabledata));
			
			table.addCell(cell11);
			table.addCell(cell21);
			table.addCell(cell31);
			table.addCell(cell41);
			table.addCell(cell51);
			counter++;
			
		}
/*
		if(counter<10) {
			for(int i=counter ; i<10;  i++ ) {
				
				PdfPCell celltemp1 = new PdfPCell();
				celltemp1.setPhrase(new Phrase("",tabledata));
				
				PdfPCell celltemp2 = new PdfPCell();
				celltemp1.setPhrase(new Phrase("",tabledata));
				
				PdfPCell celltemp3 = new PdfPCell();
				celltemp1.setPhrase(new Phrase("",tabledata));
				
				PdfPCell celltemp4 = new PdfPCell();
				celltemp1.setPhrase(new Phrase("",tabledata));
				
				celltemp1.setPhrase(new Phrase("",tabledata));
				PdfPCell celltemp5 = new PdfPCell();
				
				
				table.addCell(celltemp1);
				table.addCell(celltemp2);
				table.addCell(celltemp3);
				table.addCell(celltemp4);
				table.addCell(celltemp5);
				
			}
		}*/
		
		PdfPCell cellEnd1 = new PdfPCell();
		cellEnd1.setColspan(3);
		cellEnd1.setPhrase(new Phrase("Thanks you for purchasing the items!",tabledata));
		
		PdfPCell cellEnd2 = new PdfPCell();
		cellEnd2.setPhrase(new Phrase("Total : ",tabledata));
		cellEnd2.setBorderColorRight(BaseColor.WHITE);
		
		
		PdfPCell cellEnd3 = new PdfPCell();
		cellEnd3.setBorderColorLeft(BaseColor.WHITE);
		cellEnd3.setPhrase(new Phrase("300000  ",tabledata));
		
		table.addCell(cellEnd1);
		table.addCell(cellEnd2);
		table.addCell(cellEnd3);
		document.add(table);
		
		document.bottom();
		
		
		// Adding footer
		
		Paragraph paraFooter = new Paragraph();
		paraFooter.setSpacingBefore(10);
		paraFooter.setAlignment(Element.ALIGN_BOTTOM);
		paraFooter.add("Note : This is an compter generated document, No need of signature.");
		document.add(paraFooter);
		document.close();

	}

}
