package pl.edu.agh.kis.pz1;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"NazwaOdbiorcy", "AdresOdbiorcy", "NipOdbiorcy", "DataWystawienia", "DataSprzedazy", "NrFaktury",
        "TytulPozycji", "LiczbaSztuk", "CenaJednostkowa", "StawkaPodatku", "KwotaPodatku", "CenaNettoPozycji",
        "CenaBruttoPozycji", "CenaNettoFaktury", "CenaBruttoFaktury"})
public class Faktura {

    @XmlElement(name = "Nazwa odbiorcy")
    private String NazwaOdbiorcy;
    @XmlElement(name = "Adres odbiorcy")
    private String AdresOdbiorcy;
    @XmlElement(name = "Nip odbiorcy")
    private String NipOdbiorcy;
    @XmlElement(name = "Data wystawienia")
    private LocalDate DataWystawienia;
    @XmlElement(name = "Data sprzedaży")
    private LocalDate DataSprzedazy;
    @XmlElement(name = "Nr faktury")
    private String NrFaktury;
    @XmlElement(name = "Tytuł pozycji")
    private String TytulPozycji;
    @XmlElement(name = "Liczba sztuk")
    private String LiczbaSztuk;
    @XmlElement(name = "Cena jednostkowa")
    private String CenaJednostkowa;
    @XmlElement(name = "Stawka podatku %")
    private String StawkaPodatku;
    @XmlElement(name = "Kwota Podatku")
    private String KwotaPodatku;
    @XmlElement(name = "Cena netto pozycji")
    private String CenaNettoPozycji;
    @XmlElement(name = "Cena brutto pozycji")
    private String CenaBruttoPozycji;
    @XmlElement(name = "Cena netto faktury łącznie")
    private String CenaNettoFaktury;
    @XmlElement(name = "Cena brutto faktury łącznie")
    private String CenaBruttoFaktury;

    public Faktura() {}

    public Faktura(String nazwaOdbiorcy, String adresOdbiorcy, String nipOdbiorcy, String dataWystawienia,
                   String dataSprzedazy, String nrFaktury, String tytulPozycji, String liczbaSztuk,
                   String cenaJednostkowa, String stawkaPodatku, String kwotaPodatku,
                   String cenaNettoPozycji, String cenaBruttoPozycji, String cenaNettoFaktury, String cenaBruttoFaktury) {
        NazwaOdbiorcy = nazwaOdbiorcy;
        AdresOdbiorcy = adresOdbiorcy;
        NipOdbiorcy = nipOdbiorcy;
        DataWystawienia = LocalDate.parse(dataWystawienia);
        DataSprzedazy = LocalDate.parse(dataSprzedazy);
        NrFaktury = nrFaktury;
        TytulPozycji = tytulPozycji;
        LiczbaSztuk = liczbaSztuk;
        CenaJednostkowa = cenaJednostkowa;
        StawkaPodatku = stawkaPodatku;
        KwotaPodatku = kwotaPodatku.split(" ")[0];
        CenaNettoPozycji = cenaNettoPozycji.split(" ")[0].replace(",", ".").replaceAll();
        CenaBruttoPozycji = cenaBruttoPozycji;
        CenaNettoFaktury = cenaNettoFaktury;
        CenaBruttoFaktury = cenaBruttoFaktury;
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

    public void marshalToXML(File fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Faktura.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, fileName);
    }
}
