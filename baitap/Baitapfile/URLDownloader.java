package Baitapfile;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class URLDownloader {
	public static void downloadAndProcess(List<String> urls) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(urls.size());
        List<String> downloadedFiles = Collections.synchronizedList(new ArrayList<>());
        
        for (int i = 0; i < urls.size(); i++) {
            final int index = i;
            executor.execute(() -> {
                String fileName = "output" + index + ".txt";
                try (BufferedInputStream in = new BufferedInputStream(new URL(urls.get(index)).openStream());
                     FileOutputStream fos = new FileOutputStream(fileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                    downloadedFiles.add(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
            mergeAndCleanFiles(downloadedFiles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mergeAndCleanFiles(List<String> files) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("merged_output.txt"))) {
            for (String file : files) {
                List<String> lines = Files.readAllLines(Paths.get(file));
                for (String line : lines) {
                    String cleanedLine = Jsoup.parse(line).text();
                    writer.write(cleanedLine);
                    writer.newLine();
                }
            }
        }
    }
}
