package pl.edu.agh.kis.pz1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void marshal(ArrayList<Faktura> faktury, File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Faktura.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(faktury, file);
    }

    public static void main(String[] args) throws JAXBException, IOException {

        Faktury faktury = new Faktury();
        faktury.setFaktury(Faktury.readFromCSV("src/main/resources/faktury.csv"));
        JAXBContext context = JAXBContext.newInstance(Faktury.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(faktury, new File("sd.xml"));

    }
}