package com.avengers.bus.services.implementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.avengers.bus.models.entityModels.User;
import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class TicketMail {

	private static final Logger logger = LoggerFactory.getLogger(TicketMail.class);

	public static void sendEmail(HttpServletRequest request, HttpServletResponse response,
			com.avengers.bus.models.dtoModels.Ticket ticket, User user) throws Exception {
		logger.info("Sending ticket confirmation email to user: {}", user.getEmail());

		// Set up model attributes with the variables for JSP replacements

		// Resolve JSP view
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		String viewName = "ticketMail";
		request.setAttribute("Ticket", ticket);

		// Render JSP
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/" + viewName + ".jsp");
		StringWriter stringWriter = new StringWriter();
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
			@Override
			public PrintWriter getWriter() throws IOException {
				return new PrintWriter(stringWriter);
			}
		};
		requestDispatcher.include(request, responseWrapper);
		String renderedHtml = stringWriter.toString();

		String filename = ticket.getTicketNo() + ".pdf";
		OutputStream file = new FileOutputStream(new File(filename));
		Document document = new Document();
		PdfWriter.getInstance(document, file);
		document.open();
		HTMLWorker htmlWorker = new HTMLWorker(document);
		htmlWorker.parse(new StringReader(renderedHtml));
		document.close();
		file.close();

		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", true);
		p.put("mail.smtp.starttls.enable", true);
		p.put("mail.smtp.port", "587");
		Session s = Session.getInstance(p, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("avengersbtrs@gmail.com", "urpr twig ffeb uqlx");
			}
		});
		try {
			MimeMessage mm = new MimeMessage(s);
			mm.setFrom(new InternetAddress("avengersbtrs@gmail.com"));
			mm.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			mm.setSubject("BTRS Ticket Confirmation Details " + ticket.getTicketNo());
			mm.setContent(renderedHtml, "text/html");

			Multipart multipart = new MimeMultipart();

			DataSource source = new FileDataSource(filename);
			mm.setDataHandler(new DataHandler(source));
			mm.setFileName(filename);

			Transport.send(mm);

		} catch (Exception e) {
			logger.error("Failed to send ticket confirmation email: {}", e.getMessage());
			e.printStackTrace();
		}

		// Send the email with the rendered HTML
		logger.info("Ticket confirmation email sent successfully to user: {}", user.getEmail());
	}

}
