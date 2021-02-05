/**
 * 
 */
package org.example.UsersByState;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.Actions.UsersByStateReader;
import org.example.Actions.UsersByStateWriter;
import org.example.Entities.FileProperties;
import org.example.Entities.UserRecords;


/**
 * This program will read in data from a CSV file, it will check the properties
 * file for the state field and search the input file by state field then return
 * the results
 * 
 * @author Rostom Sahakian
 *
 */
public class UsersByState {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//
		// step 1)Read Properties file
		FileProperties config = new FileProperties();
		// step 2) Use CONFIG file to read the input file
		// Open input file
		UsersByStateReader reader = new UsersByStateReader();
		reader.open(config.getInputFile());
		// Open output file
		UsersByStateWriter writer = new UsersByStateWriter();
		writer.open(config.getOutputFile());
		// Do something with the incoming data
        while (true)
        {
            if (reader.eof())
            {
                break;
            }
            List<UserRecords> data = reader.UserRecords(config.getchunk());
            List<String> results = new ArrayList<String>();

            for (UserRecords record : data)
            {
                if (record.SearchBy(config.getSearchBy(), config.getwhere()))
                {
                    results.add(record.format());
                  //  System.out.println("Post-->"+results.size());
                }
            }
          
            writer.writeLines(results);
          
        }
   

		// close output file
		writer.close();
		// Close input file
		reader.close();
		// Exit program
		System.exit(0);

	}

}
