import java.io.*;
import java.util.*;

public class MetaDataHandler {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter type of file like: (Text/Image/Audio)");
        String type = sc.nextLine().toLowerCase();

        System.out.println("Enter File Path");
        String path = sc.nextLine();

        FileHandlers file;

        switch (type) {
            case "text":
                file = new TextFile(path);
                break;

            case "image":
                file = new ImageFile(path);
                break;

            case "audio":
                file = new AudioFile(path);
                break;

            default:
                System.out.println("Unknown file");
                return;
        }

        System.out.println(file.getSummary());
    }
}

abstract class FileHandlers {

    private final String path;

    public FileHandlers(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract String getSummary();
}

class TextFile extends FileHandlers {

    public TextFile(String path) {
        super(path);
    }

    public String getSummary() {
        if (getPath().isEmpty()) {
            return "Empty Summary";
        }
        return "Text File".intern();
    }
}

class ImageFile extends FileHandlers {

    public ImageFile(String path) {
        super(path);
    }

    public String getSummary() {
        if (getPath().isEmpty()) {
            return "Empty Summary";
        }
        return "Image File".intern();
    }
}

class AudioFile extends FileHandlers {

    public AudioFile(String path) {
        super(path);
    }

    public String getSummary() {
        if (getPath().isEmpty()) {
            return "Empty Summary";
        }
        return "Audio File".intern();
    }
}