package pl.edu.agh.kis.pz1;


import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "Faktury")
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktury {
    @XmlElement(name = "Faktura")
    private List<Faktura> faktury;

    public List<Faktura> getFaktury() {
        return faktury;
    }

    public void setFaktury(List<Faktura> faktury) {
        this.faktury = faktury;
    }




}

