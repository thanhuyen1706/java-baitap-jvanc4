package Baitapfile;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class DirectoryLister {
	public static void listFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                System.out.println(file.getName());
            }
        }
    }
}
