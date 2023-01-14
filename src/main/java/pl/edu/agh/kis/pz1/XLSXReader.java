package pl.edu.agh.kis.pz1;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class XLSXReader {

    public static ArrayList<Faktura> readFromXLSX(String fileName) throws IOException {
        ArrayList<Faktura> faktury = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try (InputStream in = new FileInputStream(fileName)) {
            Workbook workbook = WorkbookFactory.create(in);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                faktury.add(new Faktura(sheet.getRow(i).getCell(0).getStringCellValue(),
                        sheet.getRow(i).getCell(1).getStringCellValue(),
                        sheet.getRow(i).getCell(2).getStringCellValue(),
                        formatter.format(sheet.getRow(i).getCell(3).getDateCellValue()),
                        formatter.format(sheet.getRow(i).getCell(4).getDateCellValue()),
                        sheet.getRow(i).getCell(5).getStringCellValue(),
                        sheet.getRow(i).getCell(6).getStringCellValue(),
                        sheet.getRow(i).getCell(7).getNumericCellValue() + "",
                        sheet.getRow(i).getCell(8).getNumericCellValue() + "",
                        (int) sheet.getRow(i).getCell(9).getNumericCellValue() + "",
                        sheet.getRow(i).getCell(10).getNumericCellValue() + "",
                        sheet.getRow(i).getCell(11).getNumericCellValue() + "",
                        sheet.getRow(i).getCell(12).getNumericCellValue() + "",
                        sheet.getRow(i).getCell(13).getNumericCellValue() + "",
                        sheet.getRow(i).getCell(14).getNumericCellValue() + ""));
            }
        }
        return faktury;
    }
}
