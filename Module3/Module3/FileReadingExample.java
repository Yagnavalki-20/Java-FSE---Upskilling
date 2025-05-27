import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReadingExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("output.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            System.out.println("Contents of output.txt:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
