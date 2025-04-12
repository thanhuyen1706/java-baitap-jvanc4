package Baitapfile;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
        List<String> urls = Arrays.asList(
            "https://example.com/article1",
            "https://example.com/article2",
            "https://example.com/article3",
            "https://example.com/article4",
            "https://example.com/article5"
        );
        URLDownloader.downloadAndProcess(urls);
    }
}
