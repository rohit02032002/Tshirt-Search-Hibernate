package com.rohit.tshirt_search;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FetchData {
	
	public void createQueryAndFetch(String color, String gender , String size,int preference)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Tshirt.class);
        
        ServiceRegistry seg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(seg);
       
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        //HQL
        
        String UserFormedQuery;
        Query query;
        List <Tshirt> results=null;
        String available="Y";
        
        if(preference == 1)
        {
        	UserFormedQuery = "from Tshirt Where Color = :color And Gender = :gender And Size = :size And Availability = :available Order By Price";
        	query=session.createQuery(UserFormedQuery);
        	query.setParameter("color", color);
        	query.setParameter("gender", gender);
        	query.setParameter("size", size);
        	query.setParameter("available", available);
        	results=query.list();
 
        }
        else if(preference == 2)
        {
        	UserFormedQuery = "From Tshirt Where Color = :color And Gender = :gender And Size = :size And Availability =:available Order By Rating Desc";
        	query=session.createQuery(UserFormedQuery);
        	query.setParameter("color", color);
        	query.setParameter("gender", gender);
        	query.setParameter("size", size);
        	query.setParameter("available", available);
        	results = query.list();
        }
        
        //Printing the List
        
        if(results.isEmpty())
        {
        	System.out.println("Tshirt Not Available");
        }
        else
        {
        	System.out.println();
        	System.out.println("<-----------Tshirts We Have According To Your Search Are----------->");
        	System.out.println();
	        for(Tshirt t : results)
	        {
	        	System.out.println(t);
	        	System.out.println();
	        }
        }
	}

}
