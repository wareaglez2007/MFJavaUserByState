/**
 * 
 */
package org.example.Actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class UsersByStateWriter {
	private BufferedWriter writer;

	public void open(String outputFile) throws IOException {
		writer = new BufferedWriter(new FileWriter(outputFile));

	}

	public void close() throws IOException {

		writer.close();
	}

	public void writeLines(List<String> lines) throws IOException {
		for (String current : lines) {
			writer.write(current + "\n");
		}
	}
}
