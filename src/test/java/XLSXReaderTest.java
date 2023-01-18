import org.junit.Test;
import pl.edu.agh.kis.pz1.Faktura;
import pl.edu.agh.kis.pz1.XLSXReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import static org.junit.Assert.*;

public class XLSXReaderTest {

    private static final String TEST_XLSX_FILE = "src/test/java/test.xlsx";

    @Test
    public void testReadFromXLSX() throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Faktura> faktury = XLSXReader.readFromXLSX(TEST_XLSX_FILE);
        assertEquals(3, faktury.size());
        assertEquals("Firma4", faktury.get(0).getNazwaOdbiorcy());
        assertEquals("Firma3 sp. z o.o.", faktury.get(1).getNazwaOdbiorcy());
        assertEquals(formatter.format(formatter.parse("2020-11-05")), faktury.get(0).getDataWystawienia());
        assertEquals(formatter.format(formatter.parse("2020-11-09")), faktury.get(1).getDataWystawienia());
        assertEquals(new BigDecimal("21697.20"), faktury.get(0).getCenaBruttoFaktury());
        assertEquals(new BigDecimal("138235.86"), faktury.get(1).getCenaBruttoFaktury());

    }

    @Test(expected = IOException.class)
    public void testReadFromXLSX_FileNotFound() throws IOException {
        XLSXReader.readFromXLSX("notExist.xlsx");
    }
}
