/**
 * 
 */
package org.example.Actions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.example.Entities.UserRecords;

/**
 * @author Administrator
 *
 */
public class UsersByStateReader {
	private BufferedReader reader = null;
	private boolean eof = false;

	public void open(String inputFile) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(inputFile));

	}

	public void close() throws IOException {
		reader.close();

	}

	public boolean eof() {
		// TODO Auto-generated method stub
		return eof;
	}

	public List<UserRecords> UserRecords(int getchunk) {
		// TODO Auto-generated method stub
		return null;
	}

}
