
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException { //taking it to git
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\RushaliSeth\\Downloads\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // row is collection of cells
				int k = 0;
				int coloumn = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						coloumn = k;

					}
					k++;
				}
				System.out.println(coloumn);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cc = r.cellIterator();
						while (cc.hasNext()) {
							Cell c = cc.next();
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} 
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}

					}
				}

			}

		}
		return a;
	}

	public static void main(String[] args) throws IOException {

	}

}
