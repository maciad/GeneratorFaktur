import org.junit.Test;
import pl.edu.agh.kis.pz1.CSVReader;
import pl.edu.agh.kis.pz1.Faktura;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.Assert.*;


public class CSVReaderTest {

    private static final String TEST_CSV_FILE = "test.csv";

    @Test
    public void testReadFromCSV() throws IOException {
        Path path = Paths.get(TEST_CSV_FILE);
        String data = """
                Nazwa_odbiorcy\tAdres_odbiorcy\tNip_odbiorcy\tData_wystawienia\tData_sprzedaży\tNr_faktury\tTytuł_pozycji\tLiczba_sztuk\tCena_jednostkowa\tStawka_podatku\tKwota_podatku\tCena_netto_pozycji\tCena_brutto_pozycji\tCena_netto_faktury_łącznie\tCena_brutto_faktury_łącznie
                John Doe\tNew York\t1234567890\t2022-01-01\t2022-01-15\tFV/2022/1\tTable\t5\t100.00\t23\t115.00\t138.95\t575.00\t690.75\t690.75
                Jane Smith\tChicago\t0987654321\t2022-02-01\t2022-02-15\tFV/2022/2\tChair\t10\t50.00\t8\t40.00\t54.00\t500.00\t540.00\t540.00
                """;
        Files.write(path, data.getBytes());

        List<Faktura> faktury = CSVReader.readFromCSV(TEST_CSV_FILE);
        assertEquals(2, faktury.size());
        assertEquals("John Doe", faktury.get(0).getNazwaOdbiorcy());
        assertEquals("Jane Smith", faktury.get(1).getNazwaOdbiorcy());
        assertEquals(new BigDecimal("690.75"), faktury.get(0).getCenaBruttoFaktury());
        assertEquals(new BigDecimal("540.00"), faktury.get(1).getCenaBruttoFaktury());

        // Cleanup the test file
        Files.delete(path);
    }

    @Test(expected = IOException.class)
    public void testReadFromCSVThrowsIOException() throws IOException {
        CSVReader.readFromCSV("nonexistent_file.csv");
    }
}