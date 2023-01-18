package pl.edu.agh.kis.pz1;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * class responsible for reading data from XLSX file
 */
public class XLSXReader {

    private XLSXReader() {}

    /**
     * @param fileName the name of the file to open and read XLSX data from
     * @return list of Faktura objects
     */
    public static List<Faktura> readFromXLSX(String fileName) throws IOException {
        ArrayList<Faktura> faktury = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try (InputStream in = new FileInputStream(fileName)) {
            Workbook workbook = WorkbookFactory.create(in);
            Sheet sheet = workbook.getSheetAt(0);
            String[] dane = new String[15];
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                dane[0] = sheet.getRow(i).getCell(0).getStringCellValue();
                dane[1] = sheet.getRow(i).getCell(1).getStringCellValue();
                dane[2] = sheet.getRow(i).getCell(2).getStringCellValue();
                dane[3] = formatter.format(sheet.getRow(i).getCell(3).getDateCellValue());
                dane[4] = formatter.format(sheet.getRow(i).getCell(4).getDateCellValue());
                dane[5] = sheet.getRow(i).getCell(5).getStringCellValue();
                dane[6] = sheet.getRow(i).getCell(6).getStringCellValue();
                dane[7] = sheet.getRow(i).getCell(7).getNumericCellValue() + "";
                dane[8] = sheet.getRow(i).getCell(8).getNumericCellValue() + "";
                dane[9] =  (int) sheet.getRow(i).getCell(9).getNumericCellValue() + "";
                dane[10] = sheet.getRow(i).getCell(10).getNumericCellValue() + "";
                dane[11] = sheet.getRow(i).getCell(11).getNumericCellValue() + "";
                dane[12] = sheet.getRow(i).getCell(12).getNumericCellValue() + "";
                dane[13] = sheet.getRow(i).getCell(13).getNumericCellValue() + "";
                dane[14] = sheet.getRow(i).getCell(14).getNumericCellValue() + "";

                faktury.add(new Faktura(dane));
            }
            workbook.close();
        }
        return faktury;
    }
}
