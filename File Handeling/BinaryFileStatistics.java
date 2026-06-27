import java.io.*;
import java.util.Scanner;
class BinaryFileWriter {
    private String fileName;
    public BinaryFileWriter(String fileName) {
        this.fileName = fileName;
    }
    public void writeNumbers() throws IOException {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos =
                new DataOutputStream(new FileOutputStream(fileName));
        System.out.print("Enter the number of floating-point values: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " floating-point numbers:");
        for (int i = 0; i < n; i++) {
            double num = sc.nextDouble();
            dos.writeDouble(num);
        }
        dos.close();
    }
}
class BinaryFileReader {
    private String fileName;
    public BinaryFileReader(String fileName) {
        this.fileName = fileName;
    }
    public void calculateStatistics() throws IOException {
        DataInputStream dis =
                new DataInputStream(new FileInputStream(fileName));
        double sum = 0;
        double max = Double.MIN_VALUE;
        int count = 0;
        try {
            while (true) {
                double num = dis.readDouble();
                sum += num;
                if (num > max) {
                    max = num;
                }
                count++;
            }
        }
        catch (EOFException e) {
        }
        dis.close();
        if (count > 0) {
            double average = sum / count;
            System.out.println("\nStatistics:");
            System.out.println("Total Numbers = " + count);
            System.out.println("Average Value = " + average);
            System.out.println("Highest Value = " + max);
        } else {
            System.out.println("No data found in file.");
        }
    }
}
public class BinaryFileStatistics {
    public static void main(String[] args) {
        String fileName = "numbers.dat";
        try {
            BinaryFileWriter writer = new BinaryFileWriter(fileName);
            writer.writeNumbers();
            BinaryFileReader reader = new BinaryFileReader(fileName);
            reader.calculateStatistics();
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
