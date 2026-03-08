package com.automation.web.common_utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvReader {
	
    public ArrayList<String> list =new ArrayList<String>();
    public ArrayList<String> rowList =new ArrayList<String>();
    public ArrayList<String> column1ValueList =new ArrayList<String>();
    public ArrayList<String> firstCsvLineList =new ArrayList<String>();

	int columnSize;

	public  void getDataFromCSV() throws IOException, CsvException
	{
		
//		String line=null;
		
//		BufferedReader reader = null;
		
		CSVReader reader = null;

			String filePath =ConfigReader.getValue("csvPath");
			String line;
			try {
			    reader = new CSVReader(new FileReader(filePath));

			    // Read all rows of the CSV file
			    List<String[]> rows = reader.readAll();

			    // Process each row
			    for (String[] row : rows) {
			        // Process the values as needed
			        // Example: Print each value
			        for (String value : row) {
			        	list.add(value);
			            System.out.println(list.clone());
			        }
			    }
			} catch (IOException | CsvException e) {
			    e.printStackTrace();
			} finally {
			    try {
			        if (reader != null) {
			            reader.close();
			        }
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
		
	}
			
	
	
	    public  int  getRowsCount() {
			String filePath =ConfigReader.getValue("csvPath");
	        CSVReader reader = null;
	        int rowCount = 0;
	        try {
	            reader = new CSVReader(new FileReader(filePath));

	          

	            // Read rows until the end of the file
	            while (reader.readNext() != null) {
	                rowCount++;
	            }

	            System.out.println("Number of rows: " + rowCount);
	        } catch (IOException | CsvException e) {
	            e.printStackTrace();
	        } finally { try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
			return rowCount;
	       
	}
	    public void getParticularColumn()
	    {
	    	CSVReader reader = null;
			String filePath =ConfigReader.getValue("csvPath");


	        try {
	            reader = new CSVReader(new FileReader(filePath));

	            List<String[]> rows = reader.readAll();

	            int column1Index = 0; // Index of the first column you want to retrieve
	            int column2Index = 2; // Index of the second column you want to retrieve

	            for (String[] row : rows) {
	                if (row.length > column1Index && row.length > column2Index) {
	                    String column1Value = row[column1Index];
	                   if(column1Value.equals("NAME"))
	                   {
	                	   
	                   }
	                   else
	                   {
	                    System.out.println("Column : " + column1Value);
	                    column1ValueList.add(column1Value);
	                   }
	                }
	            }
	        } catch (IOException | CsvException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (reader != null) {
	                    reader.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	    }
	    
	    public void getFirstLineData()
	    {
			String filePath =ConfigReader.getValue("csvPath");

	         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	             String line;

	             // Read the first line of the CSV file
	             if ((line = br.readLine()) != null) {
	                 System.out.println(line);
	                 firstCsvLineList.add(line);
	             }
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	    }
}
