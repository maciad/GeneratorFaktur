package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;



/**
 * Class representing a single invoice
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nazwaOdbiorcy", "adresOdbiorcy", "nipOdbiorcy", "dataWystawienia", "dataSprzedazy", "nrFaktury",
        "tytulPozycji", "liczbaSztuk", "cenaJednostkowa", "stawkaPodatku", "kwotaPodatku", "cenaNettoPozycji",
        "cenaBruttoPozycji", "cenaNettoFaktury", "cenaBruttoFaktury"})
public class Faktura {


    @XmlElement(name = "Nazwa_odbiorcy")
    private String nazwaOdbiorcy;
    @XmlElement(name = "Adres_odbiorcy")
    private String adresOdbiorcy;
    @XmlElement(name = "Nip_odbiorcy")
    private String nipOdbiorcy;
    @XmlElement(name = "Data_wystawienia")
    private String dataWystawienia;
    @XmlElement(name = "Data_sprzedaży")
    private String dataSprzedazy;
    @XmlElement(name = "Nr_faktury")
    private String nrFaktury;
    @XmlElement(name = "Tytuł_pozycji")
    private String tytulPozycji;
    @XmlElement(name = "Liczba_sztuk")
    private double liczbaSztuk;
    @XmlElement(name = "Cena_jednostkowa")
    private BigDecimal cenaJednostkowa;
    @XmlElement(name = "Stawka_podatku")
    private int stawkaPodatku;
    @XmlElement(name = "Kwota_Podatku")
    private BigDecimal kwotaPodatku;
    @XmlElement(name = "Cena_netto_pozycji")
    private BigDecimal cenaNettoPozycji;
    @XmlElement(name = "Cena_brutto_pozycji")
    private BigDecimal cenaBruttoPozycji;
    @XmlElement(name = "Cena_netto_faktury_łącznie")
    private BigDecimal cenaNettoFaktury;
    @XmlElement(name = "Cena_brutto_faktury_łącznie")
    private BigDecimal cenaBruttoFaktury;

    @XmlTransient
    static final String NBSP = "\u00A0";

    public Faktura() {}

    /**
     * Constructor of the class
     * @param dane array of strings containing data to be parsed. The order of the data is as follows:
     *             0 - nazwa odbiorcy,
     *             1 - adres odbiorcy,
     *             2 - nip odbiorcy,
     *             3 - data wystawienia,
     *             4 - data sprzedaży,
     *             5 - numer faktury,
     *             6 - tytuł pozycji,
     *             7 - liczba sztuk,
     *             8 - cena jednostkowa,
     *             9 - stawka podatku,
     *             10 - kwota podatku,
     *             11 - cena netto pozycji,
     *             12 - cena brutto pozycji,
     *             13 - cena netto faktury,
     *             14 - cena brutto faktury
     */
    public Faktura(String[] dane) {
        this.nazwaOdbiorcy = dane[0];
        this.adresOdbiorcy = dane[1];
        this.nipOdbiorcy = dane[2];
        this.dataWystawienia = dane[3];
        this.dataSprzedazy = dane[4];
        this.nrFaktury = dane[5];
        this.tytulPozycji = dane[6];
        this.liczbaSztuk = Double.parseDouble(dane[7].replace(",", "."));
        this.cenaJednostkowa = BigDecimal.valueOf(Double.parseDouble(dane[8].split(" ")[0].replace(",", ".").replace(NBSP, ""))).setScale(2, RoundingMode.HALF_UP);
        this.stawkaPodatku = Integer.parseInt(dane[9]);
        this.kwotaPodatku = BigDecimal.valueOf(Double.parseDouble(dane[10].split(" ")[0].replace(",", ".").replace(NBSP, ""))).setScale(2, RoundingMode.HALF_UP);
        this.cenaNettoPozycji = BigDecimal.valueOf(Double.parseDouble(dane[11].split(" ")[0].replace(",", ".").replace(NBSP, ""))).setScale(2, RoundingMode.HALF_UP);
        this.cenaBruttoPozycji = BigDecimal.valueOf(Double.parseDouble(dane[12].split(" ")[0].replace(",", ".").replace(NBSP, ""))).setScale(2, RoundingMode.HALF_UP);
        this.cenaNettoFaktury = BigDecimal.valueOf(Double.parseDouble(dane[13].split(" ")[0].replace(",", ".").replace(NBSP, ""))).setScale(2, RoundingMode.HALF_UP);
        this.cenaBruttoFaktury = BigDecimal.valueOf(Double.parseDouble(dane[14].split(" ")[0].replace(",", ".").replace(NBSP, ""))).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCenaNettoFaktury() {
        return cenaNettoFaktury;
    }

    public BigDecimal getKwotaPodatku() {
        return kwotaPodatku;
    }

    public BigDecimal getCenaBruttoFaktury() {
        return cenaBruttoFaktury;
    }

    public BigDecimal getCenaNettoPozycji() {
        return cenaNettoPozycji;
    }

    public BigDecimal getCenaBruttoPozycji() {
        return cenaBruttoPozycji;
    }

    public BigDecimal getCenaJednostkowa() {
        return cenaJednostkowa;
    }

    public String getNazwaOdbiorcy() {
        return nazwaOdbiorcy;
    }

    public String getAdresOdbiorcy() {
        return adresOdbiorcy;
    }

    public String getNipOdbiorcy() {
        return nipOdbiorcy;
    }

    public String getDataWystawienia() {
        return dataWystawienia;
    }

    public String getDataSprzedazy() {
        return dataSprzedazy;
    }

    public String getNrFaktury() {
        return nrFaktury;
    }

    public String getTytulPozycji() {
        return tytulPozycji;
    }

    public double getLiczbaSztuk() {
        return liczbaSztuk;
    }

    public int getStawkaPodatku() {
        return stawkaPodatku;
    }

    public void setCenaNettoFaktury(BigDecimal cenaNettoFaktury) {
        this.cenaNettoFaktury = cenaNettoFaktury;
    }

    public void setKwotaPodatku(BigDecimal kwotaPodatku) {
        this.kwotaPodatku = kwotaPodatku;
    }


    @Override
    public String toString() {
        return "Nazwa odbiorcy: " + nazwaOdbiorcy + ", " +
                "Adres odbiorcy: " + adresOdbiorcy + ", " +
                "Nip odbiorcy: " + nipOdbiorcy + ", " +
                "Data wystawienia: " + dataWystawienia + ", " +
                "Data sprzedaży: " + dataSprzedazy + ", " +
                "Nr faktury: " + nrFaktury + ", " +
                "Tytuł pozycji: " + tytulPozycji + ", " +
                "Liczba sztuk: " + liczbaSztuk + ", " +
                "Cena jednostkowa: " + cenaJednostkowa + ", " +
                "Stawka podatku: " + stawkaPodatku + ", " +
                "Kwota podatku: " + kwotaPodatku + ", " +
                "Cena netto pozycji: " + cenaNettoPozycji + ", " +
                "Cena brutto pozycji: " + cenaBruttoPozycji + ", " +
                "Cena netto faktury łącznie: " + cenaNettoFaktury + ", " +
                "Cena brutto faktury łącznie: " + cenaBruttoFaktury;
    }


}
