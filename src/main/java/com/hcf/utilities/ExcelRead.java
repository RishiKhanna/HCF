package com.hcf.utilities;

import java.io.File;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.hcf.propertymgr.PropertyManager;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelRead {

	private final static Properties excelRelativePath = PropertyManager
			.loadApplicationPropertyFile("application.properties");
	private final static Logger log = Logg.createLogger();
	private static String[][] storage;

	public static String[][] readTestData(String sheetName) {

		try {
			File excelFile = new File(
					excelRelativePath.getProperty("excelPath"));
			Workbook workbook = Workbook.getWorkbook(excelFile);
			Sheet sheet = workbook.getSheet(sheetName);
			int col = sheet.getColumns();
			int row = sheet.getRows();

			storage = new String[row][col];
			log.info(Utilities.getCurrentThreadId()
					+ "Displaying values from the excel");
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					// getCell(int column, int row)
					// Returns the cell specified at this row and at this
					// column.
					storage[i][j] = sheet.getCell(j, i).getContents();
					log.info("		" + "[" + i + "]row [" + j + "]column value = "
							+ storage[i][j]);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return storage;
	}
}