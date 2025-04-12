package Baitapfile;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class KeywordSearcher {
	 public static void search(String keyword, List<String> filePaths) {
	        ExecutorService executor = Executors.newFixedThreadPool(filePaths.size());
	        for (String path : filePaths) {
	            executor.execute(() -> {
	                try {
	                    long count = Files.lines(Paths.get(path)).filter(line -> line.contains(keyword)).count();
	                    System.out.println("File: " + path + " - Occurrences: " + count);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            });
	        }
	        executor.shutdown();
	    }
}
