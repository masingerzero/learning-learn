package org.masingerzero.modernjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

	public static void main(String[] args) throws IOException {
		String line = new ExecuteAround().processFile((BufferedReader br) -> br.readLine());
		System.out.println(line);

		line = new ExecuteAround().processFile((BufferedReader br) -> {
			String result = br.readLine() + br.readLine();
			return result;
		});
		System.out.println(line);

	}

	public String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return p.process(br);
		}
	}

	@FunctionalInterface
	interface BufferedReaderProcessor {
		String process(BufferedReader br) throws IOException;
	}

}
