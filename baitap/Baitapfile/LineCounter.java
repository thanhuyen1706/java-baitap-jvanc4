package Baitapfile;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class LineCounter {
	public static int countLines(String inputFile) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			int count = 0;
			while (reader.readLine() != null) {
				count++;
			}
			return count;
		}
	}
}
