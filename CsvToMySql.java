package com.rohit.tshirt_search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CsvToMySql {

	
	public void CsvToDataBase() throws FileNotFoundException
	{

		 	Configuration con = new Configuration().configure().addAnnotatedClass(Tshirt.class);
	        
	        ServiceRegistry seg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	        
	        SessionFactory sf = con.buildSessionFactory(seg);
	       
	        Session session = sf.openSession();
	        
	        Transaction tx =session.beginTransaction();
	        
	        String directoryPath = "/Users/macbook/Downloads";
	        File[] filesInDirectory = new File(directoryPath).listFiles();
	        
	        for(File f : filesInDirectory){
	            String filePath = f.getAbsolutePath();
	            String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
	            if("csv".equals(fileExtension)){
	            	 File MyCsvFile = new File(filePath);
	            	 Scanner fc = new Scanner(MyCsvFile);
	            	 fc.nextLine();
	            	 while (fc.hasNext()) {
	            		 
	                     String line = fc.nextLine().toUpperCase();
	                     String[] wordArray = line.split("\\|");
	                     Tshirt tshirt = new Tshirt(wordArray[0],wordArray[1],wordArray[2],wordArray[3],wordArray[4],Double.parseDouble(wordArray[5]),Float.parseFloat(wordArray[6]),wordArray[7]);
	                     session.save(tshirt);
	                     
	            	 }
	            }
	        }
	        tx.commit();
	}
}
