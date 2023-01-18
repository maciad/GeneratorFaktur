import org.junit.Test;
import pl.edu.agh.kis.pz1.Faktura;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FakturaTest {

    @Test
    public void testConstructor() {
        String[] dane = {
                "Nazwa odbiorcy",
                "Adres odbiorcy",
                "1234567890",
                "2022-01-01",
                "2022-01-15",
                "FV/2022/1",
                "Tytul pozycji",
                "5",
                "100.00",
                "23",
                "23.00",
                "115.00",
                "138.95",
                "575.00",
                "690.75"
        };

        Faktura faktura = new Faktura(dane);

        assertEquals("Nazwa odbiorcy", faktura.getNazwaOdbiorcy());
        assertEquals("Adres odbiorcy", faktura.getAdresOdbiorcy());
        assertEquals("1234567890", faktura.getNipOdbiorcy());
        assertEquals("2022-01-01", faktura.getDataWystawienia());
        assertEquals("2022-01-15", faktura.getDataSprzedazy());
        assertEquals("FV/2022/1", faktura.getNrFaktury());
        assertEquals("Tytul pozycji", faktura.getTytulPozycji());
        assertEquals(5, faktura.getLiczbaSztuk(), 0);
        assertEquals(new BigDecimal("100.00"), faktura.getCenaJednostkowa());
        assertEquals(23, faktura.getStawkaPodatku());
        assertEquals(new BigDecimal("23.00"), faktura.getKwotaPodatku());
        assertEquals(new BigDecimal("115.00"), faktura.getCenaNettoPozycji());
        assertEquals(new BigDecimal("138.95"), faktura.getCenaBruttoPozycji());
        assertEquals(new BigDecimal("575.00"), faktura.getCenaNettoFaktury());
        assertEquals(new BigDecimal("690.75"), faktura.getCenaBruttoFaktury());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidData() {
        String[] dane = {
                "Nazwa odbiorcy",
                "Adres odbiorcy",
                "1234567890",
                "2022-01-01",
                "2022-01-15",
                "FV/2022/1",
                "Tytul pozycji",
                "5",
                "100.00",
                "23",
                "not a number",
                "115.00",
                "138.95",
                "575.00",
                "690.75"
        };

        new Faktura(dane);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testConstructorWithMissingData() {
        String[] dane = {
                "Nazwa odbiorcy",
                "Adres odbiorcy",
                "1234567890",
                "2022-01-01",
                "2022-01-15",
                "FV/2022/1",
                "Tytul pozycji",
                "5",
                "100.00",
                "23",
                "115.00",
                "138.95",
                "575.00"
        };

        new Faktura(dane);
    }
}