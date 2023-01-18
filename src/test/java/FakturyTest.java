import org.junit.Test;
import pl.edu.agh.kis.pz1.Faktura;
import pl.edu.agh.kis.pz1.Faktury;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class FakturyTest {

    private Faktura createFaktura(BigDecimal netto, BigDecimal vat) {
        Faktura faktura = new Faktura();
        faktura.setCenaNettoFaktury(netto);
        faktura.setKwotaPodatku(vat);
        return faktura;
    }

    @Test
    public void testSetFaktury() {
        List<Faktura> faktury = new ArrayList<>();
        faktury.add(createFaktura(new BigDecimal("100.00"), new BigDecimal("20.00")));
        faktury.add(createFaktura(new BigDecimal("200.00"), new BigDecimal("40.00")));
        faktury.add(createFaktura(new BigDecimal("50.00"), new BigDecimal("10.00")));

        Faktury fakturyList = new Faktury();
        fakturyList.setFaktury(faktury);

        assertEquals(new BigDecimal("350.00"), fakturyList.getSumaNetto());
        assertEquals(new BigDecimal("70.00"), fakturyList.getSumaVat());
    }

    @Test
    public void testGetFaktury() {
        List<Faktura> faktury = new ArrayList<>();
        faktury.add(createFaktura(new BigDecimal("100.00"), new BigDecimal("20.00")));
        faktury.add(createFaktura(new BigDecimal("200.00"), new BigDecimal("40.00")));
        faktury.add(createFaktura(new BigDecimal("50.00"), new BigDecimal("10.00")));

        Faktury fakturyList = new Faktury();
        fakturyList.setFaktury(faktury);

        assertEquals(faktury, fakturyList.getFaktury());
    }
}