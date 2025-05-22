package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    public static Object[][] getTestData(String excelPath, String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows - 1][cols]; // Skip header

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString();
                }
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
