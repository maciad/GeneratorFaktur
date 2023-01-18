import org.junit.Test;
import pl.edu.agh.kis.pz1.Main;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMain_CSV() throws JAXBException, IOException {
        String inputFile = "src/main/resources/faktury-sprzedazowe-test-short-2023.csv";
        String outputFile = "test.xml";
        File file = new File(outputFile);
        if (file.exists()) {
            file.delete();
        }
        Main.main(new String[]{inputFile, outputFile});
        assertTrue(file.exists());
    }

    @Test
    public void testMain_XLSX() throws JAXBException, IOException {
        String inputFile = "src/test/java/test.xlsx";
        String outputFile = "test.xml";
        File file = new File(outputFile);
        if (file.exists()) {
            file.delete();
        }
        Main.main(new String[]{inputFile, outputFile});
        assertTrue(file.exists());
    }

    @Test
    public void testMain_InvalidFileFormat() {
        String inputFile = "test.txt";
        String outputFile = "test.xml";
        File file = new File(outputFile);
        if (file.exists()) {
            file.delete();
        }
        assertThrows(IllegalArgumentException.class, () -> Main.main(new String[]{inputFile, outputFile}));
        file.delete();
    }

    @Test
    public void testMain_NoInputFile() {
        String outputFile = "test.xml";
        File file = new File(outputFile);
        if (file.exists()) {
            file.delete();
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Main.main(new String[]{outputFile}));
        file.delete();
    }

    @Test
    public void testMain_NoOutputFile() {
        String inputFile = "test.csv";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Main.main(new String[]{inputFile}));
    }


}