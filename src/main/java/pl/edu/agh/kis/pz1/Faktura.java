package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"NazwaOdbiorcy", "AdresOdbiorcy", "NipOdbiorcy", "DataWystawienia", "DataSprzedazy", "NrFaktury",
        "TytulPozycji", "LiczbaSztuk", "CenaJednostkowa", "StawkaPodatku", "KwotaPodatku", "CenaNettoPozycji",
        "CenaBruttoPozycji", "CenaNettoFaktury", "CenaBruttoFaktury"})
public class Faktura {


    @XmlElement(name = "Nazwa_odbiorcy")
    private String NazwaOdbiorcy;
    @XmlElement(name = "Adres_odbiorcy")
    private String AdresOdbiorcy;
    @XmlElement(name = "Nip_odbiorcy")
    private String NipOdbiorcy;
    @XmlElement(name = "Data_wystawienia")
    private String DataWystawienia;
    @XmlElement(name = "Data_sprzedaży")
    private String DataSprzedazy;
    @XmlElement(name = "Nr_faktury")
    private String NrFaktury;
    @XmlElement(name = "Tytuł_pozycji")
    private String TytulPozycji;
    @XmlElement(name = "Liczba_sztuk")
    private double LiczbaSztuk;
    @XmlElement(name = "Cena_jednostkowa")
    private BigDecimal CenaJednostkowa;
    @XmlElement(name = "Stawka_podatku")
    private int StawkaPodatku;
    @XmlElement(name = "Kwota_Podatku")
    private BigDecimal KwotaPodatku;
    @XmlElement(name = "Cena_netto_pozycji")
    private BigDecimal CenaNettoPozycji;
    @XmlElement(name = "Cena_brutto_pozycji")
    private BigDecimal CenaBruttoPozycji;
    @XmlElement(name = "Cena_netto_faktury_łącznie")
    private BigDecimal CenaNettoFaktury;
    @XmlElement(name = "Cena_brutto_faktury_łącznie")
    private BigDecimal CenaBruttoFaktury;


    public Faktura() {}

    public Faktura(String nazwaOdbiorcy, String adresOdbiorcy, String nipOdbiorcy, String dataWystawienia,
                   String dataSprzedazy, String nrFaktury, String tytulPozycji, String liczbaSztuk,
                   String cenaJednostkowa, String stawkaPodatku, String kwotaPodatku,
                   String cenaNettoPozycji, String cenaBruttoPozycji, String cenaNettoFaktury, String cenaBruttoFaktury) {
        NazwaOdbiorcy = nazwaOdbiorcy;
        AdresOdbiorcy = adresOdbiorcy;
        NipOdbiorcy = nipOdbiorcy;
        DataWystawienia = dataWystawienia;
        DataSprzedazy = dataSprzedazy;
        NrFaktury = nrFaktury;
        TytulPozycji = tytulPozycji;
        LiczbaSztuk = Double.parseDouble(liczbaSztuk.replace(",", "."));
        CenaJednostkowa = BigDecimal.valueOf(Double.parseDouble(cenaJednostkowa.split(" ")[0].replace(",", ".").replaceAll("\u00A0", ""))).setScale(2, RoundingMode.HALF_UP);
        StawkaPodatku = Integer.parseInt(stawkaPodatku);
        KwotaPodatku = BigDecimal.valueOf(Double.parseDouble(kwotaPodatku.split(" ")[0].replace(",", ".").replaceAll("\u00A0", ""))).setScale(2, RoundingMode.HALF_UP);
        CenaNettoPozycji = BigDecimal.valueOf(Double.parseDouble(cenaNettoPozycji.split(" ")[0].replace(",", ".").replaceAll("\u00A0", ""))).setScale(2, RoundingMode.HALF_UP);
        CenaBruttoPozycji = BigDecimal.valueOf(Double.parseDouble(cenaBruttoPozycji.split(" ")[0].replace(",", ".").replaceAll("\u00A0", ""))).setScale(2, RoundingMode.HALF_UP);
        CenaNettoFaktury = BigDecimal.valueOf(Double.parseDouble(cenaNettoFaktury.split(" ")[0].replace(",", ".").replaceAll("\u00A0", ""))).setScale(2, RoundingMode.HALF_UP);
        CenaBruttoFaktury = BigDecimal.valueOf(Double.parseDouble(cenaBruttoFaktury.split(" ")[0].replace(",", ".").replaceAll("\u00A0", ""))).setScale(2, RoundingMode.HALF_UP);
    }



    @Override
    public String toString() {
        return "Nazwa odbiorcy: " + NazwaOdbiorcy + ", " +
                "Adres odbiorcy: " + AdresOdbiorcy + ", " +
                "Nip odbiorcy: " + NipOdbiorcy + ", " +
                "Data wystawienia: " + DataWystawienia + ", " +
                "Data sprzedaży: " + DataSprzedazy + ", " +
                "Nr faktury: " + NrFaktury + ", " +
                "Tytuł pozycji: " + TytulPozycji + ", " +
                "Liczba sztuk: " + LiczbaSztuk + ", " +
                "Cena jednostkowa: " + CenaJednostkowa + ", " +
                "Stawka podatku: " + StawkaPodatku + ", " +
                "Kwota podatku: " + KwotaPodatku + ", " +
                "Cena netto pozycji: " + CenaNettoPozycji + ", " +
                "Cena brutto pozycji: " + CenaBruttoPozycji + ", " +
                "Cena netto faktury łącznie: " + CenaNettoFaktury + ", " +
                "Cena brutto faktury łącznie: " + CenaBruttoFaktury;
    }


}
