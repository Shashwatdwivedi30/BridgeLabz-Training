import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class FileProcessorTest {

    FileProcessor fp;

    @BeforeEach
    void init() {
        fp = new FileProcessor();
    }

    @Test
    void testWriteAndRead() throws Exception {
        fp.writeToFile("test.txt", "Hello");
        assertEquals("Hello", fp.readFromFile("test.txt"));
    }

    @Test
    void testFileExists() throws Exception {
        fp.writeToFile("file.txt", "Data");
        File f = new File("file.txt");
        assertTrue(f.exists());
    }

    @Test
    void testReadMissingFile() {
        assertThrows(IOException.class, () -> fp.readFromFile("missing.txt"));
    }
}
