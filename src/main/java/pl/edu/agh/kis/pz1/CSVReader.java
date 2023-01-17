package pl.edu.agh.kis.pz1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {

    private CSVReader() {}

    /**
     * @param fileName the name of the file to open and read CSV data from
     * @return list of Faktura objects
     */
    public static List<Faktura> readFromCSV(String fileName) throws IOException {
        List<Faktura> faktury = new ArrayList<>();
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String headers = reader.readLine(); // skip headers
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split("\t");
                faktury.add(new Faktura(values));
                line = reader.readLine();
            }
        }
        return faktury;
    }

}
