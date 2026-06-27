import java.io.*;
import java.util.Scanner;
class FileWriterUtility {
    private String fileName;
    public FileWriterUtility(String fileName) {
        this.fileName = fileName;
    }
    public void writeToFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        System.out.println("Enter text (Type EXIT to stop):");
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("EXIT")) {
                break;
            }
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
}
class FileReaderUtility {
    private String fileName;

    public FileReaderUtility(String fileName) {
        this.fileName = fileName;
    }
    public int countSentences() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                count++;
            }
        }
        br.close();
        return count;
    }
}
public class SentenceCounterApp {
    public static void main(String[] args) {
        String fileName = "thisText.txt";
        try {
            FileWriterUtility writer = new FileWriterUtility(fileName);
            writer.writeToFile();
            FileReaderUtility reader = new FileReaderUtility(fileName);
            int totalSentences = reader.countSentences();
            System.out.println("\nTotal Sentences/Paragraphs Written: "+ totalSentences);
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
