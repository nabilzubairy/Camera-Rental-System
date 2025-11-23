package com.zubairy.crs.utility;

import java.io.ByteArrayOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDate;

public class PdfGenerator {

    public static byte[] generateInvoice(String userName, double totalAmount, LocalDate fromDate, LocalDate toDate) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

        document.add(new Paragraph("Camera Rental Invoice", titleFont));
        document.add(new Paragraph("--------------------------------------------------------"));
        document.add(new Paragraph("Customer: " + userName, normalFont));
        document.add(new Paragraph("Booking From: " + fromDate, normalFont));
        document.add(new Paragraph("Booking To: " + toDate, normalFont));
        document.add(new Paragraph("Total Amount: ₹" + totalAmount, normalFont));

        document.add(new Paragraph("\nThank you for booking with Camera Rental System!", normalFont));

        document.close();
        return out.toByteArray();
    }
}

