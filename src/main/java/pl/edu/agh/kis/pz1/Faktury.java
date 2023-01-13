package pl.edu.agh.kis.pz1;


import javax.xml.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static ArrayList<Faktura> readFromCSV(String fileName) throws IOException {
        ArrayList<Faktura> faktury = new ArrayList<>();
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String header = reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split("\t");
                faktury.add(new Faktura(values[0], values[1], values[2], values[3], values[4], values[5], values[6],
                        values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14]));
                line = reader.readLine();
            }
        }
        return faktury;
    }

}

