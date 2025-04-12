package Baitapfile;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class MultiThreadedFileReader {
	public static void readFile(String filePath) throws IOException, InterruptedException {
        File file = new File(filePath);
        long fileSize = file.length();
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long chunkSize = fileSize / numThreads;

        for (int i = 0; i < numThreads; i++) {
            long start = i * chunkSize;
            long end = (i == numThreads - 1) ? fileSize : (start + chunkSize);
            executor.execute(new FileChunkReader(filePath, start, end));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
