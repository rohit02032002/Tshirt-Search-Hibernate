package com.rohit.tshirt_search;

import java.io.FileNotFoundException;

public class App {
    
    public static void main(String[] args) throws FileNotFoundException {
    	
    	//To take Inputs From User
    	
    	UserInputs inputs = new UserInputs();
    	inputs.takeInputs();
    	
    	//To Create table
    	
    	//CsvToMySql csvRead = new CsvToMySql();
    	//csvRead.CsvToDataBase();

    }
}
