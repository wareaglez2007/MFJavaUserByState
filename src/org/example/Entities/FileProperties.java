/**
 * 
 */
package org.example.Entities;

/**
 * @author Rostom Sahakian
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileProperties {

	// input.dir=data
	// input.file=POP.csv
	// output.dir=results
	// output.file=PopulationReport.txt
	// chunk=3
	final static String CONFIGFILE = "config.properties";
	private String inputDir;
	private String inputFile;
	private String outputDir;
	private String outputFile;
	private int chunk;
	private String searchBy;
	private String where;

	public FileProperties() {
		// Read properties "config.properties"
		Properties prop = null;
		try {
			prop = new Properties();
			InputStream input = new FileInputStream(CONFIGFILE);

			prop.load(input);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(4);
		}
		//input
		setInputDir(prop.getProperty("input.dir"));
		String inputFileName = prop.getProperty("input.file");		
		setInputFile(getInputDir() 
				+ File.separator + inputFileName);
		//Output
		setOutputDir(prop.getProperty("output.dir"));
		String outputFileName = prop.getProperty("output.file");
		setOutputFile(getOutputDir()+ File.separator + outputFileName);
		
		//Chunk value [amount to read at one time from file]
		String chunkValue = prop.getProperty("chunk");
		setchunk(Integer.parseInt(chunkValue));
		
		//What field to search by
		setSearchBy(prop.getProperty("search.by"));
		
		//What value to search for
		setwhere(prop.getProperty("where"));
	}

	public String getInputDir() {
		return inputDir;
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public int getchunk() {
		return chunk;
	}

	public void setchunk(int chunk) {
		this.chunk = chunk;
	}

	public String getwhere() {
		return where;
	}

	public void setwhere(String where) {
		this.where = where;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
}
