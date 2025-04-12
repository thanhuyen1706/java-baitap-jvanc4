package Baitapfile;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class IntegerFileHandler {
	public static int countLines(String inputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            return count;
        }
    }
public static List<Integer> readIntegers(String fileName) throws IOException {
    List<Integer> numbers = new ArrayList<>();
    try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
        while (dis.available() > 0) {
            numbers.add(dis.readInt());
        }
    }
    return numbers;
}
}