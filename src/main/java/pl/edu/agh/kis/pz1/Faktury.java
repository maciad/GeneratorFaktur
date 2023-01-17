package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class representing a list of invoices (Faktura objects)
 */
@XmlRootElement(name = "Faktury")
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktury {
    @XmlElement(name = "Faktura")
    private List<Faktura> listaFaktur;

    public List<Faktura> getFaktury() {
        return listaFaktur;
    }

    public void setFaktury(List<Faktura> faktury) {
        this.listaFaktur = faktury;
    }




}

