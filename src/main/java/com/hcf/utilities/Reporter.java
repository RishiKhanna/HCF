package com.hcf.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Reporter {
	private static File file = null;
	private final static Logger log = Logg.createLogger();
	private static String datetimeString;

	static {
		datetimeString = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss")
				.format(new Date());
		String fileName = ("report" + "-" + datetimeString + ".html");
		log.info(Utilities.getCurrentThreadId() + "Reporting file name:"
				+ fileName);
		file = new File("./reports/" + fileName);
		FileWriter fstream = null;
		try {
			log.info(Utilities.getCurrentThreadId()
					+ "Generating static part of the customized report");
			file.createNewFile();
			fstream = new FileWriter(file);

			BufferedWriter out = new BufferedWriter(fstream);

			out.write("<html>");
			out.write("<head>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1 align=center>Health Care First</h1>");
			out.write("<br>");

			/**
			 * Creating tables in HTML for Test Status
			 */
			// out.write("<table align=center id=customers border=1 width=100%>");
			out.write("<table cellspacing=0 cellpadding=4 border=2 bordercolor=#224466 width=100%>");
			out.write("<tr>");
			out.write("<th width=15%>Module</th>");
			out.write("<th>Test Case ID</th>");
			out.write("<th>Test Name and Steps</th>");
			out.write("<th>Status</th>");
			out.write("<th>Comments</th>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("</tr>");
			out.flush();
			out.close();
			log.info(Utilities.getCurrentThreadId()
					+ "Generated static part of the report");
		} catch (IOException e) {
			// fstream.close();
		}
	}

	public static void sendStatusToReport(String Module, String TC_ID,
			String TestName, String Status, String Comments) {
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(file, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("<tr>");
			out.write("<td align=\"center\">" + Module + "</b></td>");
			out.write("<td align=\"center\">" + TC_ID + "</b></td>");
			out.write("<td>" + TestName + "</b></td>");
			out.write("<td align=\"center\">" + Status + "</b></td>");
			out.write("<td>" + Comments + "</b></td>");
			out.write("</tr>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// fstream.close();
		}
	}

	public static void sendFinalCountToReport(String total, String pass,
			String fail) {
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(file, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("<table cellspacing=0 cellpadding=4 border=2 bordercolor=#224466 width=25%>");
			out.write("<tr>");
			out.write("<th width=5%>Total</th>");
			out.write("<th width=5%>Pass</th>");
			out.write("<th width=5%>Fail</th>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td align=\"center\">" + total + "</b></td>");
			out.write("<td align=\"center\">" + pass + "</b></td>");
			out.write("<td align=\"center\">" + fail + "</b></td>");
			out.write("</tr>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// fstream.close();
		}
	}
}
