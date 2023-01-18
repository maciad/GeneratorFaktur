package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Class representing a list of invoices (Faktura objects)
 */
@XmlRootElement(name = "Faktury")
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktury {

    @XmlElement(name = "Waluta")
    private static final String WALUTA = "PLN";
    @XmlElement(name = "Faktura")
    private List<Faktura> listaFaktur;

    private BigDecimal sumaNetto = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);
    private BigDecimal sumaVat = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);

    public List<Faktura> getFaktury() {
        return listaFaktur;
    }

    public void setFaktury(List<Faktura> faktury) {
        this.listaFaktur = faktury;
        for (Faktura faktura : faktury) {
            sumaNetto = sumaNetto.add(faktura.getCenaNettoFaktury());
            sumaVat = sumaVat.add(faktura.getKwotaPodatku());
        }
    }

    public BigDecimal getSumaNetto() {
        return sumaNetto;
    }

    public BigDecimal getSumaVat() {
        return sumaVat;
    }

    public void setSumaNetto(BigDecimal sumaNetto) {
        this.sumaNetto = sumaNetto;
    }

    public void setSumaVat(BigDecimal sumaVat) {
        this.sumaVat = sumaVat;
    }

}

