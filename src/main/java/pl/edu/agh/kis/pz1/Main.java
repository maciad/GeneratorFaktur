package pl.edu.agh.kis.pz1;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;


public class Main {

    public static void main(String[] args) throws JAXBException, IOException {

        String inputFile = args[0];
        String outputFile = args[1];
        File file = new File(outputFile);

        Faktury faktury = new Faktury();

        if (inputFile.endsWith(".csv")) {
            faktury.setFaktury(CSVReader.readFromCSV(inputFile));
        } else if (inputFile.endsWith(".xlsx") | inputFile.endsWith(".xls")) {
            faktury.setFaktury(XLSXReader.readFromXLSX(inputFile));
        }
        else {
            throw new IllegalArgumentException("Wrong file format");
        }

        JAXBContext context = JAXBContext.newInstance(Faktury.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(faktury, file);
        System.out.println("File saved to " + outputFile);

    }
}